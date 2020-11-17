package com.sinoiov.yqzjj.common.feign.customer;

import com.sinoiov.yqzjj.common.entity.customer.model.TestModel;
import com.sinoiov.yqzjj.common.entity.demo.condition.DemoCondition;
import com.sinoiov.yqzjj.common.entity.demo.vo.DemoVO;
import com.sinoiov.yqzjj.common.util.exception.BusinessCode;
import com.sinoiov.yqzjj.common.util.response.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * @author sinoiov
 * @date 2020/5/12 19:37
 * @Description
 */
@FeignClient(value="${server.name.customer}",path = "${server.context-path.customer}",fallback = CustomerBusinessFeignFallBack.class)
public interface CustomerBusinessFeign {

    @RequestMapping(method = RequestMethod.POST,value="/test")
    ResponseResult<String> test();
    @RequestMapping(method = RequestMethod.POST,value="/test1")
    ResponseResult<String> test1();
    @RequestMapping(method = RequestMethod.POST,value="/saveTest")
    ResponseResult<Integer> saveTest(@RequestBody TestModel testModel);

    /**
     * DemoFeign
     * @param demoCondition
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value="/demoFeign")
    ResponseResult<DemoVO> demoFeign(@RequestBody DemoCondition demoCondition);


}

@Component
class CustomerBusinessFeignFallBack implements CustomerBusinessFeign {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerBusinessFeignFallBack.class);

    @Override
    public ResponseResult<String> test() {
        LOGGER.error("CustomerBusinessFeignFallBack->test");
        return new ResponseResult<>(BusinessCode.CODE_999);
    }

    @Override
    public ResponseResult<String> test1() {
        LOGGER.error("CustomerBusinessFeignFallBack->test1");
        return new ResponseResult<>(BusinessCode.CODE_999);
    }

    @Override
    public ResponseResult<Integer> saveTest(TestModel testModel) {
        LOGGER.error("CustomerBusinessFeignFallBack->saveTest");
        return new ResponseResult<>(BusinessCode.CODE_999);
    }

    @Override
    public ResponseResult<DemoVO> demoFeign(DemoCondition demoCondition) {
        LOGGER.error("CustomerBusinessFeignFallBack->demoFeign");
        return new ResponseResult<>(BusinessCode.CODE_999);
    }
}
