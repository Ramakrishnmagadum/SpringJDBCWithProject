package com.SelectResultSetExtracter;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.SelectResultSetExtracter.StudentBean;

@Repository("studentdao")
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
	
	public void printStudentList(ArrayList<StudentBean> list) {
		for(StudentBean list2:list) {
		System.out.println(list2);
		}
		
	}


	public ArrayList<StudentBean> fetchRecordsByResultSetExtracter() {
		String sql="Select * from student";
//		new FetchingByResultExtracter() ---> created new Class for ResultExtracter
		return jdbcTemplate.query(sql, new FetchingByResultExtracter());
	}
	
	
	public HashMap<String , ArrayList<String>> getValueBasedOnGroupByLocation(){
		String sql="select * from student";
		return jdbcTemplate.query(sql, new ResultExtracterOnGroupByLocation());
	}

	

}
