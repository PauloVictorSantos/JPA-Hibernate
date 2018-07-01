package br.jus.util;

import javax.persistence.EntityManager;

import br.jus.hibernate.model.Veiculo;

public class BuscandoVeiculo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		
		Veiculo veiculo = manager.find(Veiculo.class, 1L);
		
		System.out.println("Veiculo de código "+veiculo.getId().getPlaca() + " ano um "+veiculo.getModelo());
		System.out.println("Descrição do veículo "+veiculo.getDescricao());
		
		manager.close();
		JpaUtil.close();

	}

}
