package com.novellius.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.novellius.pojo.Admin;

public class AdminRow implements RowMapper<Admin>{
	
	@Override
	public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {

		Admin admin = new Admin();
		admin.setIdAdmin(rs.getInt("idAdmin"));
		admin.setCargo(rs.getString("cargo"));
		admin.setFechaCreacion(rs.getTimestamp("fechaCreacion"));
		admin.setNombre(rs.getString("nombre"));
		
		return admin;
	}	
}
