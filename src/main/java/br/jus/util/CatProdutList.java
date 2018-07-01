package br.jus.util;

import javax.persistence.EntityManager;

import br.jus.hibernate.model.Categoria;
import br.jus.hibernate.model.Produto;

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
