package br.jus.util;

import javax.persistence.EntityManager;

import br.jus.hibernate.model.Proprietario;
import br.jus.hibernate.model.Telefone;

public class ProprTelEmbList {

	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		Proprietario proprietario = manager.find(Proprietario.class, 1L);
		System.out.println("Proprietarios: " + proprietario.getNome());

		for (Telefone telefone : proprietario.getTelefones()) {
			System.out.println("Telefone: (" + telefone.getPrefixo() + ") " + telefone.getNumero()
					+ (telefone.getRamal() != null ? " x" + telefone.getRamal() : ""));
		}
		
		manager.close();
		JpaUtil.close();

	}

}
