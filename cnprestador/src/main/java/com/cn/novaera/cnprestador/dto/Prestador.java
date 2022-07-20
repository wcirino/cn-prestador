package com.cn.novaera.cnprestador.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="prestador")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Prestador {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idPrest;
	
	@Column(name = "codprest")
	private String nome;
	
	@Column(name = "cpf")
	private String cpf;
		
	@Column(name = "sexo")
	private int sexo;
	
	@Column(name = "dataNascimento")
	private Date dataNascimento;
	
	@Column(name = "endereco")
	private String endereco;
	
	@Column(name = "cidade")
	private int cidade;
	
	@Column(name = "estados")
	private int estados;
	
	@Column(name = "cep")
	private String cep;
	
	@Column(name = "statusPrest")
	private String statusPrest;
	
	@Column(name = "dataCadastro")
	private String dataCadastro;
		
}
