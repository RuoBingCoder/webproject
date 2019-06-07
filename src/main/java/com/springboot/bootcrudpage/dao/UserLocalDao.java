package com.springboot.bootcrudpage.dao;

import com.springboot.bootcrudpage.pojo.User;

/**
 * @author : 石建雷
 * @date :2019/6/7
 */

public interface UserLocalDao {

    public User findAccountNumber(String username, String password);

}
