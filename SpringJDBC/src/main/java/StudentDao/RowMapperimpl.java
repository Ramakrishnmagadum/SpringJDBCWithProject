package StudentDao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RowMapperimpl implements RowMapper<StudentBean> {

	@Override
	public StudentBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		StudentBean bean=new StudentBean();
		bean.setAge(rs.getInt(1));
		bean.setName(rs.getString(2));
		return bean;
	}

}
