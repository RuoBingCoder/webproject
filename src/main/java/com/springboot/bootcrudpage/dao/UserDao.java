package com.springboot.bootcrudpage.dao;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.springboot.bootcrudpage.pojo.Users;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author : 石建雷
 * @date :2019/6/3
 */
public interface UserDao {
    /**
     * 批量插入数据
     *
     * @param
     * @return
     */
    void insert(@Param("userList") List<Users> userList);

    /**
     * 分页查询
     *
     * @param
     * @return
     */
    Page<Users> findUsers(@Param("userName") String userName);

    int count(@Param("userName") String userName);

    int insertuser(@Param("user") Users user);

    int updateUser(@Param("user") Users user);

    int deleteUser(@Param("id") Integer id);
}
