package com.sinoiov.yqzjj.common.entity.customer.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author sinoiov
 * @date 2020/11/11 19:09
 * @Description
 */
@Data
@ApiModel
public class TestModel {
    @ApiModelProperty("ID")
    private Long id;
    @ApiModelProperty("内容")
    private String content;
}