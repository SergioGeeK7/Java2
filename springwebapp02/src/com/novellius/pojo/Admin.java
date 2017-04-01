package com.novellius.pojo;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Admin")
public class Admin {

	@Id
	@GeneratedValue
	private int idAdmin;
	// @Column(name="nombreCompleto")
	private String nombre;
	private String cargo;
	private Timestamp fechaCreacion;
	@OneToMany(mappedBy = "admin") // prop Admin Pojo
	private Set<Direccion> direcciones;

	public Set<Direccion> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(Set<Direccion> direcciones) {
		this.direcciones = direcciones;
	}

	public Admin(int idAdmin, String nombre, String cargo, Timestamp fechaCreacion) {
		this.idAdmin = idAdmin;
		this.nombre = nombre;
		this.cargo = cargo;
		this.fechaCreacion = fechaCreacion;
	}

	public Admin() {

	}

	public int getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Override
	public String toString() {
		return "Administrador [idAdmin=" + idAdmin + ", nombre=" + nombre + ", cargo=" + cargo + ", fechaCreacion="
				+ fechaCreacion + "]";
	}

}
