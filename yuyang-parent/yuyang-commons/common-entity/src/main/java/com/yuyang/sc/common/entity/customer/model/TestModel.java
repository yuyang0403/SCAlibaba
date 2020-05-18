package com.yuyang.sc.common.entity.customer.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class TestModel {
    @ApiModelProperty("ID")
    private Long id;
    @ApiModelProperty("内容")
    private String content;
}