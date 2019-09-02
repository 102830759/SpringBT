package com.hyzx.restful.dto;

import com.github.pagehelper.PageInfo;
import com.hyzx.restful.entity.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author huyue
 * @date 2019/8/29 14:33
 */
@ApiModel("用户分页查询")
public class UserPageDto extends PageInfo<User> {

    @ApiModelProperty("姓名")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
