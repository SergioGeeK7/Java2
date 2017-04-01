package com.novellius.dao;

import java.util.List;

import com.novellius.pojo.Admin;
import com.novellius.pojo.Direccion;

public interface DireccionDAO {
	public void save (Direccion dir);
	public List<Direccion> findAll (Admin admin);
}
