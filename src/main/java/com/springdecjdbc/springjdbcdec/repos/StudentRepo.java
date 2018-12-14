package com.springdecjdbc.springjdbcdec.repos;

import com.springdecjdbc.springjdbcdec.model.Student;

import java.util.List;

/**
 * Created by abhi on 13/12/18.
 */
public interface StudentRepo {

    List<Student> getStudentList();

    Student getStudent(Integer id);

    String saveData(Student stu);

    String updateStudent(Integer id,String name);

    String deleteStudent(Integer id);
}
