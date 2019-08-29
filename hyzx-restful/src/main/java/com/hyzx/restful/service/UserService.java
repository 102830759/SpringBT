package com.hyzx.restful.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hyzx.restful.dto.UserPageDto;
import com.hyzx.restful.entity.User;
import com.hyzx.restful.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author huyue
 * @date 2019/8/29 14:27
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 分页功能
     * 具体用法  https://github.com/pagehelper/Mybatis-PageHelper/blob/master/wikis/zh/HowToUse.md
     * @author huy
     * @date 16:16 2019/8/29
     * @param dto
     * @return com.github.pagehelper.Page<com.hyzx.restful.entity.User>
     */
    public PageInfo<User> pageQuery(UserPageDto dto) {
       /* PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
        //紧跟着的第一个select方法会被分页
        List<User> users = userMapper.pageQuery(dto);
        return new PageInfo(users);*/

        //jdk8 lambda用法
        return PageHelper.startPage(dto.getPageNum(), dto.getPageSize()).doSelectPageInfo(() -> userMapper.pageQuery(dto));

    }

    public User getbyId(String id) {
        return userMapper.selectById(id);
    }
}
