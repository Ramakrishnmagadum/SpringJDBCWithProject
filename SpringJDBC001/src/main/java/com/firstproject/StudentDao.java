package com.firstproject;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("studentdao")
public class StudentDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public void insert(StudentBean student) {
		String sql = "insert into Student values(?,?,?)";
		int no = jdbcTemplate.update(sql, student.getRollno(), student.getName(), student.getLocation());
		System.out.println("Successfully Inserted " + no + " Records into the DB..");
	}

	public boolean deleteRecordByRollNo(int rollno) {
		String sql = "delete from student where rollno =?";
		int deletedRecords = jdbcTemplate.update(sql, rollno);
		return deletedRecords == 1;
	}

	public int deleteRecordByNameOrByRollno(int rollno, String name) {
		String sql = "delete from student where rollno =? or name =?";
		int deletedRecords = jdbcTemplate.update(sql, rollno, name);
		return deletedRecords;
	}

	public void insertBatchOfRecords(ArrayList<StudentBean> student) {
		String sql = "insert into Student values(?,?,?)";
		ArrayList<Object[]> batchArgs = new ArrayList<Object[]>();

		for (StudentBean tempstudent : student) {
			Object[] args = { tempstudent.getRollno(), tempstudent.getName(), tempstudent.getLocation() };
			batchArgs.add(args);
		}

		jdbcTemplate.batchUpdate(sql, batchArgs);
		System.out.println("Batch records are inserted...");

	}

	public void updateBatchOfRecordsByRollno(String[] name, int[] rollnumbers) {
		String sql = "update  student set name= ? where rollno =?";

		ArrayList<Object[]> rollnumberargs = new ArrayList<Object[]>();
		for (int i = 0; i < name.length; i++) {
			Object[] arguments = { name[i], rollnumbers[i] };
			rollnumberargs.add(arguments);
		}

		jdbcTemplate.batchUpdate(sql, rollnumberargs);
		System.out.println("Batch records are Updated...");

	}

//Updating the Records By Using BatchPreparedStatementSetter this class
	@Transactional
	public void UpdatedRecordsByNewTech(final String[] name, final int[] rollnumber) {
		String sql = "update  student set name= ? where rollno =?";

		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {

//			 This will SetValues and update the Values Inside the DB....
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setString(1, name[i]);
				ps.setInt(2, rollnumber[i]);
				System.out.println("setting the Vzlues");
			}

//			this method will tell how many times SetValues Method need to Excute or how many records need to update......
			public int getBatchSize() {
				return name.length;
			}
		});

	}
}
