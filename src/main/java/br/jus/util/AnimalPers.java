package br.jus.util;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.jus.hibernate.model.Animal;

public class AnimalPers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		Calendar dataNascimento = Calendar.getInstance();
		dataNascimento.set(2011, 2, 1);

		Animal animal = new Animal();
		animal.setNome("Mimosa");
		animal.setDataNascimento(dataNascimento.getTime());
		System.out.println("Idade antes de persistir: " + animal.getIdade());
		manager.persist(animal);
		System.out.println("Idade depois de persistir: " + animal.getIdade());

		tx.commit();
		
		manager.close();
		JpaUtil.close();
	}

}
