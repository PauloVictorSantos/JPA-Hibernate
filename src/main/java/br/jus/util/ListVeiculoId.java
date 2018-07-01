package br.jus.util;

import javax.persistence.EntityManager;

import br.jus.hibernate.model.Veiculo;
import br.jus.hibernate.model.VeiculoId;

public class ListVeiculoId {
	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();

		VeiculoId id = new VeiculoId("ABC-1234", "Uberlândia");
		Veiculo veiculo = manager.find(Veiculo.class, id);
		System.out.println("Placa: " + veiculo.getId().getPlaca());
		System.out.println("Cidade: " + veiculo.getId().getCidade());
		System.out.println("Fabricante: " + veiculo.getFabricante());
		System.out.println("Modelo: " + veiculo.getModelo());

		manager.close();
		JpaUtil.close();

	}
}
