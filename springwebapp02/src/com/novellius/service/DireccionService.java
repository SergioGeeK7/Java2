package com.novellius.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novellius.dao.AdminDAO;
import com.novellius.dao.DireccionDAO;
import com.novellius.pojo.Admin;
import com.novellius.pojo.Direccion;

@Service
public class DireccionService {

	@Autowired
	private AdminDAO adminDao;
	@Autowired
	private DireccionDAO direccionDao;

	public void save(Admin admin,Direccion dir) {
		dir.setAdmin(admin);
		direccionDao.save(dir);
	}

	public List<Direccion> findAll(int idAdmin) {
		Admin admin = adminDao.findById(idAdmin);
		return direccionDao.findAll(admin);
	}
}
