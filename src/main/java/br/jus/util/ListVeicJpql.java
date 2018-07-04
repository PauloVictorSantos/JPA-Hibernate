package br.jus.util;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.jus.hibernate.model.Veiculo;

public class ListVeicJpql {

	public static void main(String[] args) {

		EntityManager manager = JpaUtil.getEntityManager();
		String jpql = "from Veiculo";

		System.out.print("Registros por página: ");

		Scanner scanner = new Scanner(System.in);
		int registrosPorPagina = scanner.nextInt();
		int numeroDaPagina = 0;

		TypedQuery<Veiculo> query = manager.createQuery(jpql, Veiculo.class);

		do {
			System.out.print("Número da página: ");
			numeroDaPagina = scanner.nextInt();
			if (numeroDaPagina != 0) {
				int primeiroRegistro = (numeroDaPagina - 1) * registrosPorPagina;
				query.setFirstResult(primeiroRegistro);
				query.setMaxResults(registrosPorPagina);
				List<Veiculo> veiculos = query.getResultList();
				System.out.println(veiculos.size() + " itens");

				for (Veiculo veiculo : veiculos) {
					System.out.println(
							veiculo.getModelo() + " " + veiculo.getFabricante() + ": " + veiculo.getAnoFabricacao());
				}

			}
		} while (numeroDaPagina != 0);
		scanner.close();
		manager.close();
		JpaUtil.close();
	}
}
