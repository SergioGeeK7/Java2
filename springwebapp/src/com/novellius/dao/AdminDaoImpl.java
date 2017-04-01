package com.novellius.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.novellius.pojo.Admin;

@Component("adminDao")
public class AdminDaoImpl implements AdminDAO {

	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	private void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public boolean save(Admin admin) {
		// TODO Auto-generated method stub
		/*
		 * MapSqlParameterSource parametters = new MapSqlParameterSource();
		 * parametters.addValue("nombre", admin.getNombre());
		 * parametters.addValue("cargo", admin.getCargo());
		 * parametters.addValue("fechaCreacion", admin.getFechaCreacion());
		 */

		BeanPropertySqlParameterSource paramMap = new BeanPropertySqlParameterSource(admin);

		return jdbcTemplate.update(
				"insert into Admin (nombre,cargo,fechaCreacion)" + " VALUES (:nombre,:cargo,:fechaCreacion)",
				paramMap) == 1;
	}

	@Override
	public List<Admin> findAll() {
		return jdbcTemplate.query("SELECT * FROM Admin", new AdminRow());
	}

	@Override
	public Admin findById(int id) {

		// return (Admin) jdbcTemplate.query("SELECT * FROM Admin WHERE idAdmin
		// = :idAdmin",
		// new MapSqlParameterSource("idAdmin", id), new AdminRow());

		return jdbcTemplate.queryForObject("SELECT * FROM Admin WHERE idAdmin = :idAdmin",
				new MapSqlParameterSource("idAdmin", id), new AdminRow());

	}

	@Override
	public List<Admin> findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT * FROM Admin WHERE nombre like :nombre",
				new MapSqlParameterSource("nombre", "%" + nombre + "%"), new AdminRow());
	}

	@Override
	public boolean update(Admin admin) {

		BeanPropertySqlParameterSource paramMap = new BeanPropertySqlParameterSource(admin);

		return jdbcTemplate.update("UPDATE Admin SET nombre=:nombre,"
				+ " cargo = :cargo , fechaCreacion = :fechaCreacion WHERE idAdmin = :idAdmin", paramMap) == 1;
	}

	@Override
	public boolean delete(int id) {
		return jdbcTemplate.update("delete from Admin where idAdmin = :idAdmin",
				new MapSqlParameterSource("idAdmin", id)) == 1;
	}

	
	
	@Transactional
	@Override
	public void saveAll(List<Admin> admins) {
		// TODO Auto-generated method stub
		
		SqlParameterSource[] batchArgs =
				SqlParameterSourceUtils.createBatch(admins.toArray());
		
		jdbcTemplate.batchUpdate("insert into Admin (idAdmin,nombre,cargo,fechaCreacion)" + " VALUES (:idAdmin,:nombre,:cargo,:fechaCreacion)",
				batchArgs);
	}

}
