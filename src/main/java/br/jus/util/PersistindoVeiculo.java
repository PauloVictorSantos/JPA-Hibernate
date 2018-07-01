package br.jus.util;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.jus.hibernate.model.Veiculo;
import br.jus.hibernate.model.VeiculoId;

public class PersistindoVeiculo {

	public static void main(String[] args) throws IOException {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();

		tx.begin();

		
		Path path = FileSystems.getDefault().getPath("C:/Users/Paulo Victor/Pictures/projeto/index.png");
		System.out.println(path);

		byte[] foto = Files.readAllBytes(path);

		StringBuilder especificacoes = new StringBuilder();
		especificacoes.append("Carro em excelente estado.\n");
		especificacoes.append("Completo, menos ar.\n");
		especificacoes.append("Primeiro dono, com manual de instrução ");
		especificacoes.append("e todas as revisões feitas.\n");
		especificacoes.append("IPVA pago, aceita financiamento.");

		Veiculo veiculo = new Veiculo();
		veiculo.setId(new VeiculoId("ABC-1231", "Uberlândia"));
		veiculo.setFabricante("Honda");
		veiculo.setModelo("Civic");
		veiculo.setAnoFabricacao(2012);
		veiculo.setAnoModelo(2013);
		veiculo.setValor(new BigDecimal(71300));
		veiculo.setEspecificacao(especificacoes.toString());
		veiculo.setFoto(foto);
		manager.persist(veiculo);

		tx.commit();

		manager.close();
		JpaUtil.close();

	}

}
