package com.test.zxing.demo;

/**
 * @author huyue
 * @date 2019/6/17 16:31
 */
public enum Level {
    /**
     * 第一层
     */
    One(1),
    /**
     * 第二层
     */
    Two(2),
    /**
     * 第三层
     */
    Three(3),
    /**
     * 第四层
     */
    Four(4),
    /**
     * 第五层
     */
    Five(5);


    private int code;

    Level(int code) {
        this.code = code;
    }

    public int code() {
        return this.code;
    }

    public static void main(String[] args) {
        System.out.println(Level.Three.code());
    }
}
