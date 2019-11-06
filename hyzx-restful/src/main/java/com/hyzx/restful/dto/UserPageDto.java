package com.hyzx.restful.dto;

import com.hyzx.restful.api.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;

/**
 * @author huyue
 * @date 2019/8/29 14:33
 */
@Accessors(chain = true)
@Setter
@Getter
@RequiredArgsConstructor(staticName = "of")
@ApiModel("用户分页查询")
public class UserPageDto extends PageQuery {

    @ApiModelProperty("姓名")
    @NotEmpty(message = "姓名不能为空")
    private String name;

}
