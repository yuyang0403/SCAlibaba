package com.sinoiov.yqzjj.customer.test;

import com.sinoiov.yqzjj.common.feign.customer.CustomerBusinessFeign;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ProxyClass {
    @Resource
    CustomerBusinessFeign customerBusinessFeign;
    public void proxyTest(){
        System.out.println(customerBusinessFeign.test1());
    }
}
