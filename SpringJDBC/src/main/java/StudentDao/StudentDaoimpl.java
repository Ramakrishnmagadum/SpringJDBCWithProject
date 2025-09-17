package StudentDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class StudentDaoimpl implements Studentdao{
	JdbcTemplate templatebean;
	private StudentDaoimpl(JdbcTemplate templatebean) {
		super();
		this.templatebean = templatebean;
	}

	@Override
	public int insert(StudentBean student) {
		String query="insert into student (id,name) values(?,?)";
		return templatebean.update(query,student.getAge(),student.getName());
	}

	@Override
	public int update(StudentBean student) {
		String query="update  student set name=? where id=?";
		return templatebean.update(query,student.getName(),student.getAge());
	}

	@Override
	public int delete(StudentBean student) {
		String query="delete from student where id=?";
		return templatebean.update(query,student.getAge());
	}

	@Override
	public List<StudentBean> fetch(StudentBean s) {
		String query="select * from student";
		
		return templatebean.query(query, new ResultSetExtractor<List<StudentBean>>() {

			@Override
			public List<StudentBean> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<StudentBean> list=new ArrayList<StudentBean>();
				
				while(rs.next()) {
					StudentBean std=new StudentBean();
					std.setAge(rs.getInt(1));
					std.setName(rs.getString(2));
					list.add(std);
				}
				return list;
			}
			
		});
	}

	//queryForObject --its will fetch single row 
	@Override
	public StudentBean fetchbyRowMapper(StudentBean s) {
		String query="Select * from student where id=?";
		
		return  templatebean.queryForObject(query, new RowMapper<StudentBean>() {

			@Override
			public StudentBean mapRow(ResultSet rs, int rowNum) throws SQLException {
				StudentBean bean=new StudentBean();
				bean.setAge(rs.getInt(1));
				bean.setName(rs.getString(2));
				return bean;
			}
			
		}, 24);
	}

	
	//we can create on class for RowMapper also.....
//	@Override
//	public List<StudentBean> fetchmultiObjectByRowMapper(StudentBean s) {
//		String query="select * from student";
//		return templatebean.query(query, new RowMapper<StudentBean>() {
//			@Override
//			public StudentBean mapRow(ResultSet rs, int rowNum) throws SQLException {
//				StudentBean bean=new StudentBean();
//				bean.setAge(rs.getInt(1));
//				bean.setName(rs.getString(2));
//				return bean;
//			}	
//		});
//	}
	
	@Override
	public List<StudentBean> fetchmultiObjectByRowMapper(StudentBean s) {
		String query="select * from student";
		//all logics written inside this class ="RowMapperimpl".....
		RowMapperimpl rowmapper =new RowMapperimpl();
		return templatebean.query(query,rowmapper);
	}

}
