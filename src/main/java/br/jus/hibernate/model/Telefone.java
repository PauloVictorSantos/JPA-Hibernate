package br.jus.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Telefone {

	private String prefixo;
	private String numero;
	private String ramal;

	public Telefone() {
	}

	public Telefone(String prefixo, String numero, String ramal) {
		super();
		this.prefixo = prefixo;
		this.numero = numero;
		this.ramal = ramal;
	}

	@Column(length = 3, nullable = false)
	public String getPrefixo() {
		return prefixo;
	}

	public void setPrefixo(String prefixo) {
		this.prefixo = prefixo;
	}

	@Column(length = 20, nullable = false)
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Column(length = 5)
	public String getRamal() {
		return ramal;
	}

	public void setRamal(String ramal) {
		this.ramal = ramal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((prefixo == null) ? 0 : prefixo.hashCode());
		result = prime * result + ((ramal == null) ? 0 : ramal.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefone other = (Telefone) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (prefixo == null) {
			if (other.prefixo != null)
				return false;
		} else if (!prefixo.equals(other.prefixo))
			return false;
		if (ramal == null) {
			if (other.ramal != null)
				return false;
		} else if (!ramal.equals(other.ramal))
			return false;
		return true;
	}

}
