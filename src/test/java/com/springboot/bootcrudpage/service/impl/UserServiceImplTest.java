package com.springboot.bootcrudpage.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.springboot.bootcrudpage.BootCrudPageApplicationTests;
import com.springboot.bootcrudpage.pojo.PageBean;
import com.springboot.bootcrudpage.pojo.Users;
import com.springboot.bootcrudpage.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImplTest extends BootCrudPageApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void findUserList() {

        Page<Users> page = userService.findUsers(2, 10, "t");
        for (Users users : page) {
            System.out.println(users.toString());
        }


    }

}