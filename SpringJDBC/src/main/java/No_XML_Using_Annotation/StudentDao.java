package No_XML_Using_Annotation;

import org.springframework.jdbc.core.JdbcTemplate;

public class StudentDao {
	JdbcTemplate template;

	public StudentDao(JdbcTemplate template) {
		super();
		this.template = template;
	}
	
	public int insert(StudentBean student) {
		String query="insert into student values(?,?)";
		return template.update(query, student.getAge(), student.getName());
	}
	
}
