package br.jus.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.jus.hibernate.model.Categoria;
import br.jus.hibernate.model.Produto;

public class ProdutCatPers {

	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		Categoria categoria = manager.find(Categoria.class, 10L);
		Produto produto = manager.find(Produto.class, 9L);
		categoria.getProdutos().remove(produto);

		tx.commit();
		manager.close();
		JpaUtil.close();

	}

}
