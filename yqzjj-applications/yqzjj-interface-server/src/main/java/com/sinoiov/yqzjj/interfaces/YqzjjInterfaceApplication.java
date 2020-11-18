package com.sinoiov.yqzjj.interfaces;

import com.sinoiov.yqzjj.common.util.config.ServerConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author sinoiov
 * @date 2020/5/9 15:55
 * @Description
 */
@SpringBootApplication
@EnableDiscoveryClient
@Import({ServerConfiguration.class})
@ComponentScan(basePackages = "com.sinoiov.yqzjj")
@EnableFeignClients(basePackages = "com.sinoiov.yqzjj.common.feign")
@MapperScan("com.sinoiov.yqzjj.interfaces.mapper")
@EnableAsync
public class YqzjjInterfaceApplication {
    private static final Logger log = LoggerFactory.getLogger(YqzjjInterfaceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(YqzjjInterfaceApplication.class, args);
        log.info("接口服务-启动成功........");
    }

}
