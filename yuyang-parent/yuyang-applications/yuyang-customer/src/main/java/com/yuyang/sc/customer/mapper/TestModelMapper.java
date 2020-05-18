package com.yuyang.sc.customer.mapper;

import com.yuyang.sc.common.entity.customer.model.TestModel;

public interface TestModelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TestModel record);

    int insertSelective(TestModel record);

    TestModel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TestModel record);

    int updateByPrimaryKey(TestModel record);
}