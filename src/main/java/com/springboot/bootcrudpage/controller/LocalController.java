package com.springboot.bootcrudpage.controller;

import com.springboot.bootcrudpage.enums.UserEnum;
import com.springboot.bootcrudpage.pojo.User;
import com.springboot.bootcrudpage.service.LocalAccountService;
import com.springboot.bootcrudpage.service.UserService;
import com.springboot.bootcrudpage.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author : 石建雷
 * @date :2019/6/7
 */
@RestController
@RequestMapping("/user")
public class LocalController {

    @Autowired
    private LocalAccountService localAccountService;

    @PostMapping("/login")
    public Result Login(HttpServletRequest request) {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        if (userName != null && password != null) {
            User user = localAccountService.getLocalAccountByNameAndPassword(userName, password);
            request.getSession().setAttribute("user", user);
            if (user != null) {
                return Result.success(UserEnum.USER_LOGIN_SUCCESS);
            } else {
                return Result.error(UserEnum.USER_LOGIN_FAIL);
            }
        } else {
            return Result.error(UserEnum.USER_MSG_NULL);
        }

    }
}
