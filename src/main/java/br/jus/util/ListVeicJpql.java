package br.jus.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.jus.hibernate.model.PrecoVeiculo;

public class ListVeicJpql {

	public static void main(String[] args) {

		EntityManager manager = JpaUtil.getEntityManager();
		String jpql = "select new br.jus.hibernate.model. PrecoVeiculo(modelo, valor) from Veiculo";

		TypedQuery<PrecoVeiculo> query = manager.createQuery(jpql, PrecoVeiculo.class);

		List<PrecoVeiculo> resul = query.getResultList();

		for (PrecoVeiculo preco : resul) {

			System.out.println(preco.getModelo() + " - " + preco.getValor());
		}
	}
}
