package com.yuyang.sc.customer.test;

import com.yuyang.sc.common.feign.customer.CustomerBusinessFeign;
import org.springframework.beans.factory.annotation.Autowired;
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
