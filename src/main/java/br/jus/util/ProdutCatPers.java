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

		// categoria.setNome("Bebidas");
		//
		// Produto produto1 = new Produto();
		// produto1.setNome("Refrigerante");
		// produto1.setCategoria(categoria);
		//
		// categoria.getProdutos().add(produto1);
		// manager.persist(produto1);

		try {
			Categoria categoria = manager.find(Categoria.class, 5L);
			manager.remove(categoria);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			manager.close();
			JpaUtil.close();
		}

	}

}
