package com.hyzx.features8.enums;

/**
 * enum 实现单例模式,不仅仅是单例
 *
 * @author huyue
 * @date 2019/8/29 18:26
 */

public enum SingletonEnum {
    //定义一个枚举的元素，就代表INSTANCE01的一个实例
    INSTANCE01, INSTANCE02;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

