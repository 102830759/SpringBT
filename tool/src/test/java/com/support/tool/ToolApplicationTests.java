package com.support.tool;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class ToolApplicationTests {

    @Test
    public void contextLoads() {
        Integer a = new Integer(30);
        Integer b = new Integer(30);
        int c=30;
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
        System.out.println(a==b);
        System.out.println(a==c);
    }

}
