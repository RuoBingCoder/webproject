package com.springboot.bootcrudpage.service.impl;

import com.springboot.bootcrudpage.dao.UserLocalDao;
import com.springboot.bootcrudpage.pojo.User;
import com.springboot.bootcrudpage.service.LocalAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : 石建雷
 * @date :2019/6/7
 */
@Service
public class LocalAccountServiceImpl implements LocalAccountService {
    @Autowired
    private UserLocalDao localDao;

    @Override
    public User getLocalAccountByNameAndPassword(String name, String password) {
        return localDao.findAccountNumber(name, password);
    }
}
