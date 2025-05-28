package SpringSingleTon_VS_GOFSingleTon;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

@Controller
public class ControllerClass {
	
	public static void main(String[] args) {
//		 --------------     This is First Container     --------------
//		Here If Object/Class Having SingleTon Scope --> then it should Create Object only one Time.....
//		But it will be applicable only For Each Container
//		In One Container Only One Time Object will Create If Object Scope is SingleTon
//		If we create One More  ApplicationContext -->then that is One More container so it will create new Object 
		ApplicationContext context1=new ClassPathXmlApplicationContext("Beans.xml");
		
		
		
//		--------------    This is Second Container  --------------
		ApplicationContext context2=new ClassPathXmlApplicationContext("Beans.xml");
		
		
//		Difference Between Single Spring Scope V/S  GOF Single Design Pattern
//		Single Spring Scope                                  V/S                        GOF Single Design Pattern
//		it will Create One Object For One One Container      |||                  it will create Only One Object Irrespective of Container for whole Application....
		
		
		
	}

}
