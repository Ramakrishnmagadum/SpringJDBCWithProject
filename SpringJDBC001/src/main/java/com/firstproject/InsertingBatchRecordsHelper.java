package com.firstproject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("insertingBatchRecordsHelper")
public class InsertingBatchRecordsHelper {
	
	public ArrayList<StudentBean> setBatchRecords(){
		StudentBean bean1=new StudentBean();
		bean1.setRollno(1);
		bean1.setName("ram");
		bean1.setLocation("Bela");
		
		StudentBean bean2=new StudentBean();
		bean2.setRollno(2);
		bean2.setName("rama");
		bean2.setLocation("Belagavi");
		
		StudentBean bean3=new StudentBean();
		bean3.setRollno(3);
		bean3.setName("ramakrishna");
		bean3.setLocation("Beng");
		
		StudentBean bean4=new StudentBean();
		bean4.setRollno(4);
		bean4.setName("ram");
		bean4.setLocation("Snk");
		
		ArrayList<StudentBean> list=new ArrayList<StudentBean>();
		list.add(bean1);
		list.add(bean2);
		list.add(bean3);
		list.add(bean4);
		return list;
	}

}
