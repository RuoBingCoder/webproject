package com.springboot.bootcrudpage.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.bootcrudpage.dao.UserDao;
import com.springboot.bootcrudpage.pojo.PageBean;
import com.springboot.bootcrudpage.pojo.Users;
import com.springboot.bootcrudpage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author : 石建雷
 * @date :2019/6/3
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public int addUser(List<Users> users) {
        List<Users> usersList = new ArrayList<>();
        int num = 40;
        for (int i = 0; i < num; i++) {
            String uuid = UUID.randomUUID().toString().substring(0, 4);
            usersList.add(new Users(uuid + "张三" + i, i + 10, 182352722 + i));

        }
        userDao.insert(usersList);

        return 0;
    }

    /**
     * 分页查询
     *
     * @param
     * @param pageCode
     * @param pageSize
     * @return
     */
    @Override
    public Page<Users> findUsers(int pageCode, int pageSize, String pageName) {
        PageHelper.startPage(pageCode, pageSize);
        Page<Users> usersPage = userDao.findUsers(pageName);
        return usersPage;
    }

   /* @Override
    public Page<Users> findUserByName(String userName) {
        Page<Users> page = userDao.findUsers(userName);
        return page;
    }*/

    @Override
    public int count(String userName) {
        return userDao.count(userName);
    }

    @Override
    public int insertUser(Users users) {
        return userDao.insertuser(users);
    }

    @Override
    public int updateUser(Users users) {
        if (users.getId() != -1) {
            int num = userDao.updateUser(users);
            if (num != -1) {
                return num;
            }
        }
        return -1;

    }

    @Override
    public int deleteUserById(Integer id) {
        return userDao.deleteUser(id);
    }
}
