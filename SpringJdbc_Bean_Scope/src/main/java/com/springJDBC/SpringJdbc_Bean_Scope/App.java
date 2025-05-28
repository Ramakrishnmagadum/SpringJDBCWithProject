package com.springJDBC.SpringJdbc_Bean_Scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");
        
//        SingleTon Every time create Same Object 
        SingleTonBean obj1 =context.getBean("singleTonBean", SingleTonBean.class);
        SingleTonBean obj2 =context.getBean("singleTonBean", SingleTonBean.class);
        System.out.println(obj1 +" "+obj2);
        if(obj1.equals(obj2)) {
        	System.out.println("Both Object are Same");
        }else {
        	System.out.println("Both object are not Same , Both are different..");
        }
        
        
//       ProtoType Every time create Brand new  Object --> whenever we call or ask from Container
//        Only From Container if we ask it will give new Object EveryTime....
        ProtoTypeBean obj3 = context.getBean("protoTypeBean", ProtoTypeBean.class);
        ProtoTypeBean obj4 =context.getBean("protoTypeBean", ProtoTypeBean.class);
      System.out.println(obj3 +" "+obj4);
      if(obj3.equals(obj4)) {
      	System.out.println("Both Object are Same");
      }else {
      	System.out.println("Both object are not Same , Both are different..");
      }
        
    }
}
