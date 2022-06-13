package com.ricaldi.examenCL1.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


import com.ricaldi.examenCL1.model.Libro;
import com.ricaldi.util.ExamenUtil;

public class LibroDao {
	public LibroDao() {
		
	}
	
	//registrar libro
	public void registrarLibro(Libro libro) {
		Transaction transaction = null;
		try (Session session= ExamenUtil.getSessionFactory().openSession()){
			//iniciar transaccion
			transaction = session.beginTransaction();
			session.save(libro);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	//Obtener lista de libros
	public List<Libro> obtenerTodosLibros() {
		Transaction transaction = null;
		List<Libro> listaLibros = null;
		try (Session session= ExamenUtil.getSessionFactory().openSession()){
			//iniciar transaccion
			transaction = session.beginTransaction();
			//obtener los estudiantes
			listaLibros = session.createQuery("from Libro").list();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		
		return listaLibros;
	}
}
