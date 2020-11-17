package com.sinoiov.yqzjj.web.service;

import com.sinoiov.yqzjj.common.entity.customer.model.TestModel;
import com.sinoiov.yqzjj.common.entity.demo.condition.DemoCondition;
import com.sinoiov.yqzjj.common.entity.demo.vo.DemoVO;

/**
 * @author sinoiov
 * @date 2020/5/11 9:56
 * @Description
 */
public interface DemoBusinessService {
    /**
     * demo service
     * @param condition
     * @return
     */
    DemoVO demoService(DemoCondition condition);
}
