package com.cn.novaera.cnprestador.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BeneficiarioDTO   implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int idbenef;
	private String nome_comp;
	private String cpfcnpj;
	private String RG;
	private Date data_nasc;
	private int idestado;
	private Integer cidade;
	private String telefone;
	private String celular;
	private String carteirinha;
	private Date data_cadas;
	private int sexo;
	private String ativo;
	
}
