package br.jus.util;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.jus.hibernate.model.Proprietario;
import br.jus.hibernate.model.TipoCombustivel;
import br.jus.hibernate.model.Veiculo;
import br.jus.hibernate.model.VeiculoId;

public class ManyTonePersist {

	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();

		tx.begin();
		
		Proprietario proprietario = new Proprietario();
		proprietario.setNome("João das Couves");
		proprietario.setTelefone("(34) 1234-5678");
		
		manager.persist(proprietario);
		
		Veiculo veiculo1 = new Veiculo();
		veiculo1.setId(new VeiculoId("ABC-212","Fortaleza"));
		veiculo1.setFabricante("GM");
		veiculo1.setModelo("Celta");
		veiculo1.setAnoFabricacao(2006);
		veiculo1.setAnoModelo(2006);
		veiculo1.setValor(new BigDecimal(11.000));
		veiculo1.setTipoCombustivel(TipoCombustivel.GASOLINA);
		veiculo1.setDataCadastro(new Date());
		veiculo1.setProprietario(proprietario);
		
		manager.persist(veiculo1);
		
		Veiculo veiculo2 = new Veiculo();
		veiculo2.setId(new VeiculoId("ABC-214","Fortaleza"));
		veiculo2.setFabricante("VW");
		veiculo2.setModelo("Gol");
		veiculo2.setAnoFabricacao(2010);
		veiculo2.setAnoModelo(2010);
		veiculo2.setValor(new BigDecimal(17.00));
		veiculo2.setTipoCombustivel(TipoCombustivel.BICOMBUSTIVEL);
		veiculo2.setDataCadastro(new Date());
		veiculo2.setProprietario(proprietario);
		
		manager.persist(veiculo2);
		
		tx.commit();
		manager.close();
		JpaUtil.close();
	}

}
