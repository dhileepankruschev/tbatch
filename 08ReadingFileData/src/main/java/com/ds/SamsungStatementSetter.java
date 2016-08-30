package com.ds;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementSetter;

public class SamsungStatementSetter implements PreparedStatementSetter {
	public void setValues(PreparedStatement ps) throws SQLException {
		ps.setString(1, "Samsung%");
	}
}