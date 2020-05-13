package com.yuyang.sc.common.feign.customer;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * @author yuyang
 * @date 2020/5/12 19:37
 * @Description
 */
@FeignClient(value="${server.name.customer}",path = "${server.context-path.customer}",fallback = CustomerBusinessFeignFallBack.class)
public interface CustomerBusinessFeign {

    @RequestMapping(method = RequestMethod.POST,value="/test")
    String test();
    @RequestMapping(method = RequestMethod.POST,value="/test1")
    String test1();


}

@Component
class CustomerBusinessFeignFallBack implements CustomerBusinessFeign {

    @Override
    public String test() {
        System.out.println("啥都没做");
        return "fallback";
    }

    @Override
    public String test1() {
        return "fallback test1";
    }
}
