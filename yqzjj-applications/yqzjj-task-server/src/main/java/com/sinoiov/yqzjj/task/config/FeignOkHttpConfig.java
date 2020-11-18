package com.sinoiov.yqzjj.interfaces.config;

import feign.Feign;
import feign.codec.Encoder;
import feign.form.FormEncoder;
import okhttp3.ConnectionPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @author sinoiov
 * @date 2020/5/12 19:35
 * @Description
 */
@Configuration
@ConditionalOnClass(Feign.class)
@AutoConfigureBefore(FeignAutoConfiguration.class)
public class FeignOkHttpConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(FeignOkHttpConfig.class);

    @Bean
    public Encoder encoder() {
        return new FormEncoder();
    }

    @Bean
    public okhttp3.OkHttpClient okHttpClient(){
        okhttp3.OkHttpClient okHttpClient= new okhttp3.OkHttpClient.Builder()
                .readTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(1, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .connectionPool(new ConnectionPool())
                .build();
        LOGGER.info("OKHTTP初始化完成");
        return okHttpClient;

    }
}