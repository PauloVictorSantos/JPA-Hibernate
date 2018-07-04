package br.jus.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.jus.hibernate.model.TotalCarroPorAno;

public class ListVeicJpql {

	public static void main(String[] args) {

		EntityManager manager = JpaUtil.getEntityManager();
		String jpql = "select new br.jus.hibernate.model.TotalCarroPorAno(v.anoFabricacao,"
				+ "avg(v.valor), count(v))"
				+ " from Veiculo v group by v.anoFabricacao";

		TypedQuery<TotalCarroPorAno> query = manager.createQuery(jpql, TotalCarroPorAno.class);

		List<TotalCarroPorAno> resul = query.getResultList();

		for (TotalCarroPorAno valores : resul) {
			System.out.println("Ano: " + valores.getAnoFabricacao() + " - Preço médio: " + valores.getMediaPreco()
					+ " - Quantidade: " + valores.getQuantidadeCarros());
		}
	}
}
