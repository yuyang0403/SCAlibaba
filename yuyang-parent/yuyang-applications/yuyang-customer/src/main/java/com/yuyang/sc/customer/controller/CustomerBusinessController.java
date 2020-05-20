package com.yuyang.sc.customer.controller;

import com.yuyang.sc.common.entity.customer.model.TestModel;
import com.yuyang.sc.common.feign.customer.CustomerBusinessFeign;
import com.yuyang.sc.common.util.response.ResponseResult;
import com.yuyang.sc.customer.service.CustomerBusinessService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author yuyang
 * @date 2020/5/12 19:38
 * @Description
 */
@Api(tags = "用户业务服务")
@RestController
public class CustomerBusinessController implements CustomerBusinessFeign {

    @Autowired
    CustomerBusinessService customerBusinessService;

    @ApiOperation(value = "测试方法",notes = "测试方法",response = String.class)
    @Override
    public ResponseResult<String> test() {
        customerBusinessService.test();
        return new ResponseResult<>();
    }

    @ApiOperation(value = "测试方法1",notes = "测试方法1",response = String.class)
    @Override
    public ResponseResult<String> test1() {
        return new ResponseResult<>();
    }

    @PostMapping(value="/saveTest")
    @ApiOperation(value = "数据库保存测试",notes = "数据库保存测试",response = String.class)
    public ResponseResult<Integer> saveTest(@RequestBody TestModel testModel){
        ResponseResult<Integer> responseResult=new ResponseResult<>();
        responseResult.setData(customerBusinessService.saveTest(testModel));
        return responseResult;
    }
}
