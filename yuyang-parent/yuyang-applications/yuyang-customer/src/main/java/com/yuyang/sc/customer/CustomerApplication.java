package com.yuyang.sc.customer;

import com.alibaba.csp.sentinel.transport.config.TransportConfig;
import com.yuyang.sc.common.util.redis.RedisCacheAutoConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * @author yuyang
 * @date 2020/5/9 15:55
 * @Description
 */
@SpringBootApplication
@EnableDiscoveryClient
@Import({RedisCacheAutoConfiguration.class})
@ComponentScan(basePackages = "com.yuyang.sc")
@EnableFeignClients(basePackages = "com.yuyang.sc.common.feign")
public class CustomerApplication {
    private static final Logger log = LoggerFactory.getLogger(CustomerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
        log.info("用户服务-启动成功........");
    }

}
