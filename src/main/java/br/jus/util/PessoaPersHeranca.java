package br.jus.util;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.jus.hibernate.model.Cliente;
import br.jus.hibernate.model.Funcionario;

public class PessoaPersHeranca {

	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Fernando");
		funcionario.setCargo("Gerente");
		funcionario.setSalario(new BigDecimal(12.000));
		
		Cliente cliente = new Cliente();
		cliente.setNome("Mariana");	
		cliente.setRendaMensal(new BigDecimal(8500));
		cliente.setLimiteCredito(new BigDecimal(2.000));
		cliente.setBloqueado(true);
		
		manager.persist(funcionario);
		manager.persist(cliente);
		tx.commit();
		manager.close();
		JpaUtil.close();
	}

}
