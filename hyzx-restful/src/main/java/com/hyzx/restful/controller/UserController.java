package com.hyzx.restful.controller;

import com.github.pagehelper.PageInfo;
import com.hyzx.restful.dto.UserPageDto;
import com.hyzx.restful.entity.User;
import com.hyzx.restful.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author huyue
 * @date 2019/8/28 17:15
 */
@Api(value = "UserController", description = "用户")
@Validated
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("详情")
    @GetMapping("/get")
    public User get(@RequestParam String id) {
        return userService.getbyId(id);
    }

    @ApiOperation("分页查询")
    @PostMapping("/page/query")
    public PageInfo<User> pageQuery(@RequestBody @Valid UserPageDto dto) {
        return userService.pageQuery(dto);
    }
}
