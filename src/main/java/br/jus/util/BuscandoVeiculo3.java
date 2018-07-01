package br.jus.util;

import javax.persistence.EntityManager;

import br.jus.hibernate.model.Veiculo;

public class BuscandoVeiculo3 {

	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		
		Veiculo veiculo1 = manager.getReference(Veiculo.class, 1L);
		System.out.println("Buscou veículo pela primeira vez...");
		
		System.out.println("Gerenciado ?"+manager.contains(veiculo1));
		manager.detach(veiculo1);
		System.out.println("E agora ? "+manager.contains(veiculo1));
		
		Veiculo veiculo2 = manager.getReference(Veiculo.class, 2L);
		
		System.out.println("Buscou veículo pela segunda vez...");
		
		System.out.println("Gerenciado ?"+manager.contains(veiculo2));
		manager.detach(veiculo2);
		System.out.println("E agora ? "+manager.contains(veiculo2));
		
		
		
		System.out.println("Mesmo veículo ? "+(veiculo1==veiculo2));
		
		manager.close();
		JpaUtil.close();

	}

}
