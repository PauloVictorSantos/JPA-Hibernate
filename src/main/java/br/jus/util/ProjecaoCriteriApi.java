package br.jus.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.jus.hibernate.model.Veiculo;

public class ProjecaoCriteriApi {

	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<String> criteriaQuery = builder.createQuery(String.class);

		Root<Veiculo> veiculo = criteriaQuery.from(Veiculo.class);
		criteriaQuery.select(veiculo.<String>get("modelo"));

		TypedQuery<String> query = manager.createQuery(criteriaQuery);
		List<String> modelos = query.getResultList();
		for (String modelo : modelos) {
			System.out.println(modelo);
		}
	}

}
