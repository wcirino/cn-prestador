package com.cn.novaera.cnprestador.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AgendamentoPageDTO  implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<AgendamentoDTO> lista_consulta;
	private long totalElements;
	private long totalPages;
	private long size;
	private long pageNumber;	
	
}
