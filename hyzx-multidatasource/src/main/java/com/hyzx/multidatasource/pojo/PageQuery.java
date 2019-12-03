package com.hyzx.multidatasource.pojo;

import io.swagger.annotations.ApiModelProperty;

/**
 * 分页查询参数
 * @author wusq
 * @date 2019/2/16
 */
public class PageQuery {

    /**
     * 起始数量
     */
    @ApiModelProperty("起始数量")
    protected Integer offset;

    /**
     * 每页显示数量
     */
    @ApiModelProperty("每页显示数量")
    protected Integer limit;

    /**
     * 当前页数
     */
    @ApiModelProperty("当前页数")
    protected Integer current;

    public void init(){

        // 默认查询第1页
        if(current == null || current < 1){
            current = 1;
        }

        // 默认每页显示10条数据
        if(limit == null || limit < 1){
            limit = 10;
        }

        // 设置最大限制，防止恶意查询大数据量
        if(limit > 1000){
            limit = 1000;
        }
        offset = (current - 1) * limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }
}
