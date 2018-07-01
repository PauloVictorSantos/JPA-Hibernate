package br.jus.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.jus.hibernate.model.Veiculo;

public class ExcluindoVeiculo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		Veiculo veiculo = manager.find(Veiculo.class, 1L);

		manager.remove(veiculo);

		tx.commit();
		manager.close();
		JpaUtil.close();
	}
}
