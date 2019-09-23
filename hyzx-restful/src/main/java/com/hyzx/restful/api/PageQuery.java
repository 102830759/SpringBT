package com.hyzx.restful.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @author huyue
 * @date 2019/9/23 14:12
 */
@Getter
@Setter
@ApiModel("分页差数")
public class PageQuery {
    /**
     * 当前页
     */
    @ApiModelProperty("当前页")
    @Min(value = 1, message = "当前页不小于1")
    private int pageNum;
    /**
     * 每页的数量
     */
    @Min(value = 1, message = "分页数量1-1000")
    @Max(value = 1000, message = "分页数量1-1000")
    @ApiModelProperty("每页的数量")
    private int pageSize;
}
