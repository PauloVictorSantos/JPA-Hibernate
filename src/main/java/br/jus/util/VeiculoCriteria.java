package br.jus.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.jus.hibernate.model.TipoCombustivel;
import br.jus.hibernate.model.Veiculo;

public class VeiculoCriteria {
	public static void main(String[] args) {
		List<Veiculo> veiculos = pesquisarVeiculo(
				TipoCombustivel.BICOMBUSTIVEL, new BigDecimal(400));
		for(Veiculo v:veiculos){
			System.out.println(v.getModelo()+" - "+v.getValor());
		}
	}

	public static List<Veiculo> pesquisarVeiculo(TipoCombustivel tipoCombustivelcombustivel, BigDecimal maiorValor) {
		EntityManager manager = JpaUtil.getEntityManager();
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Veiculo> criteriaQuery = builder.createQuery(Veiculo.class);

		Root<Veiculo> veiculo = criteriaQuery.from(Veiculo.class);
		criteriaQuery.select(veiculo);

		@SuppressWarnings("rawtypes")
		List<Predicate> predicates = new ArrayList<Predicate>();

		if (tipoCombustivelcombustivel != null) {
			ParameterExpression<TipoCombustivel> paramTipoCombustivel = builder.parameter(TipoCombustivel.class,
					"tipoCombustivel");
			predicates.add(builder.equal(veiculo.get("tipoCombustivel"),
							paramTipoCombustivel));
		}

		if (maiorValor != null) {
			ParameterExpression<BigDecimal> paramValor = builder.parameter(BigDecimal.class, "maiorValor");
			predicates.add(builder.lessThanOrEqualTo(veiculo.<BigDecimal>get("valor"), paramValor));
		}

		criteriaQuery.where((javax.persistence.criteria.Predicate[]) predicates.toArray(new Predicate[0]));

		TypedQuery<Veiculo> query = manager.createQuery(criteriaQuery);

		if (tipoCombustivelcombustivel != null) {
			query.setParameter("tipoCombustivel", tipoCombustivelcombustivel);
		}

		if (maiorValor != null) {
			query.setParameter("maiorValor", maiorValor);
		}

		List<Veiculo> veiculos = query.getResultList();
		manager.close();
		return veiculos;
	}
}
