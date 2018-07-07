package br.jus.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import br.jus.hibernate.model.Proprietario;
import br.jus.hibernate.model.Veiculo;

public class ContrutoresCriteriaApi {

	public static void main(String[] args) {
		EntityManager manager= JpaUtil.getEntityManager();
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Veiculo>criteriaQuery = builder.createQuery(Veiculo.class);
		
		Subquery<Double> subquery = criteriaQuery.subquery(Double.class);
		Root<Veiculo> veiculo1 = criteriaQuery.from(Veiculo.class);
		Join<Veiculo, Proprietario> proprietario  = veiculo1.join("proprietario");
		Root<Veiculo> veiculo2 = subquery.from(Veiculo.class);

		subquery.select(builder.avg(veiculo2.<Double>get("valor")));
		
		criteriaQuery.select(veiculo1);
		criteriaQuery.where(
				builder.greaterThanOrEqualTo(
						veiculo1.<Double> get("valor"), subquery));
		
		TypedQuery<Veiculo> query = manager.createQuery(criteriaQuery);
		List<Veiculo> resultado = query.getResultList();
		
		for(Veiculo veic: resultado){
			System.out.println(veic.getModelo()+" - "+veic.getValor()+" - "+veic.getProprietario().getNome());
		}
	}

}
