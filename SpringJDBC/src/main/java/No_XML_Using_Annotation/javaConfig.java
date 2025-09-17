package No_XML_Using_Annotation;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class javaConfig {

	@Bean()
	public JdbcTemplate gettemplate() {
		JdbcTemplate template=new JdbcTemplate();
		template.setDataSource(getdatasource());
		return template;
	}
	
	@Bean()
	public DriverManagerDataSource getdatasource() {
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springdatabase");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}
	
	@Bean("student")
	public StudentBean getstudent() {
		return new StudentBean(); 
	}
	
	@Bean("studentdao")
	public StudentDao getstddao() {
		StudentDao dao=new StudentDao(gettemplate());
		return dao;
	}
}
