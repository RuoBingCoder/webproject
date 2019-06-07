package com.springboot.bootcrudpage.dao;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.springboot.bootcrudpage.BootCrudPageApplicationTests;
import com.springboot.bootcrudpage.pojo.Users;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserDaoTest extends BootCrudPageApplicationTests {

    @Autowired
    private UserDao userDao;


    @Test
    public void insertUserListTest() {

        List<Users> userList = new ArrayList<>();
        int num = 40;
        for (int i = 0; i < num; i++) {
            String uuid = UUID.randomUUID().toString().substring(0, 4);
            userList.add(new Users(uuid + "张三" + i, i + 10, 182352722 + i));

        }
        userDao.insert(userList);

    }

    @Test
    public void findAllUsers() {
        PageHelper.startPage(1, 10);
        Page<Users> usersPage = userDao.findUsers("t");
        for (Users users : usersPage) {
            System.out.println("=================" + users.toString());
        }
    }

    @Test
    public void countTest() {
        int count = userDao.count(null);
        System.out.println(count);

    }

    @Test
    public void insertUser() {
        Users users = new Users("李华", 21, 1823353432);
        int num = userDao.insertuser(users);
        Assert.assertEquals(1, num);
    }

    @Test
    public void updateUser() {
        Users users = new Users(1, "李楠", 27, 12345678);
        int num = userDao.updateUser(users);
        Assert.assertEquals(1, num);
    }
    @Test
    public void deleteUser() {

        int num = userDao.deleteUser(53);
        Assert.assertEquals(1, num);
    }
}