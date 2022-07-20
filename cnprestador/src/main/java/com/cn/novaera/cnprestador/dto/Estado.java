package com.cn.novaera.cnprestador.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estado")
public class Estado {
	
	@Id
	@Column(name = "idestado")
	private int idestado;
	
	@Column(name = "estado")
	private String estado;
	

	public Estado() {
		super();
	}

	public Estado(int idestado, String estado) {
		super();
		this.idestado = idestado;
		this.estado = estado;
	}

	public int getIdestado() {
		return idestado;
	}

	public void setIdestado(int idestado) {
		this.idestado = idestado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
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
		Estado other = (Estado) obj;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (idestado != other.idestado)
			return false;
		return true;
	} 
	
	

}
