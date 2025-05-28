package com.StudentManagement.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.StudentManagement.Beans.StudentDto;

public class StudentResultById implements RowMapper<StudentDto> {

	public StudentDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		StudentDto bean = new StudentDto();

		bean.setStdid(rs.getInt(1));
		bean.setStdname(rs.getString(2));
		bean.setStdmobile(rs.getLong(3));
		bean.setStdcountry(rs.getString(4));
		return bean;
	}

}
