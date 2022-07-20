package com.cn.novaera.cnprestador.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cidade")
public class Cidade {

	@Id
	@Column(name = "idcidade")
	private int idcidade;
	
	@Column(name = "cidade")
	private String cidade;
	
	@Column(name = "idestado")
	private int idestado;

	
	
	public Cidade() {
		super();
	}

	public Cidade(int idcidade, String cidade, int idestado) {
		super();
		this.idcidade = idcidade;
		this.cidade = cidade;
		this.idestado = idestado;
	}

	public int getIdcidade() {
		return idcidade;
	}

	public void setIdcidade(int idcidade) {
		this.idcidade = idcidade;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public int getIdestado() {
		return idestado;
	}

	public void setIdestado(int idestado) {
		this.idestado = idestado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + idcidade;
		result = prime * result + idestado;
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
		Cidade other = (Cidade) obj;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (idcidade != other.idcidade)
			return false;
		if (idestado != other.idestado)
			return false;
		return true;
	}
	
	
	
}
