package br.jus.util;

import javax.persistence.EntityManager;

import br.jus.hibernate.model.Acessorio;
import br.jus.hibernate.model.Veiculo;
import br.jus.hibernate.model.VeiculoId;

public class ManyToManyVeicAcessList {
	public static void main(String[]args){
		EntityManager manager = JpaUtil.getEntityManager();
		//Veiculo veiculo = manager.find(Veiculo.class, new VeiculoId("ABC-2012","Fortaleza"));
		Acessorio acessorio = manager.find(Acessorio.class, 6L);
		System.out.println("Veículo: "+acessorio.getDescricao());
		
		for(Veiculo veiculo :acessorio.getVeiculo()){
			System.out.println("Veiculo "+veiculo.getModelo());
		}
		
		manager.close();
		JpaUtil.close();
	}
}
