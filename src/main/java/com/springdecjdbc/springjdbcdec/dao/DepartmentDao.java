package com.springdecjdbc.springjdbcdec.dao;

import com.springdecjdbc.springjdbcdec.model.Department;
import com.springdecjdbc.springjdbcdec.model.Student;
import com.springdecjdbc.springjdbcdec.repos.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by abhi on 18/12/18.
 */
@Repository
public class DepartmentDao implements DepartmentRepo {

    @Autowired
   JdbcTemplate jdbcTemplate;

//    @Override
//    public String saveDept(Student st) {
//
//        String sql = "select * from department where deptid=?";
//
//        Department d1=jdbcTemplate.queryForObject(sql,new Object[]{department.getDeptName()},Department.class));
//
//        if(d1==null){
//            String sql1="insert into department values(?,?)";
//            jdbcTemplate.update(sql1,new Object[]{department.getId(),department.getDeptName()});
//            String sql2="insert into student values(?,?,?)";
//            jdbcTemplate.update(sql2,new Object[]{})
//            jdbcTemplate
//        }
//
//        return null;
//    }
}
