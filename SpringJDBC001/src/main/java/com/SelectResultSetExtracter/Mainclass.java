package com.SelectResultSetExtracter;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mainclass {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/SelectResultSetExtracter/beans.xml");
		System.out.println("Application Context Loadded Sucessfullyy...");
		
		StudentDao dao =context.getBean("studentdao",StudentDao.class);
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
		
		
		
//		-----   Using ResultSetExtracter To Fetch Data   --------
		ArrayList<StudentBean> studentlist=dao.fetchRecordsByResultSetExtracter();
		dao.printStudentList(studentlist);
		
		
		
//		----Practice Problem --------
//		here we will  get all the records from the table and:-)  if  multiple records have same location then all those records will add into one List
//		Example :
//		         Belagavi Value -> [prashnat, ram , abaca]
//		         Snk Value -> [ram]
//		         Beng Value -> [shree, ABC]
		HashMap<String, ArrayList<String>> map = dao.getValueBasedOnGroupByLocation();
		
		  for (String key : map.keySet()) {
	            System.out.println(key + " Value -> " + map.get(key));
	        }
		

		
	}
}
