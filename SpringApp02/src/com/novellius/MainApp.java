package com.novellius;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import com.novellius.dao.AdminDAO;
import com.novellius.pojo.Admin;

public class MainApp {
	public static void main(String[] args) {

		// allow you to use spring tools
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.config.xml");

		AdminDAO adminDao = (AdminDAO) applicationContext.getBean("adminDao");
		Timestamp ts = new Timestamp(new Date().getTime());

		Admin admin = new Admin();
		admin.setCargo("programador");
		admin.setNombre("carlos");
		admin.setFechaCreacion(ts);

		try {
			//adminDao.save(admin);
			//System.out.println("Admin saved !!!");
			
			//List<Admin> admins = adminDao.findAll();
			
		/*	for(Admin item:admins){
				System.out.println(item);
			}*/
			
			
			//System.out.println(adminDao.findById(1));
			//System.out.println(adminDao.findById(3));
			//System.out.println(adminDao.findByNombre("c").toString());
			//System.out.println(adminDao.delete(1));
			
			List<Admin> admins = new ArrayList<Admin>();
			admins.add(new Admin(19,"pepe a","jefe de ingenieria",ts));
			admins.add(new Admin(16,"andres a","jefe de contabilidad",ts));
			admins.add(new Admin(17,"marta a","jefe de resusos humanos",ts));
			admins.add(new Admin(18,"casi a","aguatero",ts));
			adminDao.saveAll(admins);
			
			
		} catch (CannotGetJdbcConnectionException e) {
			System.out.println(e.getMessage());
		} catch (DataAccessException ex) {
			System.out.println(ex.getMessage());
		}

		((ClassPathXmlApplicationContext) applicationContext).close();
	}
}
