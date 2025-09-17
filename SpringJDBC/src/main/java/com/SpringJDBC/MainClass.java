package com.SpringJDBC;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import StudentDao.StudentBean;
import StudentDao.StudentDaoimpl;

public class MainClass {
public static void main(String[] args) {
	ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
	StudentDaoimpl student=context.getBean("student",StudentDaoimpl.class);
	StudentBean studentbean=context.getBean("studentbean",StudentBean.class);
	
//	----Insert---
//	Scanner sc=new Scanner(System.in);
//	System.out.println("enter age of the Student");
//	studentbean.setAge(sc.nextInt());
//	System.out.println("enter name of the student");
//	studentbean.setName(sc.next());
//	int r = student.insert(studentbean);
//	System.out.println("student has been inserted "+r);
	
	
//	---Update-----
//	studentbean.setAge(12);
//	studentbean.setName("prashant");
//	int r = student.update(studentbean);
//	System.out.println("student updated "+r);
	
	
//	----delete----
//	studentbean.setAge(12);
//	int r = student.delete(studentbean);
//	System.out.println("student deleted "+r);
	
	//fetching the data from table BY "ResultSetExtractor"
	List<StudentBean> bean=student.fetch(studentbean);
	
	for(StudentBean bean2:bean) {
		System.out.println(bean2.getAge()+"  "+ bean2.getName());
	}
	
	//fetching one row 
	StudentBean bean2=student.fetchbyRowMapper(studentbean);
	System.out.println(bean2.getAge()+"  "+bean2.getName());
	
	//fetching multiple objects or rows by RowMapper...
	List<StudentBean> bean3 = student.fetchmultiObjectByRowMapper(studentbean);
	for(StudentBean bean4:bean3) {
		System.out.println(bean4.getAge()+"  "+ bean4.getName());
	}
}
}
