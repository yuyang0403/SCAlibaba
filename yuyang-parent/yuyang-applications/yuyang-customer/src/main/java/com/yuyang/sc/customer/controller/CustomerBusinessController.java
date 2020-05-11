package com.yuyang.sc.customer.controller;

import com.yuyang.sc.common.feign.customer.CustomerBusinessFeign;
import com.yuyang.sc.customer.service.CustomerBusinessService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "用户业务服务")
@RestController
public class CustomerBusinessController implements CustomerBusinessFeign {

    @Autowired
    CustomerBusinessService customerBusinessService;
    @ApiOperation(value = "测试方法",notes = "测试方法",response = String.class)
    @GetMapping("/testme")
    @Override
    public String test() {
        customerBusinessService.test();
        return "this is test me";
    }
}
