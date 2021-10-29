package com.atguigu.springboot;

import com.atguigu.springboot.bean.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class Springboot03ConfigApplicationTests {
    @Resource
    private Person person;

    @Test
    void contextLoads() {
        System.out.println(person);
    }

}
