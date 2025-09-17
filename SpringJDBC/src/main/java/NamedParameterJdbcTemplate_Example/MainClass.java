package NamedParameterJdbcTemplate_Example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("NamedParameterJdbcTemplate_Example/config.xml");
		Studentdao dao=context.getBean("student",Studentdao.class);
		StudentBean bean=context.getBean("studentbean" , StudentBean.class);
		
		bean.setAge(12);
		bean.setName("Aditi");
		dao.insert(bean);
		System.out.println("inserted rows in the table ");
	}

}
