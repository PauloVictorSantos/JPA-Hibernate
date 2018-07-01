package br.jus.util;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.jus.hibernate.model.Proprietario;
import br.jus.hibernate.model.TipoCombustivel;
import br.jus.hibernate.model.Veiculo;
import br.jus.hibernate.model.VeiculoId;

public class PersistVeiculoProp {
	public static void main (String[]args) throws IOException{
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

		Proprietario proprietario = new Proprietario();
		proprietario.setNome("Paulo Victor");
		proprietario.setTelefone("(85) 985256702");
		proprietario.setEmail("paulovictorPereiradosSantos");
		
		manager.persist(proprietario);
		
		Veiculo veiculo = new Veiculo();
		veiculo.setId(new VeiculoId("ABC-443", "Fortaleza"));
		veiculo.setFabricante("VW");
		veiculo.setModelo("Gol");
		veiculo.setAnoFabricacao(2010);
		veiculo.setAnoModelo(2010);
		veiculo.setValor(new BigDecimal(17.200));
		veiculo.setTipoCombustivel(TipoCombustivel.BICOMBUSTIVEL);
		veiculo.setDataCadastro(new Date());
		veiculo.setProprietario(proprietario);
		veiculo.setEspecificacao(especificacoes.toString());
		veiculo.setFoto(foto);
		
		manager.persist(veiculo);
		tx.commit();
		manager.close();
		JpaUtil.close();
		
	}
}
