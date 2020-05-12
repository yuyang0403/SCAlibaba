package com.yuyang.sc.common.feign.customer;

import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * @author yuyang
 * @date 2020/5/12 19:37
 * @Description
 */
@FeignClient(value="${server.name.customer}",path = "${server.context-path.customer}",fallbackFactory = CustomerBusinessFeignFallBack.class)
public interface CustomerBusinessFeign {
    @RequestMapping(method = RequestMethod.POST,value="/test")
    String test();
    @RequestMapping(method = RequestMethod.POST,value="/test1")
    String test1();


}

@Component
class CustomerBusinessFeignFallBack implements CustomerBusinessFeign,FallbackFactory<CustomerBusinessFeign> {
    private Throwable throwable;

    public CustomerBusinessFeignFallBack() {
    }
    public CustomerBusinessFeignFallBack(Throwable throwable) {
        this.throwable = throwable;
    }

    @Override
    public CustomerBusinessFeign create(Throwable throwable) {
        return new CustomerBusinessFeignFallBack(throwable);
    }

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
