package com.hyzx.easypoi.hyzxeasypoi.entity;

import java.util.Date;

/**
 * 施工日志 Entity
 *
 * @author gyh
 * @date 2019/05/08
 */
public class ProjectTaskLog {

    /**
     * 唯一标识, 自动生成
     */
    private String id;

    /**
     * 日志时间
     */
    private Date date;

    /**
     * 施工部位唯一标识
     */
    private String partId;

    /**
     * 施工部位名称
     */
    private String partName;

    /**
     * 施工内容
     */
    private String describe;

    /**
     * 填报人员唯一标识
     */
    private String userId;

    /**
     * 填报人员名称
     */
    private String userName;

    /**
     * 白天天气
     */
    private String dayWeather;

    /**
     * 夜间天气
     */
    private String nightWeather;

    /**
     * 白天备注
     */
        private String dayNote;

    /**
     * 夜间备注
     */
    private String nightNote;

    /**
     * 情况记录
     */
    private String conditionRecord;

    /**
     * 技术质量安全记录
     */
    private String securityRecord;

    /**
     * 物料, 设备使用记录
     */
    private String useRecord;

    /**
     * 白天风力
     */
    private String dayWind;

    /**
     * 夜间风力
     */
    private String nightWind;

    /**
     * 最高温度
     */
    private String highTemp;

    /**
     * 最低温度
     */
    private String lowTemp;

    public String getDayWind() {
        return dayWind;
    }

    public void setDayWind(String dayWind) {
        this.dayWind = dayWind;
    }

    public String getNightWind() {
        return nightWind;
    }

    public void setNightWind(String nightWind) {
        this.nightWind = nightWind;
    }

    public String getHighTemp() {
        return highTemp;
    }

    public void setHighTemp(String highTemp) {
        this.highTemp = highTemp;
    }

    public String getLowTemp() {
        return lowTemp;
    }

    public void setLowTemp(String lowTemp) {
        this.lowTemp = lowTemp;
    }

    public String getDayWeather() {
        return dayWeather;
    }

    public void setDayWeather(String dayWeather) {
        this.dayWeather = dayWeather;
    }

    public String getNightWeather() {
        return nightWeather;
    }

    public void setNightWeather(String nightWeather) {
        this.nightWeather = nightWeather;
    }

    public String getDayNote() {
        return dayNote;
    }

    public void setDayNote(String dayNote) {
        this.dayNote = dayNote;
    }

    public String getNightNote() {
        return nightNote;
    }

    public void setNightNote(String nightNote) {
        this.nightNote = nightNote;
    }

    public String getConditionRecord() {
        return conditionRecord;
    }

    public void setConditionRecord(String conditionRecord) {
        this.conditionRecord = conditionRecord;
    }

    public String getSecurityRecord() {
        return securityRecord;
    }

    public void setSecurityRecord(String securityRecord) {
        this.securityRecord = securityRecord;
    }

    public String getUseRecord() {
        return useRecord;
    }

    public void setUseRecord(String useRecord) {
        this.useRecord = useRecord;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPartId() {
        return partId;
    }

    public void setPartId(String partId) {
        this.partId = partId;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}