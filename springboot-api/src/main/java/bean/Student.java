package bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author : 石建雷
 * @date :2019/8/11
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
    private Integer id;
    private long stuNum;
    private String stuName;
    private Integer age;
    private long phoneNum;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", stuNum=" + stuNum +
                ", stuName='" + stuName + '\'' +
                ", age=" + age +
                ", phoneNum=" + phoneNum +
                '}';
    }
}
