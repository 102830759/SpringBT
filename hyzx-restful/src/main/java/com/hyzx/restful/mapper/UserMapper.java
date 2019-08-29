package com.hyzx.restful.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hyzx.restful.dto.UserPageDto;
import com.hyzx.restful.entity.User;

import java.util.List;

/**
 * @author huyue
 * @date 2019/8/29 14:28
 */
public interface UserMapper extends BaseMapper<User> {
    /**
     * 分页查询
     *
     * @param dto
     * @return java.util.List<com.hyzx.restful.entity.User>
     * @author huy
     * @date 15:17 2019/8/29
     */
    List<User> pageQuery(UserPageDto dto);
}
