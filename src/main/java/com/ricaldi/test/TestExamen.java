package com.ricaldi.test;

import java.util.List;


import com.ricaldi.examenCL1.dao.LibroDao;
import com.ricaldi.examenCL1.dao.TemaDao;
import com.ricaldi.examenCL1.model.Libro;
import com.ricaldi.examenCL1.model.Tema;

public class TestExamen {
	public static void main(String[] args) {
		//Registrar temas
		TemaDao temaDao = new TemaDao();
		Tema tem1 = new Tema("Magia");
		Tema tem2 = new Tema("Viajes Espaciales");
		Tema tem3 = new Tema("Historia");
		temaDao.registrarTema(tem1);
		temaDao.registrarTema(tem2);
		temaDao.registrarTema(tem3);
		//listar temas
		List<Tema> listaTemas= temaDao.obtenerTodosTemas();
		System.out.println("===============================");
		System.out.println("	TABLA TEMA");
		System.out.println("===============================");
		System.out.println("ID	NOMBRE");
		System.out.println("------------------------------");
		listaTemas.forEach(tem -> System.out.println(tem.getIdtema() + "	"+ tem.getNombre()));
		
		//registrar libros
		LibroDao libroDao = new LibroDao();
		Libro lib1 = new Libro("Harry Potter libro uno",69.00, 20, "Salamandra",tem1);
		Libro lib2 = new Libro("Harry Potter libro dos",79.00, 12, "Salamandra",tem1);
		Libro lib3 = new Libro("Perdidos en el Espacio",100.00, 35, "Universo",tem2);
		libroDao.registrarLibro(lib1);
		libroDao.registrarLibro(lib2);
		libroDao.registrarLibro(lib3);
		//listar libros
		List<Libro> listaLibros = libroDao.obtenerTodosLibros();
		System.out.println("===============================");
		System.out.println("	TABLA LIBRO");
		System.out.println("===============================");
		System.out.println("ID	TITULO			PRECIO	CANT	ORIGEN		TEMA");
		System.out.println("-------------------------------------------------------------------");
		listaLibros.forEach(lib -> System.out.println(lib.getIdlibro()+"	"+lib.getTitulo() + "	" + lib.getPrecio() + "	"
				+ lib.getCantEjemplares() + "	" + lib.getOrigen() + "	" + lib.getTema().getNombre()));
	}
}
