package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;


@Entity
@Table
public class Estudiante {
	
	@Id
	@Column(name="c_usuario")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer c_usuario;
	
	@Column(name="nombre")
	private String Nombre;
	
	@Column(name="apellido")
	private String Apellido;
	
	@Column(name="carne")
	private String carne;
	
	@Column(name="carrera")
	private String carrera;
	
	//CONSTRUCTOR
	public Estudiante() {
		
	}
	
	public Estudiante(String nombre, String apellido, String carne, String carrera) {
		super();
		Nombre = nombre;
		Apellido = apellido;
		this.carne = carne;
		this.carrera = carrera;
	}

	public Estudiante(Integer c_usuario, String nombre, String apellido, String carne, String carrera) {
		super();
		this.c_usuario = c_usuario;
		Nombre = nombre;
		Apellido = apellido;
		this.carne = carne;
		this.carrera = carrera;
	}
	
	public Integer getC_usuario() {
		return c_usuario;
	}

	public void setC_usuario(Integer c_usuario) {
		this.c_usuario = c_usuario;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public String getCarne() {
		return carne;
	}

	public void setCarne(String carne) {
		this.carne = carne;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	
	
}
