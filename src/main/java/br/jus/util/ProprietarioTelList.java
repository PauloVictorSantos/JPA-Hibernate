package br.jus.util;

import javax.persistence.EntityManager;

import br.jus.hibernate.model.Proprietario;

public class ProprietarioTelList {

	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		Proprietario proprietario = manager.find(Proprietario.class, 10L);
		
		System.out.println("Proprietário: " + proprietario.getNome());
		for (String telefone : proprietario.getTelefones()) {
			System.out.println("Telefone: " + telefone);
		}
		manager.close();
		JpaUtil.close();

	}

}
