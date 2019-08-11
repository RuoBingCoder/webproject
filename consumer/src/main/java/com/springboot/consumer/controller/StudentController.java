package com.springboot.consumer.controller;

import api.IStudentService;
import bean.Student;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author : 石建雷
 * @date :2019/8/11
 */
@Controller
public class StudentController {

    @Reference
    IStudentService iStudentService;

    @ResponseBody
    @GetMapping("/get_student")
    public List<Student> getStudent() {
        return iStudentService.getStudentList();
    }
    /**
     *
     * 其他三个方法同理
     */
}
