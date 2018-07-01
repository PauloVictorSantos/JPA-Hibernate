package br.jus.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.jus.hibernate.model.Proprietario;

public class ProprietarioTelPers {
	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		Proprietario proprietario = new Proprietario();
		proprietario.setTelefone("Sebastião");
		proprietario.getTelefones().add("(23) 2323-2323");
		proprietario.getTelefones().add("(23) 2323-2323");
		manager.persist(proprietario);
		tx.commit();
		manager.close();
		JpaUtil.close();
	}
}
