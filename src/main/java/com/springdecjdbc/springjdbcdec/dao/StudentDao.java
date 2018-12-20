package com.springdecjdbc.springjdbcdec.dao;

import com.springdecjdbc.springjdbcdec.model.Department;
import com.springdecjdbc.springjdbcdec.model.Student;
import com.springdecjdbc.springjdbcdec.repos.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;
import java.util.Map;

/**
 * Created by abhi on 13/12/18.
 */

@Repository
public class StudentDao implements StudentRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Student> getStudentList() {
        String sql="select * from student";
        List<Student> list=jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Student.class));
        return list;
    }

    @Override
    public Student getStudent(Integer id) {
        String sql="select * from student where id=?";
        Student stu=jdbcTemplate.
                queryForObject(sql,new Object[]{id},new BeanPropertyRowMapper<>(Student.class));
        return stu;
    }

    @Override
    public String saveData(Student stu) {
        String sql="insert into student values(?,?,?)";
        jdbcTemplate.update(sql,new Object[]{stu.getId(),stu.getName(),stu.getCity()});
        return "Data inserted";
    }

    @Override
    public String updateStudent(Integer id, String name) {
        String sql="update student set name=? where id=?";
        jdbcTemplate.update(sql,new Object[]{name,id},new int[]{Types.VARCHAR,Types.INTEGER});
        return "Data updated";
    }

    @Override
    public String deleteStudent(Integer id) {

        String sql="delete from student where id=?";
        jdbcTemplate.update(sql,new Object[]{id},new int[]{Types.INTEGER});
        return "Data deleted";
    }



    @Override
    public String saveData1(Student stu) {
        String sql = "select * from department where deptid=?";

        String sql3="select a.id, a.deptname,b.name,b.city from department a,student b where" +
                " a.id=b.deptid";

        List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);

        Department d1=jdbcTemplate.queryForObject(sql,new Object[]{stu.getDepartment().getDeptName()},
                Department.class);

        if(d1==null) {
            String sql1 = "insert into department values(?,?)";
            jdbcTemplate.update(sql1, new Object[]{stu.getDepartment().getId(),
                    stu.getDepartment().getDeptName()});

            String sql2 = "insert into student values(?,?,?)";
            jdbcTemplate.update(sql2, new Object[]{stu.getId(), stu.getName(), stu.getCity()});
        }
        else {
            String sql2 = "insert into student values(?,?,?)";
            jdbcTemplate.update(sql2, new Object[]{stu.getId(), stu.getName(), stu.getCity()});
        }
        return "Data Saved";
    }
}
