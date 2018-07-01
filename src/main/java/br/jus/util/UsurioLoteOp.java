package br.jus.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class UsurioLoteOp {
	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
//		Query query = manager.createQuery("update Usuario set ativo = false where email like :email");
//		query.setParameter("email", "%@algaworks.com");
		Query query = manager.createQuery("delete from Usuario where ativo = false");
		
		int linhasAfetadas = query.executeUpdate();
		System.out.println(linhasAfetadas + " registros atualizados.");

		tx.commit();
		manager.close();
		JpaUtil.close();

	}
}
