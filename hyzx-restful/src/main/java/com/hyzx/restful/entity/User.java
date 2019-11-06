package com.hyzx.restful.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author huyue
 * @date 2019/8/28 17:16
 */
@Accessors(chain = true)
@Getter
@Setter
@RequiredArgsConstructor(staticName = "of")
@TableName(value = "t_sec_user")
public class User {
    /**
     *ID
     */
    @TableId
    @ApiModelProperty("ID")
    private String id;
    /**
     *用户名
     */
    @ApiModelProperty("用户名")
    private String username;
    /**
     *密码
     */
    @ApiModelProperty("密码")
    private String password;
    /**
     *手机号
     */
    @ApiModelProperty("手机号")
    private String cellphone;
    /**
     *邮箱
     */
    @ApiModelProperty("邮箱")
    private String mail;
    /**
     *创建时间
     */
    @ApiModelProperty("创建时间")
    private Date gmtCreate;
    /**
     *修改时间
     */
    @ApiModelProperty("修改时间")
    private Date gmtModified;
    /**
     *部门ID
     */
    @ApiModelProperty("部门ID")
    private String departmentId;
    /**
     *真实姓名
     */
    @ApiModelProperty("真实姓名")
    private String realName;
    /**
     *备注
     */
    @ApiModelProperty("备注")
    private String remark;
    /**
     *用户状态：0：禁用，1：启动
     */
    @ApiModelProperty("用户状态：0：禁用，1：启动")
    private Integer status;

}
