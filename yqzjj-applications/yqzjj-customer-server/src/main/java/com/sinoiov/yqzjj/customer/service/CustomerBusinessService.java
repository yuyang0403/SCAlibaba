package com.sinoiov.yqzjj.customer.service;

import com.sinoiov.yqzjj.common.entity.customer.model.TestModel;

/**
 * @author sinoiov
 * @date 2020/5/11 9:56
 * @Description
 */
public interface CustomerBusinessService {
    void test();
    Integer saveTest(TestModel testModel);
    void testRedission();
}
