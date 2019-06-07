package com.springboot.bootcrudpage.service;

import com.springboot.bootcrudpage.pojo.User;

/**
 * @author : 石建雷
 * @date :2019/6/7
 */

public interface LocalAccountService {

    User getLocalAccountByNameAndPassword(String name, String password);
}
