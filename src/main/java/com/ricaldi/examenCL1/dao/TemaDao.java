package com.ricaldi.examenCL1.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


import com.ricaldi.examenCL1.model.Tema;
import com.ricaldi.util.ExamenUtil;

public class TemaDao {
	public TemaDao() {
		
	}
	
	//registrar tema
	public void registrarTema(Tema tema) {
		Transaction transaction = null;
		try (Session session= ExamenUtil.getSessionFactory().openSession()){
			//iniciar transaccion
			transaction = session.beginTransaction();
			session.save(tema);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	//Obtener lista de temas
	public List<Tema> obtenerTodosTemas() {
		Transaction transaction = null;
		List<Tema> listaTemas = null;
		try (Session session= ExamenUtil.getSessionFactory().openSession()){
			//iniciar transaccion
			transaction = session.beginTransaction();
			//obtener los estudiantes
			listaTemas = session.createQuery("from Tema").list();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		
		return listaTemas;
	}
}
