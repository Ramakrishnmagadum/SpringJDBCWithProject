package Com.ApplicationScope;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@Component

//@Scope(value=WebApplicationContext.SCOPE_APPLICATION ,proxyMode=ScopedProxyMode.TARGET_CLASS)    
@ApplicationScope //Both are same we can declare the Session Scope Like this ....
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
