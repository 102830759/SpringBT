package com.hyzx.features8.enums;

/**
 * 枚举实现单例模式,推荐使用这种方式
 *
 * @author huyue
 * @date 2019/8/29 18:34
 */
public class SingletonObject7 {

    private String name;

    private SingletonObject7() {

    }

    /**
     * 枚举类型是线程安全的，并且只会装载一次
     */
    private enum Singleton {
        INSTANCE;

        private final SingletonObject7 instance;

        Singleton() {
            instance = new SingletonObject7();
        }

        private SingletonObject7 getInstance() {
            return instance;
        }
    }

    public static SingletonObject7 getInstance() {

        return Singleton.INSTANCE.getInstance();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
