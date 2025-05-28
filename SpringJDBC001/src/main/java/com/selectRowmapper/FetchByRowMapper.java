package com.selectRowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class FetchByRowMapper implements RowMapper<StudentBean> {

	public StudentBean mapRow(ResultSet rs, int rowNum) throws SQLException {
	   StudentBean student =new StudentBean();
	   student.setRollno(rs.getInt(1));;
	   student.setName(rs.getString(2));;
	   student.setLocation(rs.getString(3));
	   
	   System.out.println("RowMapper() Method Called");
		return student;
	}

}
