package br.jus.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.jus.hibernate.model.Veiculo;

public class VeiculoCriteria {
	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Veiculo> criteriaQuery = builder.createQuery(Veiculo.class);

		Root<Veiculo> veiculo = criteriaQuery.from(Veiculo.class);
		criteriaQuery.select(veiculo);

		TypedQuery<Veiculo> query = manager.createQuery(criteriaQuery);
		List<Veiculo> veiculos = query.getResultList();
		for (Veiculo v : veiculos) {
			System.out.println(v.getModelo());
		}

	}
}
