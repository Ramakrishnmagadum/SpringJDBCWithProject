package No_XML_Using_Annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {
public static void main(String[] args) {
	ApplicationContext context=new AnnotationConfigApplicationContext(javaConfig.class);
	StudentBean std=context.getBean("student",StudentBean.class);
	StudentDao dao=context.getBean("studentdao" ,StudentDao.class);
	std.setAge(36);
	std.setName("ramakrishna");
	dao.insert(std);
	System.out.println("values are inserted");
	
}
}
