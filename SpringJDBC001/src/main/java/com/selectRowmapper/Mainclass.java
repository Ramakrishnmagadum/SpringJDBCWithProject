package com.selectRowmapper;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mainclass {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/selectRowmapper/beans.xml");
		System.out.println("Application Context Loadded Sucessfullyy...");
		
		StudentDao dao =context.getBean("studentdao2", StudentDao.class);
		StudentBean student =context.getBean("student2", StudentBean.class);
		student.setRollno(6);
		student.setName("ramakrishna");
		student.setLocation("Bel");
		
//		---------------      inserting the records     ---------------
//		dao.insert(student);
		
//		--------------    deleting records by Rollno  ---------------
//		int rollno =1;
//		boolean status=dao.deleteRecordByRollNo(rollno);
//		if(status) {
//			System.out.println("Record Deleted Sucessfully with rollno "+ rollno);
//		}else {
//			System.out.println("with "+ rollno + " rollno  records does not exists ");
//		}
		
//		---------------      deleting records by rollno and Name       ---------------
//		int rollnumber=2;
//		String name="ramakrishna3";
//		int deletedrecordsnum= dao.deleteRecordByNameOrByRollno(rollnumber , name);
//		System.out.println(deletedrecordsnum+" records are deleted...");
		
//    ---------------     Fetching records By RowMapper   -----------------------------
		ArrayList<StudentBean> list =dao.fetchRecordsByRowMapper();
		dao.printStudentList(list);
		
//	    ---------------     Fetching records By Rollnumber  -----------------------------
			StudentBean studentbyrollnumber =dao.fetchRecordsByRollnumber(2);
			System.out.println(studentbyrollnumber);
		
//			---------------     Fetching records By BeanPropertyRowMapper   -----------------------------
//		RowMapper implementation that converts a row into a new instance of the specified mapped target class
//		It will Map Internally But Column Name and Object varibale Name should be same ---> then it will Map internally 
//		Else Provide aliases Name in Query ---> aliases  Name should match ....
			ArrayList<StudentBean> studentlist = dao.fetchRecordsByBeanPropertyRowMapper();
			dao.printStudentList(studentlist);
			
			
	}
}
