package com.springJDBC.SpringJdbc_Bean_Scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//By Default Scope of the Bean is SingleTon --we can explicitly define the Bean Scope Also as SingleTon
//@Scope("singleton")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON) // This is Standard way to represent The Scope of the Bean.....
public class SingleTonBean {

	@Autowired
	ProtoTypeBean protoType;

	public SingleTonBean() {
		super();
		System.out.println("SingleTonBean Object Created...");
	}

	public ProtoTypeBean getProtoType() {
		return protoType;
	}

	public void setProtoType(ProtoTypeBean protoType) {
		this.protoType = protoType;
	}

}
