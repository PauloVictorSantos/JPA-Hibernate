package br.jus.hibernate.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="funcionario")
public class Funcionario extends Pessoa {
	private BigDecimal salario;
	private String cargo;
	
	@Column(nullable = true)
	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	@Column(length = 60, nullable = true)
	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

}
