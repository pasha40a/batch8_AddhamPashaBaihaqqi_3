package com.ujianjuaracoding.main.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TitleRowMapper implements RowMapper<Title> {
	public Title mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		return new Title(rs.getInt("worker_ref_id"), rs.getString("worker_title"), rs.getString("affected_from"));
	}
}