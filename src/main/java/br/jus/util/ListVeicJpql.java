package br.jus.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.jus.hibernate.model.Veiculo;



public class ListVeicJpql {

	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();

		Query query = manager.createQuery("select v from Veiculo v where anoFabricacao =2012");
		List veiculos = query.getResultList();

		for (Object obj : veiculos) {
			Veiculo veiculo = (Veiculo) obj;
			System.out.println(veiculo.getModelo() + " " + veiculo.getFabricante() + ": " + veiculo.getAnoFabricacao());
		}
	}
}
