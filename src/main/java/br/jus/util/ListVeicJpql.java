package br.jus.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.jus.hibernate.model.Veiculo;

public class ListVeicJpql {

	public static void main(String[] args) {

		EntityManager manager = JpaUtil.getEntityManager();
		String jpql = "select modelo from Veiculo";
		
		TypedQuery<String> query = manager.createQuery(jpql,String.class);
		
		List<String> modelos = query.getResultList();

		for (String modelo : modelos) {
			System.out.println(modelo);
		}
	}
}
