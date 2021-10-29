package com.atguigu.springboot.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@Component
@ConfigurationProperties(prefix = "person")
// 启用数据校验
@Validated
public class Person {
    private String lastName;
    private Integer age;
    private Boolean boss;
    private Date birthDate;
    private Map<String, Object> maps;
    private List<Object> lists;
    private Dog dog;
}
