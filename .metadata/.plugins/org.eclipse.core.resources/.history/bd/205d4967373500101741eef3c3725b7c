package Com.RequestScope;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.RequestScope;

@Controller
public class MyController {
	
//	But this will load while starting the server ---> But this object will not present in Container and this Class having Scope Request SCOPE
//	So While Sending Request Only --> it will create Object 
//	 But we Need Object while starting server itself ----> for that  proxyMode=ScopedProxyMode.TARGET_CLASS this line will create Proxy object and share to it  
//	@RequestScope   --this also contains proxyMode=ScopedProxyMode.TARGET_CLASS   --> so while starting server proxy object will create and send it for use
	@Autowired
	StudentBean bean;

//	While Starting Server ---> If Bean is Request Scope then it will not Create Object for that ... when request Sent then only it will create obeject.,...
//	For Every Request StudentBean Object Will Create 
//	For Every Refresh also it will send New Request ---> so For Every Refresh Also it will create Object....
	@RequestMapping("/testing1")
	public void GetTestMethod(HttpServletResponse response) throws IOException {
		response.setContentType("html");
		response.getWriter().write("My Name is " + bean.getName() + " <br>");
		bean.setName("prashant");
		response.getWriter().write("Updated  Name is " + bean.getName() + " <br>");
	}

	@RequestMapping("/testing2")
	public void GetTestMethod2(HttpServletResponse response) throws IOException {
		response.getWriter().write("My Name is " + bean.getName() + " <br>");

	}

}
