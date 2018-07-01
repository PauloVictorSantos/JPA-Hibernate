package br.jus.util;

import java.util.List;

import javax.persistence.EntityManager;

import br.jus.hibernate.model.Veiculo;
import br.jus.hibernate.model.VeiculoId;

public class BuscandoVeiculoProp {
	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		//List<Veiculo> veiculos = manager.createQuery("from Veiculo",Veiculo.class).getResultList();
		
		Veiculo veiculo = manager.find(Veiculo.class, new VeiculoId("ABC-4543","Fortaleza"));
		
		//for(Veiculo veiculo:veiculos){
			System.out.println(veiculo.getModelo()+" - "+veiculo.getProprietario().getNome());
		//}
		
		manager.close();
		JpaUtil.close();
	}
}
