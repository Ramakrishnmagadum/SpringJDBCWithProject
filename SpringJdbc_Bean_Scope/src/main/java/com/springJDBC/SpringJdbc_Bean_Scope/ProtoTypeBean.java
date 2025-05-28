package com.springJDBC.SpringJdbc_Bean_Scope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
//Setting the Scope as ProtoType
//@Scope("prototype")
@Scope(value= ConfigurableBeanFactory.SCOPE_PROTOTYPE , proxyMode=ScopedProxyMode.TARGET_CLASS)  //This is Standard way to represent The Scope of the Bean.....
public class ProtoTypeBean {

	public ProtoTypeBean() {
		super();
		System.out.println("ProtoTypeBean Object Created...");
	}

	
}
