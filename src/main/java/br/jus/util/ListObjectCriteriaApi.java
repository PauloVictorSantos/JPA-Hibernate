package br.jus.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.jus.hibernate.model.Veiculo;

public class ListObjectCriteriaApi {

	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
		Root<Veiculo> veiculo = criteriaQuery.from(Veiculo.class);
		criteriaQuery.multiselect(veiculo.<String>get("modelo"), veiculo.<String>get("valor"));

		TypedQuery<Object[]> query = manager.createQuery(criteriaQuery);
		List<Object[]> resultado = query.getResultList();
		
		for(Object[] valores:resultado){
			System.out.println(valores[0]+" - "+valores[1]);
		}
	}

}
