package br.jus.util;

import javax.persistence.EntityManager;

import br.jus.hibernate.model.Proprietario;
import br.jus.hibernate.model.Veiculo;

public class ListPropVeic {
	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		Proprietario proprietario = manager.find(Proprietario.class, new Long(1L).intValue());

		System.out.println("Proprietario: " + proprietario.getNome());
		for (Veiculo veiculo : proprietario.getVeiculos()) {
			System.out.println(veiculo.getModelo());
		}
		manager.close();
		JpaUtil.close();

	}
}
