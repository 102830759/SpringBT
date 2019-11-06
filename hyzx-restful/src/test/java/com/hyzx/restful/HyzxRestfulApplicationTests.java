package com.hyzx.restful;

import com.hyzx.restful.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class HyzxRestfulApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void sss(){
        User user= User.of().setRealName("å¼ ä¸‰").setCellphone("13233853721");
        System.out.println(user.getCellphone());
    }
}
