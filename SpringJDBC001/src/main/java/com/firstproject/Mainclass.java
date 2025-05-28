package com.firstproject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mainclass {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/firstproject/beans.xml");
		System.out.println("Application Context Loadded Sucessfullyy...");
		
		StudentDao dao =context.getBean("studentdao", StudentDao.class);
		StudentBean student =context.getBean("student", StudentBean.class);
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
		
//		---------------       Inserting the Batch of Records     ---------------
//		InsertingBatchRecordsHelper insertingBatchRecord =context.getBean("insertingBatchRecordsHelper", InsertingBatchRecordsHelper.class);
//		ArrayList<StudentBean> liststudent = insertingBatchRecord.setBatchRecords();
//		dao.insertBatchOfRecords(liststudent);
//		System.out.println("Batch insertion Completed !!!");
		
		
//		---------------       Updating the Batch of Records     ---------------
//		String[] name= {"ram","prashnat","shree"};
//		int[] rollnumber = {1,2,3};
//		dao.updateBatchOfRecordsByRollno(name , rollnumber);
//		System.out.println("Batch Updation Completed !!!");
		
//		---------------       Updating the Batch of Records By BatchPreparedStatementSetter  ---------------
		String[] name= {"shree12","ram12","jhghhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh"
				+ "hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhprashant"};
		int[] rollnumber = {1,2,3};
		dao.UpdatedRecordsByNewTech(name , rollnumber);
		System.out.println("Batch Updation Completed !!!");
		
	}
}
