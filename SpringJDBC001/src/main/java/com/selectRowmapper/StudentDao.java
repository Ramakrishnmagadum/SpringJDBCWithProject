package com.selectRowmapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("studentdao2")
public class StudentDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public  void insert(StudentBean student) {
		String sql="insert into Student values(?,?,?)";
		int no=jdbcTemplate.update(sql,student.getRollno(), student.getName(),student.getLocation());
		System.out.println("Successfully Inserted "+no+ " Records into the DB..");
	}
	
	
	public boolean deleteRecordByRollNo(int rollno) {
		String sql="delete from student where rollno =?";
		int deletedRecords =jdbcTemplate.update(sql, rollno);
		return deletedRecords==1;
	}

	public int deleteRecordByNameOrByRollno(int rollno, String name) {
		String sql="delete from student where rollno =? or name =?";
		int deletedRecords =jdbcTemplate.update(sql, rollno,name);
		return deletedRecords;
	}
	
	
	
	public ArrayList<StudentBean> fetchRecordsByRowMapper(){
		String sql="select * from student";
		FetchByRowMapper rowMapper=new FetchByRowMapper();
		ArrayList<StudentBean> studentlist =(ArrayList<StudentBean>) jdbcTemplate.query(sql, rowMapper);
		return studentlist;
		
	}


	public void printStudentList(ArrayList<StudentBean> list) {
		for(StudentBean list2:list) {
		System.out.println(list2);
		}
		
	}


	public StudentBean fetchRecordsByRollnumber(int rollnumber) {
		String sql="select * from student where rollno =?";
		return jdbcTemplate.queryForObject(sql, new FetchByRowMapper() , rollnumber) ;
	}


	public ArrayList<StudentBean> fetchRecordsByBeanPropertyRowMapper() {
		String sql="select * from student";
//		new BeanPropertyRowMapper<StudentBean>(StudentBean.class)    -> this will bind internally to Object Varibles --But Name should match...
		return (ArrayList<StudentBean>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<StudentBean>(StudentBean.class));
	}
	
}
