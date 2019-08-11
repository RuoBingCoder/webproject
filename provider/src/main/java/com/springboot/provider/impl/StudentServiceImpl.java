package com.springboot.provider.impl;

import api.IStudentService;
import bean.Student;
import com.springboot.provider.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : 石建雷
 * @date :2019/8/11
 */
@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> getStudentList() {
        return studentDao.findStudentList();
    }

    @Override
    public int updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }

    @Override
    public int deleteStudent(Integer studentId) {
        return studentDao.deleteStudentById(studentId);
    }

    @Override
    public Student getStudent(Integer studentId) {
        return studentDao.selectStudentById(studentId);
    }
}
