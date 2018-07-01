package br.jus.util;

import java.util.List;

import javax.persistence.EntityManager;

import br.jus.hibernate.model.Cliente;

public class PessoaListHeranca {
	public static void main(String []args){
		EntityManager manager = JpaUtil.getEntityManager();
		List<Cliente> clientes = manager.createQuery("from Cliente",Cliente.class).getResultList();
		for(Cliente cliente:clientes){
			System.out.println(cliente.getNome()+" - "+cliente.getRendaMensal());
		}
	}
}
