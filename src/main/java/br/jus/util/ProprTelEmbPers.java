package br.jus.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.jus.hibernate.model.Proprietario;
import br.jus.hibernate.model.Telefone;

public class ProprTelEmbPers {

	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		Proprietario proprietario = new Proprietario();
		proprietario.setNome("Sebastião");
		proprietario.getTelefones().add(new Telefone("34", "1234-5678", "104"));
		proprietario.getTelefones().add(new Telefone("34", "2121-1212", "122"));
		
		manager.persist(proprietario);
		
		tx.commit();
		manager.close();
		JpaUtil.close();

	}

}
