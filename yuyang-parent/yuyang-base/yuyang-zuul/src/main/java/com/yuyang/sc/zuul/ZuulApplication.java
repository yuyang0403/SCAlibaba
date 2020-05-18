package com.yuyang.sc.zuul;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author yuyang
 * @date 2020/5/9 15:55
 * @Description
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication {
    private static final Logger log = LoggerFactory.getLogger(ZuulApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
        log.info("网关服务-启动成功........");
    }

}