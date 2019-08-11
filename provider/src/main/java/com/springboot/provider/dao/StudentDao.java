package com.springboot.provider.dao;

import bean.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : 石建雷
 * @date :2019/8/11
 */
@Repository
public interface StudentDao {

    List<Student> findStudentList();

    int updateStudent(Student student);

    int deleteStudentById(Integer studentNum);

    Student selectStudentById(Integer studentNum);

}
