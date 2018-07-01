package br.jus.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.jus.hibernate.model.Produto;

public class ProdutCatList {

	public static void main(String[] args) {

		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();

		Produto produto = manager.find(Produto.class, 6L);

		System.out.println("Nome:" + produto.getNome());
		System.out.println("Nome:" + produto.getCategoria().getNome());
		
		manager.close();
		JpaUtil.close();
		
	}

}
