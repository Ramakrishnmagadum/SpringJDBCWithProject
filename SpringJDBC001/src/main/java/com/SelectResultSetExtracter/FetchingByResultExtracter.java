package com.SelectResultSetExtracter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class FetchingByResultExtracter implements ResultSetExtractor {

//	this method will get excute 
//	ResultSet rs  --> here "ResultSet" having All the Records in it ... By While Loop For Each record --> Creating the Object(StudentBean) and Adding Values in it (For Each Records)
//	this method call only once ....
	public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		ArrayList<StudentBean> studentlist=new ArrayList<StudentBean>();
		
		while(rs.next()) {
			StudentBean bean=new StudentBean();
			bean.setRollno(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setLocation(rs.getString(3));
			studentlist.add(bean);
		}
		return studentlist;
	}

}
