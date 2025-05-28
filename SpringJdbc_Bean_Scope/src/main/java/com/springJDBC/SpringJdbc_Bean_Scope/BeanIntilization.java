package com.springJDBC.SpringJdbc_Bean_Scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanIntilization {

	public static void main(String[] args) {
//		this First Line will load all the Classes which are represented with Annotation and create Object...
		 ApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");
		 
//		 SingleTon Object will create When server Loads the Beans.xml
//		 But ProtoType Bean Scope Object will not Load at time of server Loads
//		 ProtoType Object will Create Object when we call or ask from container --then it will Create Object..
		 
//		 ---------    case 1:    -------------
//		 After Calling or asking Object from Container it will Create object and Give it to You .....
//		 ProtoTypeBean obj1 = context.getBean("protoTypeBean", ProtoTypeBean.class);
		 
		 
//		 ---------    case 2:    ------------- 
//      ParentBean need ChildBean --->>>  Bcz In ParentBean added @AutoWired ChildBean ....
 //		ParentBean is SingleTon Scope so it create At Serve Loads and It needs ChildBean also since @AutoWired present and childBean  has ProtoType Scope But  it will create Childbean also while Loading Server Bcz ParentBean ask to Container...

		 
		 
//		 ---------    case 3:    -------------	
//		 here I am Calling the SingleTonBean two times ---->  So Here ProtoTypeBean is Child Bean which will create EveryTime New Object whenever we ask to Container 
//		But --> it will not  create Because ---> SingletonBean Object is having the ChildBean Object refrencce for the First Time Itself ---> so second time it will ask to Container --> it will use existing .....
		 SingleTonBean obj1 =context.getBean("singleTonBean", SingleTonBean.class);
	     SingleTonBean obj2 =context.getBean("singleTonBean", SingleTonBean.class);
	 
//	     for Every Time asking SingleTonBeanObject From Container --> So ProtoTypeBean(ChildBean) Should Create New Object for Every time Then we need to follow this
//	     tow ways are their we can achieve this Too.....
//	     1. @Lookup Annotation
//	     2. ProxyMode 
	     
	     
	}
}
