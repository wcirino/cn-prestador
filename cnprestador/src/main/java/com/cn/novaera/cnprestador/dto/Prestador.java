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
	@Column(name = "id_prest")
	private int idPrest;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "cpf")
	private String cpf;
		
	@Column(name = "sexo")
	private int sexo;
	
	@Column(name = "data_nascimento")
	private Date dataNascimento;
	
	@Column(name = "endereco")
	private String endereco;
	
	@Column(name = "cidade")
	private int cidade;
	
	@Column(name = "estados")
	private int estados;
	
	@Column(name = "cep")
	private String cep;
	
	@Column(name = "status_prest")
	private String statusPrest;
	
	@Column(name = "data_cadastro")
	private String dataCadastro;
		
}
