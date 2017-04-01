package com.novellius;

import org.springframework.beans.factory.annotation.Autowired;

public class Administrador {

	private int id;
	private String nombre;
	//@Autowired
	private Direccion direccion;
	
	public Administrador(){
		
	}
	@Autowired
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Administrador(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	
	@Override
	public String toString() {
		return "Administrador [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + "]";
	}

	public void imprimirDireccion() {
		System.out.println("Encimo 201");
	}
}
