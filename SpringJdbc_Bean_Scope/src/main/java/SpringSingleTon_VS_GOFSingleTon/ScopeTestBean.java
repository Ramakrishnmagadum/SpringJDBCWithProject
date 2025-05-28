package SpringSingleTon_VS_GOFSingleTon;

import org.springframework.stereotype.Component;

@Component
//By Default Scope will be SignleTon ......
public class ScopeTestBean {

	public ScopeTestBean() {
		super();
		System.out.println("ScopeTest Bean Object Created....");
	}
	

}
