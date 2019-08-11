package com.springboot.provider.dao;

import bean.Student;
import com.springboot.provider.ProviderApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentDaoTest extends ProviderApplicationTests {

    @Autowired
    private StudentDao studentDao;
    @Test
    public void findListTest() {
        List<Student> studentList = studentDao.findStudentList();
        System.out.println(studentList.toString());
    }

}