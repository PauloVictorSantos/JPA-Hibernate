package br.jus.util;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ListVeicJpql {

	public static void main(String[] args) {

		EntityManager manager = JpaUtil.getEntityManager();
		String jpql = "select count(v) from Veiculo v";

		TypedQuery<Long> query = manager.createQuery(jpql, Long.class);

		Long resul = query.getSingleResult();

		System.out.println("Quantidade de veículos: " + resul);
	}
}
