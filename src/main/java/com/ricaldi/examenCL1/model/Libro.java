package com.ricaldi.examenCL1.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "libro")
public class Libro {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idlibro")
	private int idlibro;
	@Column(name = "titulo")
	private String titulo;
	@Column(name = "precio")
	private double precio;
	@Column(name = "cantEjemplares")
	private int cantEjemplares;
	@Column(name = "origen")
	private String origen;
	@ManyToOne
	private Tema tema;
	 
	public Libro() {
		
	}

	public Libro(String titulo, double precio, int cantEjemplares, String origen) {
		this.titulo = titulo;
		this.precio = precio;
		this.cantEjemplares = cantEjemplares;
		this.origen = origen;
	}
	
	public Libro(String titulo, double precio, int cantEjemplares, String origen, Tema tema) {
		this.titulo = titulo;
		this.precio = precio;
		this.cantEjemplares = cantEjemplares;
		this.origen = origen;
		this.tema = tema;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantEjemplares() {
		return cantEjemplares;
	}

	public void setCantEjemplares(int cantEjemplares) {
		this.cantEjemplares = cantEjemplares;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public int getIdlibro() {
		return idlibro;
	}

	public void setIdlibro(int idlibro) {
		this.idlibro = idlibro;
	}
	
	
}
