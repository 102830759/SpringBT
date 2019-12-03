package com.hyzx.multidatasource.service.impl;


import com.hyzx.multidatasource.mapper.SfzMapper;
import com.hyzx.multidatasource.pojo.Pager;
import com.hyzx.multidatasource.pojo.SfzQueryDto;
import com.hyzx.multidatasource.pojo.SfzRankResultDto;
import com.hyzx.multidatasource.service.SfzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author huyue
 * @date 2019/11/28 15:43
 */
@Service
public class SfzServiceImpl implements SfzService {

    @Autowired
    private SfzMapper sfzMapper;

    @Override
    public Pager<SfzRankResultDto> getMySqlList(SfzQueryDto dto) {

        Integer pageNum = dto.getCurrent();
        Integer pageSize = dto.getLimit();
        Pager<SfzRankResultDto> pager = new Pager<SfzRankResultDto>(pageNum,pageSize);
        dto.init();
        long total=sfzMapper.getTotal(dto);
        List<SfzRankResultDto> query = sfzMapper.query(dto);
        pager.setRows(query);
        pager.setPages(total);
        return pager;
    }
}
