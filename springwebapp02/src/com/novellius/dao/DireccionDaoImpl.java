package com.novellius.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.novellius.pojo.Admin;
import com.novellius.pojo.Direccion;

@Transactional
@Repository // indicar que este objeto es un DAO
public class DireccionDaoImpl implements DireccionDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(Direccion dir) {
		getSession().save(dir);
	}

	@Override
	public List<Direccion> findAll(Admin admin) {
		Criteria crit = getSession().createCriteria(Direccion.class)
				.setFetchMode("admin", FetchMode.JOIN) // alias
				.add(Restrictions.eq("admin.idAdmin", admin.getIdAdmin())) // admin.idAdmin pojo
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		return crit.list();
	}

}
