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
		Categoria categoria = new Categoria();
		categoria.setNome("Bebidas");

		Produto produto1 = new Produto();
		produto1.setNome("Refrigerante");
		produto1.setCategoria(categoria);

		Produto produto2 = new Produto();
		produto2.setNome("Água");
		produto2.setCategoria(categoria);

		Produto produto3 = new Produto();
		produto3.setNome("Cerveja");
		produto3.setCategoria(categoria);

		manager.persist(produto1);
		manager.persist(produto2);
		manager.persist(produto3);

		tx.commit();
		manager.close();
		JpaUtil.close();
	}

}
