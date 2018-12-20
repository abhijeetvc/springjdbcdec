package com.springdecjdbc.springjdbcdec.controller;

import com.springdecjdbc.springjdbcdec.dao.DepartmentDao;
import com.springdecjdbc.springjdbcdec.dao.StudentDao;
import com.springdecjdbc.springjdbcdec.model.Department;
import com.springdecjdbc.springjdbcdec.model.Student;
import com.springdecjdbc.springjdbcdec.repos.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by abhi on 13/12/18.
 */

@RestController
public class StudentController {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private DepartmentDao departmentDao;

    @GetMapping(value="/getdata")
    public List<Student> getData(){

        List<Student> list=studentDao.getStudentList();
        return list;
    }

    @GetMapping(value="/getdata1/{id}")
    public Student getData(@PathVariable Integer id){
        Student st=studentDao.getStudent(id);
        return st;
    }

    @PostMapping(value="/save")
    public String saveStuData(@RequestBody Student student){

        return studentDao.saveData(student);

    }

    @GetMapping(value="/update/{id}/{name}")
    public String updateData(@PathVariable Integer id,@PathVariable String name){
        String str=studentDao.updateStudent(id,name);
        return str;
    }

    @GetMapping(value="/delete/{id}")
    public String deleteData(@PathVariable Integer id){
        String str=studentDao.deleteStudent(id);
        return str;
    }

    @PostMapping(value="/savedeptstu")
    public String saveStuDeptAndStu(@RequestBody Student student){

        Department d=student.getDepartment();
        //departmentDao.saveDept(d);
        studentDao.saveData(student);
        return studentDao.saveData(student);
    }



}
