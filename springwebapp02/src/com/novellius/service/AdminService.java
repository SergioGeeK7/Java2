package com.novellius.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novellius.dao.AdminDAO;
import com.novellius.pojo.Admin;

@Service
public class AdminService {

	@Autowired
	private AdminDAO adminDao;

	public void save(Admin admin) {

		Timestamp ts = new Timestamp(new Date().getTime());
		admin.setFechaCreacion(ts);
		adminDao.save(admin);
	}

	public List<Admin> findAll() {
		return adminDao.findAll();
	}

	public Admin findById(int id) {
		return adminDao.findById(id);
	}

	public void saveOrUpdate(Admin admin) {
		if(admin.getIdAdmin() == 0){
			save(admin);
		}else{
			adminDao.update(admin);
		}
	}

	public void delete(int id) { 
		 Admin admin = adminDao.findById(id);
		 adminDao.delete(admin);
	}

}
