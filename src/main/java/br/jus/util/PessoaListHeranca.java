package br.jus.util;

import java.util.List;

import javax.persistence.EntityManager;

import br.jus.hibernate.model.Pessoa;

public class PessoaListHeranca {
	public static void main(String []args){
		EntityManager manager = JpaUtil.getEntityManager();
		List<Pessoa> pessoas = manager.createQuery("from Pessoa",Pessoa.class).getResultList();
		for(Pessoa pessoa:pessoas){
			System.out.println(pessoa.getNome()+" - "+pessoa.getId());
		}
	}
}
