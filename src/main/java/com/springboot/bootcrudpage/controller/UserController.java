package com.springboot.bootcrudpage.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.springboot.bootcrudpage.enums.UserEnum;
import com.springboot.bootcrudpage.exception.UserException;
import com.springboot.bootcrudpage.pojo.Users;
import com.springboot.bootcrudpage.service.UserService;
import com.springboot.bootcrudpage.util.HttpRequestServletUtil;
import com.springboot.bootcrudpage.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : 石建雷
 * @date :2019/6/3
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/userlist")
    public Map<String, Object> userList(HttpServletRequest request) {
        String page = request.getParameter("page");
        String userName = request.getParameter("userName");
        int pageNum = Integer.parseInt(page);
        Map<String, Object> modelMap = new HashMap<>(20);
        Page<Users> pageUser = userService.findUsers(pageNum, 10, userName);
        modelMap.put("code", 0);
        modelMap.put("msg", "");
        modelMap.put("page", pageNum);
        modelMap.put("count", userService.count(userName));
        modelMap.put("data", pageUser.getResult());
        return modelMap;

    }


    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public Result addUser(HttpServletRequest request) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String userStr = HttpRequestServletUtil.getFormDataString(request, "userStr");
        Users users = mapper.readValue(userStr, Users.class);
        if (users != null) {
            int num = userService.insertUser(users);
            if (num != -1) {
                return Result.success(UserEnum.SUCCESS);
            } else {
                return Result.error(UserEnum.ADD_USER_ERROR);
            }
        } else {
            return Result.error(UserEnum.USER_MSG_NULL);
        }

    }

    @PostMapping("/updateuser")
    public Result updateUser(HttpServletRequest request) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String userStr = HttpRequestServletUtil.getFormDataString(request, "userStr");
        Users users = mapper.readValue(userStr, Users.class);
        if (users != null) {
            try {
                int num = userService.updateUser(users);
                if (num != -1) {
                    return Result.success(UserEnum.UPDATE_USER_SUCCESS);
                } else {
                    return Result.error(UserEnum.UPDATE_USER_FAIL);
                }
            } catch (Exception e) {
                throw new UserException();
            }
        } else {
            return Result.error(UserEnum.USER_MSG_NULL);
        }

    }

    @GetMapping("/deleteuser")
    public Result deleteUser(Integer id) {
        if (id != null) {
            int num = userService.deleteUserById(id);
            if (num != -1) {
                return Result.success(UserEnum.DELETE_SUCCESS);
            } else {
                return Result.error(UserEnum.DELETE_FAIL);
            }
        } else {
            return Result.error(UserEnum.USER_MSG_NULL);
        }
    }
}
