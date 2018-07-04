package br.jus.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.jus.hibernate.model.Veiculo;

public class ListVeicJpql {

	public static void main(String[] args) {

		EntityManager manager = JpaUtil.getEntityManager();
		String jpql = "from Veiculo";
		
		TypedQuery<Veiculo> query = manager.createQuery(jpql,Veiculo.class);
		query.setFirstResult(0);
		query.setMaxResults(10);
		
		List<Veiculo> veiculos = query.getResultList();
		System.out.println(veiculos.size()+" itens");
		for (Veiculo veiculo : veiculos) {
			System.out.println(veiculo.getModelo() + " " + veiculo.getFabricante() + ": " + veiculo.getAnoFabricacao());
		}
	}
}
