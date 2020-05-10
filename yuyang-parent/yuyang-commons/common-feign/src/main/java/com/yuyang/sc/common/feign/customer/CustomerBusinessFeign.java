package com.yuyang.sc.common.feign.customer;

import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@FeignClient(value="customer-server",fallbackFactory = CustomerBusinessFeignFallBack.class)
public interface CustomerBusinessFeign {
    String test();



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
}
