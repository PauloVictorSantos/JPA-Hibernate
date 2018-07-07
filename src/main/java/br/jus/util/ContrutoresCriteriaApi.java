package br.jus.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import br.jus.hibernate.model.Veiculo;

public class ContrutoresCriteriaApi {

	public static void main(String[] args) {
		EntityManager manager= JpaUtil.getEntityManager();
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Veiculo>criteriaQuery = builder.createQuery(Veiculo.class);
		
		Root<Veiculo> veiculo = criteriaQuery.from(Veiculo.class);
		Order order = builder.desc(veiculo.<String>get("anoFabricacao"));
		
		criteriaQuery.select(veiculo);
		criteriaQuery.orderBy(order);
		
		TypedQuery<Veiculo> query = manager.createQuery(criteriaQuery);
		List<Veiculo> resultado = query.getResultList();
		
		for(Veiculo veic: resultado){
			System.out.println(veic.getModelo()+" - "+veic.getValor());
		}
	}

}
