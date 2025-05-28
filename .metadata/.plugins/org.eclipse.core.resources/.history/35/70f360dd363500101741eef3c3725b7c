package Com.RequestScope;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component

//@Scope(value=WebApplicationContext.SCOPE_REQUEST , proxyMode=ScopedProxyMode.TARGET_CLASS)   
@RequestScope  //Both are same we can declare the Request Scope Like this ....
public class StudentBean {

	private String name="Ramakrishna";
	

	public StudentBean() {
		super();
		System.out.println("StudentBean Object Created...");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
