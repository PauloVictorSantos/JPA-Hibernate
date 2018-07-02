package br.jus.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.jus.hibernate.model.Usuario;

public class Concorrencia {

	public static void main(String[] args) {
		
		EntityManager manager1 = JpaUtil.getEntityManager();
		EntityTransaction tx1 = manager1.getTransaction();
		tx1.begin();
		// obt�m segundo EntityManager e inicia transa��o
		EntityManager manager2 = JpaUtil.getEntityManager();
		EntityTransaction tx2 = manager2.getTransaction();
		tx2.begin();
		// altera objeto associado � primeira transa��o
		Usuario u1 = manager1.find(Usuario.class, 17L);
		u1.setEmail("maria@algaworks.com");
		// altera objeto associado � segunda transa��o
		Usuario u2 = manager2.find(Usuario.class, 17L);
		u2.setEmail("jose@algaworks.com");
		// faz commit na primeira transa��o
		tx1.commit();
		manager1.close();
		// faz commit na segunda transa��o
		tx2.commit();
		manager2.close();
		JpaUtil.close();
	}

}
