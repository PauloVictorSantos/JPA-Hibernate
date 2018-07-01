package br.jus.util;

import javax.persistence.EntityManager;

import br.jus.hibernate.model.Veiculo;

public class BuscandoVeiculo2 {

	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		
		Veiculo veiculo = manager.getReference(Veiculo.class, 1L);
		
		System.out.println("Veiculo de código "+veiculo.getId().getPlaca() + " é um "+veiculo.getModelo());
		
		manager.close();
		JpaUtil.close();

	}

}
