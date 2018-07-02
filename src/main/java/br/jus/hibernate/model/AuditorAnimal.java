package br.jus.hibernate.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class AuditorAnimal implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PreUpdate
	@PrePersist
	public void alterarDataUltimaAtualizacao(Animal animal){
		animal.setDataUltimaAtualizacao(new Date());
	}
	
}
