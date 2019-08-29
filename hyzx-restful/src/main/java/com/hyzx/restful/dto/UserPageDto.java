package com.hyzx.restful.dto;

import com.github.pagehelper.PageInfo;
import com.hyzx.restful.entity.User;

/**
 * @author huyue
 * @date 2019/8/29 14:33
 */
public class UserPageDto extends PageInfo<User> {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
