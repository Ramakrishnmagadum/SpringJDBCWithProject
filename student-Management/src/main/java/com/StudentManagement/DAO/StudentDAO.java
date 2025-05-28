package com.StudentManagement.DAO;

import java.util.List;

import com.StudentManagement.Beans.StudentDto;
import com.StudentManagement.Entities.StudentEntity;

public interface StudentDAO {
	public List<StudentEntity>  showstudentlist();
	
	public int addStudent(StudentDto student);
	
	public StudentDto getStudentById(int studentId);
	
	public int updateStudentById(StudentDto student);
	
	public int DeleteById(int studentid);
}
