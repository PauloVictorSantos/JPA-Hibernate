package br.jus.hibernate.model;

import javax.persistence.EntityManager;

import br.jus.util.JpaUtil;

public class CatProdutList {

	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		Categoria categoria = manager.find(Categoria.class, 5L);
		System.out.println("Categoria " + categoria.getNome());

		for (Produto produto : categoria.getProdutos()) {
			System.out.println("Produto: " + produto.getNome());
		}

		manager.close();
		JpaUtil.close();
	}

}
