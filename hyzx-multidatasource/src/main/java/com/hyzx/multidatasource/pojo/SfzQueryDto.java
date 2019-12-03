package com.hyzx.multidatasource.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author huyue
 * @date 2019/11/28 15:44
 */
public class SfzQueryDto extends PageQuery {

    @ApiModelProperty("路线代码")
    private  String lxdm;
    @ApiModelProperty("路线名称")
    private String lxmc;
    @ApiModelProperty("行政区划")
    private List<String> xzqh;

    public String getLxdm() {
        return lxdm;
    }

    public void setLxdm(String lxdm) {
        this.lxdm = lxdm;
    }

    public String getLxmc() {
        return lxmc;
    }

    public void setLxmc(String lxmc) {
        this.lxmc = lxmc;
    }

    public List<String> getXzqh() {
        return xzqh;
    }

    public void setXzqh(List<String> xzqh) {
        this.xzqh = xzqh;
    }
}
