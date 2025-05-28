package com.SelectResultSetExtracter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class ResultExtracterOnGroupByLocation implements ResultSetExtractor {

	public Object extractData(ResultSet rs) throws SQLException, DataAccessException {

		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		while (rs.next()) {
			if (!map.containsKey(rs.getString(3))) {
				ArrayList<String> list = new ArrayList<String>();
				list.add(rs.getString(2).toString());
				map.put(rs.getString(3).toString(), list);
			} else {
				ArrayList<String> list = map.get(rs.getString(3).toString());
				list.add(rs.getString(2).toString());
				map.put(rs.getString(3).toString(), list);
			}
		}
		return map;
	}

}
