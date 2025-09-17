package NamedParameterJdbcTemplate_Example;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class Studentdao {
	NamedParameterJdbcTemplate NamedjdbcTemplate;

	private Studentdao(NamedParameterJdbcTemplate jdbctemplate) {
		super();
		this.NamedjdbcTemplate = jdbctemplate;
	}
	
	public void insert(StudentBean std) {
		//here we can pass like this :age, :name 
		String query = "insert into student values(:age, :name)";
		Map<String ,Object> map=new HashMap<String , Object>();
		map.put("age", std.getAge());
		map.put("name", std.getName());
		
		
		
		 NamedjdbcTemplate.execute(query, map, new PreparedStatementCallback() {

			@Override
			public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				return ps.executeUpdate();
			}
			
		});
	}
	

}
