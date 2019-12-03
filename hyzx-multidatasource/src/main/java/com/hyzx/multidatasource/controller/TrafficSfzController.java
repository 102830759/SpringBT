package com.hyzx.multidatasource.controller;


import com.hyzx.multidatasource.pojo.Pager;
import com.hyzx.multidatasource.pojo.SfzQueryDto;
import com.hyzx.multidatasource.pojo.SfzRankResultDto;
import com.hyzx.multidatasource.service.SfzService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huyue
 * @date 2019/11/28 15:40
 */

@Api(description = "收费站")
@RestController
@RequestMapping("traffic/sfz")
public class TrafficSfzController {

    /**
     * logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TrafficSfzController.class);

    @Autowired
    private SfzService sfzService;

    @ApiOperation("分页查询")
    @PostMapping("sfz-rank-list")
    public Pager<SfzRankResultDto> getList(@RequestBody SfzQueryDto dto) {
        return sfzService.getMySqlList(dto);
    }
}
