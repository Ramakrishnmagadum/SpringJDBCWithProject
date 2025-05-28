package com.StudentManagement.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.StudentManagement.Beans.StudentDto;
import com.StudentManagement.Entities.StudentEntity;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<StudentEntity> showstudentlist() {
		String sql = "select * from student";
		return jdbcTemplate.query(sql, new StudentRowMapper());
	}

	public int addStudent(StudentDto student) {
		String sql;
			sql = "insert into student (name , mobile , country) values(? ,? , ?)";
			Object[] objarr = { student.getStdname(), student.getStdmobile(), student.getStdcountry() };
			System.out.println(sql);
			return jdbcTemplate.update(sql, objarr);
		
	}
	

	public StudentDto getStudentById(int studentId) {
		String sql = "select * from student where id = ?";
		Object[] objarr = { studentId };
		return (StudentDto) jdbcTemplate.queryForObject(sql, objarr, new StudentResultById());
	}

	public int updateStudentById(StudentDto student) {
		String sql = "update  student  set name =? , mobile =? , country =?  where id= ? ";
		Object[] objarr = { student.getStdname(), student.getStdmobile(), student.getStdcountry(),
				student.getStdid() };
		System.out.println(sql);
		return jdbcTemplate.update(sql, objarr);
	}

	public int DeleteById(int studentid) {
		String sql="delete from student where id = ?";
		return jdbcTemplate.update(sql, studentid);
	}

}
