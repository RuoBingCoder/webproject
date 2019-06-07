package com.springboot.bootcrudpage.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author : 石建雷
 * @date :2019/6/3
 */
@Setter
@Getter
public class Users implements Serializable {

    private Integer id;
    private String userName;
    private Integer age;
    private Integer phoneNumber;

    public Users() {
    }

    public Users(Integer id, String userName, Integer age, Integer phoneNumber) {
        this.id = id;
        this.userName = userName;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public Users(String userName, Integer age, Integer phoneNumber) {
        this.userName = userName;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
