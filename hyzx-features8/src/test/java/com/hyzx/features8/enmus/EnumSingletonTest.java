package com.hyzx.features8.enmus;

import com.hyzx.features8.enums.SingletonEnum;
import com.hyzx.features8.enums.SingletonObject7;
import org.junit.Test;

/**
 * @author huyue
 * @date 2019/8/29 18:35
 */
public class EnumSingletonTest {

    @Test
    public void sss1() {
        SingletonEnum instance01 = SingletonEnum.INSTANCE01;
        instance01.setName("INSTANCE01");
        System.out.println(instance01.getName());

        SingletonEnum instance02 = SingletonEnum.INSTANCE01;
        System.out.println(instance02.getName());

        SingletonEnum instance03 = SingletonEnum.INSTANCE02;
        instance03.setName("INSTANCE02");
        System.out.println(instance03.getName());

        SingletonEnum instance04 = SingletonEnum.INSTANCE02;
        System.out.println(instance04.getName());
    }

    @Test
    public void sss2() {
        SingletonObject7 instance = SingletonObject7.getInstance();
        instance.setName("11111111111111");
        SingletonObject7 instance2 = SingletonObject7.getInstance();
        System.out.println(instance2.getName());
    }
}
