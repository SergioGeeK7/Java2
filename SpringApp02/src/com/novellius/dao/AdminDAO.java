package com.novellius.dao;

import java.util.List;

import com.novellius.pojo.Admin;

public interface AdminDAO {

	
	public boolean save(Admin admin);
	public List<Admin> findAll();
	public Admin findById(int id);
	public List<Admin> findByNombre(String nombre);
	public boolean update(Admin admin);
	public boolean delete(int id);
	public void saveAll(List<Admin> admins);
	
}
