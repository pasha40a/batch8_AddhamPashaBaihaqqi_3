package com.ujianjuaracoding.main.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


import com.ujianjuaracoding.main.model.Karyawan;

public class KaryawanRowMapper implements RowMapper<Karyawan> {
	public Karyawan mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		return new Karyawan(rs.getInt("worker_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getInt("salary"), rs.getString("joining_date"), rs.getString("department"));
	}

}
