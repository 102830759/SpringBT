package com.hyzx.multidatasource.mapper;

import com.hyzx.multidatasource.config.DataSource;
import com.hyzx.multidatasource.config.DataSourceType;
import com.hyzx.multidatasource.pojo.SfzQueryDto;
import com.hyzx.multidatasource.pojo.SfzRankResultDto;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author huyue
 * @date 2019/8/8 13:56
 */
@Repository
public interface SfzMapper {

    /**
     * 分页查询
     * @author huy
     * @date 15:55 2019/11/28
     * @param dto
     * @return java.util.List<com.ztjz.roims.traffic.impl.pojo.dto.SfzRankResultDto>
     */
    List<SfzRankResultDto> query(SfzQueryDto dto);

    /**
     * sdsd
     * @author huy
     * @date 12:00 2019/12/2
     * @param dto
     * @return long
     */
    long getTotal(SfzQueryDto dto);
}
