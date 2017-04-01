package com.novellius;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// this class can be injected 
@Component
public class Direccion {

	private String calle;
	private String cp;

	public Direccion() {

	}
	@Autowired
	public void setCalle(@Value("Encimo")String calle) {
		this.calle = calle;
	}
	@Autowired
	public void setCp(@Value("000000000")String cp) {
		this.cp = cp;
	}

	public Direccion(String calle, String cp) {
		super();
		this.calle = calle;
		this.cp = cp;
	}

	@Override
	public String toString() {
		return "Direccion [calle=" + calle + ", cp=" + cp + "]";
	}

}
