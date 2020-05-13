package com.yuyang.sc.customer.test;

import com.yuyang.sc.common.feign.customer.CustomerBusinessFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProxyClass {
    @Autowired
    CustomerBusinessFeign customerBusinessFeign;
    public void proxyTest(){
        System.out.println(customerBusinessFeign.test1());
    }
}
