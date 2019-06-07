package com.springboot.bootcrudpage.dao;

import com.springboot.bootcrudpage.BootCrudPageApplicationTests;
import com.springboot.bootcrudpage.pojo.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class UserLocalDaoTest extends BootCrudPageApplicationTests {
    @Autowired
    UserLocalDao localDao;

    @Test
    public void login() {
        User user = localDao.findAccountNumber("黑暗之神", "123456");
        System.out.println(user.getUserName());
    }


}