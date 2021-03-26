package com.ujianjuaracoding.main.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BonusRowMapper implements RowMapper<Bonus> {
	public Bonus mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		return new Bonus(rs.getInt("worker_ref_id"), rs.getString("bonus_date"), rs.getInt("bonus_amount"));
	}
}