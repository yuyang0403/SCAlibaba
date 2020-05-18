package com.yuyang.sc.customer.service.impl;

import com.yuyang.sc.common.entity.customer.model.TestModel;
import com.yuyang.sc.common.feign.customer.CustomerBusinessFeign;
import com.yuyang.sc.customer.mapper.TestModelMapper;
import com.yuyang.sc.customer.service.CustomerBusinessService;
import com.yuyang.sc.customer.test.ProxyClass;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

/**
 * @author yuyang
 * @date 2020/5/11 9:57
 * @Description
 */
@Service
public class CustomerBusinessServiceImpl implements CustomerBusinessService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerBusinessServiceImpl.class);
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    RedissonClient redissonClient;
    @Autowired
    ProxyClass proxyClass;

    @Autowired
    TestModelMapper testModelMapper;
    public void testqqqq() {
        RLock rLock = redissonClient.getLock("test1");
        rLock.lock(10000,TimeUnit.MILLISECONDS);
        try {
            if(rLock.tryLock(10000,1,TimeUnit.MILLISECONDS)) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rLock.unlock();
        }
        LOGGER.info("------------");
    }

    @Override
    public void test() {
        LOGGER.info("调用feign接口");
        proxyClass.proxyTest();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer saveTest(TestModel testModel) {
        return testModelMapper.insertSelective(testModel);
    }
}
