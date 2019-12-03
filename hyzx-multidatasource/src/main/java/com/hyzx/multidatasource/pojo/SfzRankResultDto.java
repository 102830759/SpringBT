package com.hyzx.multidatasource.pojo;

/**
 * @author huyue
 * @date 2019/11/28 15:48
 */
public class SfzRankResultDto {
    private String id;
    private String name;
    private Double ptx;
    private Double pty;
    private Integer inNum;
    private Integer outNum;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPtx() {
        return ptx;
    }

    public void setPtx(Double ptx) {
        this.ptx = ptx;
    }

    public Double getPty() {
        return pty;
    }

    public void setPty(Double pty) {
        this.pty = pty;
    }

    public Integer getInNum() {
        return inNum;
    }

    public void setInNum(Integer inNum) {
        this.inNum = inNum;
    }

    public Integer getOutNum() {
        return outNum;
    }

    public void setOutNum(Integer outNum) {
        this.outNum = outNum;
    }
}
