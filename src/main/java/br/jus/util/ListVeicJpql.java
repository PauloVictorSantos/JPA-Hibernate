package br.jus.util;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.jus.hibernate.model.Veiculo;

public class ListVeicJpql {

	public static void main(String[] args) {

		EntityManager manager = JpaUtil.getEntityManager();
		String jpql = "select v from Veiculo v where anoFabricacao >=:ano and valor <=:preco";
		
		Query query = manager.createQuery(jpql);
		query.setParameter("ano", 2009);
		query.setParameter("preco",new BigDecimal(60000));
		
		List veiculos = query.getResultList();

		for (Object obj : veiculos) {
			Veiculo veiculo = (Veiculo) obj;
			System.out.println(veiculo.getModelo() + " " + veiculo.getFabricante() + ": " + veiculo.getAnoFabricacao());
		}
	}
}
