package api;

import bean.Student;

import java.util.List;

/**
 * @author : 石建雷
 * @date :2019/8/11
 */

public interface IStudentService {

    List<Student> getStudentList();

    int updateStudent(Student student);

    int deleteStudent(Integer studentId);

    Student getStudent(Integer studentId);
}
