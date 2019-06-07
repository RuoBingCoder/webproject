package com.springboot.bootcrudpage.service;

import com.github.pagehelper.Page;
import com.springboot.bootcrudpage.pojo.Users;

import java.util.List;

/**
 * @author : 石建雷
 * @date :2019/6/3
 */
public interface UserService {

    int addUser(List<Users> users);

    Page<Users> findUsers(int pageCode, int pageSize, String userName);


    int count(String userName);

    int insertUser(Users users);

    int updateUser(Users users);

    int deleteUserById(Integer id);
}
