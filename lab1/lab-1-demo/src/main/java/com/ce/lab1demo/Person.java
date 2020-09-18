package com.ce.lab1demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


/**
 * @author c__e
 * @date Created in 2020/9/18 20:59
 */
@Component
@PropertySource(value = "classpath:lalala.properties", encoding = "UTF-8")
@ConfigurationProperties(prefix = "person")
public class Person {
    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
