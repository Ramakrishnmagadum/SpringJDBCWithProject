package com.StudentManagement.Beans;

public class StudentDto {
	private Integer Stdid;
	private String Stdname;
	private Long Stdmobile;
	private String Stdcountry ;
	public Integer getStdid() {
		return Stdid;
	}
	public void setStdid(Integer stdid) {
		Stdid = stdid;
	}
	public String getStdname() {
		return Stdname;
	}
	public void setStdname(String stdname) {
		Stdname = stdname;
	}
	public Long getStdmobile() {
		return Stdmobile;
	}
	public void setStdmobile(Long stdmobile) {
		Stdmobile = stdmobile;
	}
	public String getStdcountry() {
		return Stdcountry;
	}
	public void setStdcountry(String stdcountry) {
		Stdcountry = stdcountry;
	}
	@Override
	public String toString() {
		return "StudentDto [Stdid=" + Stdid + ", Stdname=" + Stdname + ", Stdmobile=" + Stdmobile + ", Stdcountry="
				+ Stdcountry + "]";
	}
	
	
}
