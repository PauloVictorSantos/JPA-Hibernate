package br.jus.util;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.jus.hibernate.model.Acessorio;
import br.jus.hibernate.model.Proprietario;
import br.jus.hibernate.model.TipoCombustivel;
import br.jus.hibernate.model.Veiculo;
import br.jus.hibernate.model.VeiculoId;

public class ManyToManyVeicAcessPers {

	public static void main(String[] args) {
		EntityManager manager =  JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		Acessorio alarme= new Acessorio();
		alarme.setDescricao("Alarme");
		
		Acessorio arCondicionado = new Acessorio();
		arCondicionado.setDescricao("Ar condicionado");
		
		Acessorio bancoDecouro = new Acessorio();
		bancoDecouro.setDescricao("Banco de couro");
		
		Acessorio direcaoHidralica = new Acessorio();
		direcaoHidralica.setDescricao("Direção Hidráulica");
		
		//persiste acessorios
		manager.persist(alarme);
		manager.persist(arCondicionado);
		manager.persist(bancoDecouro);
		manager.persist(direcaoHidralica);
		
		Proprietario proprietario = new Proprietario();
		proprietario.setNome("João das Couves");
		proprietario.setTelefone("(34) 1234-5678");
		manager.persist(proprietario);
		
		Veiculo veiculo1 = new Veiculo();
		veiculo1.setId(new VeiculoId("ABC-2012","Fortaleza"));
		veiculo1.setFabricante("VW");
		veiculo1.setModelo("Gol");
		veiculo1.setAnoFabricacao(2010);
		veiculo1.setAnoModelo(2010);
		veiculo1.setValor(new BigDecimal(12.200));
		veiculo1.setTipoCombustivel(TipoCombustivel.BICOMBUSTIVEL);
		veiculo1.setDataCadastro(new Date());
		veiculo1.getAcessorio().add(alarme);
		veiculo1.getAcessorio().add(arCondicionado);
		veiculo1.setProprietario(proprietario);
		
		Veiculo veiculo2 = new Veiculo();
		veiculo2.setId(new VeiculoId("ABC-2042","Fortaleza"));
		veiculo2.setFabricante("Hyundai");
		veiculo2.setModelo("i30");
		veiculo2.setAnoFabricacao(2012);
		veiculo2.setAnoModelo(2012);
		veiculo2.setValor(new BigDecimal(2012));
		veiculo2.setTipoCombustivel(TipoCombustivel.BICOMBUSTIVEL);
		veiculo2.setDataCadastro(new Date());
		veiculo2.getAcessorio().add(alarme);
		veiculo2.getAcessorio().add(arCondicionado);
		veiculo2.getAcessorio().add(bancoDecouro);
		veiculo2.getAcessorio().add(direcaoHidralica);
		veiculo2.getAcessorio().add(direcaoHidralica);
		veiculo2.setProprietario(proprietario);
		
		manager.persist(veiculo1);
		manager.persist(veiculo2);
		
		tx.commit();
		
		manager.close();
		JpaUtil.close();
	}

}
