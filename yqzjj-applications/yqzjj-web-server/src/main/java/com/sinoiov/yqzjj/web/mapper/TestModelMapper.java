package com.sinoiov.yqzjj.web.mapper;

import com.sinoiov.yqzjj.common.entity.customer.model.TestModel;

public interface TestModelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TestModel record);

    int insertSelective(TestModel record);

    TestModel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TestModel record);

    int updateByPrimaryKey(TestModel record);
}