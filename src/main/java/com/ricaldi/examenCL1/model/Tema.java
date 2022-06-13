package com.ricaldi.examenCL1.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tema")
public class Tema {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idtema")
	private int idtema;
	@Column(name = "nombre")	
	private String nombre;
	@OneToMany(mappedBy = "tema", cascade = CascadeType.PERSIST)
	private List<Libro> listaLibros = new ArrayList<Libro>();
	
	public Tema() {
		
	}

	public Tema(String nombre) {
		super();
		this.nombre = nombre;
	}

	public int getIdtema() {
		return idtema;
	}

	public void setIdtema(int idtema) {
		this.idtema = idtema;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String toString() {
		return nombre;
	}
}
