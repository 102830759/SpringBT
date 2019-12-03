package com.hyzx.multidatasource.service;


import com.hyzx.multidatasource.pojo.Pager;
import com.hyzx.multidatasource.pojo.SfzQueryDto;
import com.hyzx.multidatasource.pojo.SfzRankResultDto;

/**
 * @author huyue
 * @date 2019/11/28 15:42
 */
public interface SfzService {
    Pager<SfzRankResultDto> getMySqlList(SfzQueryDto dto);
}
