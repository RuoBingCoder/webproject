package com.springboot.bootcrudpage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : 石建雷
 * @date :2019/6/3
 */
@Controller
@RequestMapping("/user")
public class MainController {

    @GetMapping("/list")
    public String index() {
        return "userlist";

    }

    @GetMapping("/adduserfrom")
    public String addUserFrom() {
        return "changeStor";

    }

    @GetMapping("/index")
    public String Login() {
        return "index";

    }
}
