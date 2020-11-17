package com.sinoiov.yqzjj.customer.controller;

import com.sinoiov.yqzjj.common.entity.customer.model.TestModel;
import com.sinoiov.yqzjj.common.entity.demo.condition.DemoCondition;
import com.sinoiov.yqzjj.common.entity.demo.vo.DemoVO;
import com.sinoiov.yqzjj.common.feign.customer.CustomerBusinessFeign;
import com.sinoiov.yqzjj.common.util.response.ResponseResult;
import com.sinoiov.yqzjj.customer.service.CustomerBusinessService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author sinoiov
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
        customerBusinessService.testRedission();
        return new ResponseResult<>();
    }


    @ApiOperation(value = "数据库保存测试",notes = "数据库保存测试",response = String.class)
    @Override
    public ResponseResult<Integer> saveTest(@RequestBody TestModel testModel){
        ResponseResult<Integer> responseResult=new ResponseResult<>();
        responseResult.setData(customerBusinessService.saveTest(testModel));
        return responseResult;
    }

    @ApiOperation(value = "demoFeign调用",notes = "demoFeign调用",response = DemoVO.class)
    @Override
    public ResponseResult<DemoVO> demoFeign(@RequestBody DemoCondition demoCondition) {
        DemoVO demoVO=new DemoVO();
        demoVO.setProperty1(UUID.randomUUID().toString());
        demoVO.setProperty2(UUID.randomUUID().toString());
        return new ResponseResult<>(demoVO);
    }
}
