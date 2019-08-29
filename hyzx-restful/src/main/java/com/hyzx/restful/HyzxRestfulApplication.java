package com.hyzx.restful;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hyzx.restful.mapper")
public class HyzxRestfulApplication {

    public static void main(String[] args) {
        SpringApplication.run(HyzxRestfulApplication.class, args);
    }

}
