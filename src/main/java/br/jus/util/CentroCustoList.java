package br.jus.util;

import javax.persistence.EntityManager;

import br.jus.hibernate.model.CentroCusto;

public class CentroCustoList {

	public static void main(String[] args) {
		EntityManager manager1 = JpaUtil.getEntityManager();
		CentroCusto centro1 = manager1.find(CentroCusto.class, 44L);
		System.out.println("Centro de custo: " + centro1.getNome());
		manager1.close();
		System.out.println("-----");
		EntityManager manager2 = JpaUtil.getEntityManager();
		CentroCusto centro2 = manager2.find(CentroCusto.class, 44L);
		System.out.println("Centro de custo: " + centro2.getNome());
		manager2.close();
		JpaUtil.close();

	}

}
