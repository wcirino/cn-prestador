package com.cn.novaera.cnprestador.feign.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.cn.novaera.cnprestador.dto.ConsultaDTO;
import com.cn.novaera.cnprestador.dto.ConsultaPageDTO;

import io.swagger.annotations.ApiOperation;

@Component
@FeignClient(contextId = "consulta", value = "cn-agendamento-exame-consulta", path ="/api-consulta")
public interface Cn_consultaFeign {

	@GetMapping(value = "/consulta-all")
	public ResponseEntity<List<ConsultaDTO>> findAllConsultas() throws Exception;
	
	@GetMapping(value = "/consulta-id/{id}")
	public ResponseEntity<ConsultaDTO> findIDConsultas(@PathVariable int id) throws Exception;
		
	@GetMapping(value = "/consulta-data-between/{data1}/{data2}")
	public ResponseEntity<List<ConsultaDTO>> find_Consultas_between(@PathVariable String data1,@PathVariable String data2) throws Exception;
	
	@GetMapping(value = "/consulta-all-page/")
	public ResponseEntity<List<ConsultaDTO>> findDataoneSolicitacao_page(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit
	) throws Exception;
		
	@PostMapping(value = "/consulta")
	public ResponseEntity<ConsultaDTO> InsertBeneficiario(@RequestBody ConsultaDTO dto)throws Exception;
	
	@ApiOperation(value = "alterar consulta")
	@PutMapping(value = "/consulta")
	public  ResponseEntity<ConsultaDTO> Updateconsulta(@RequestBody ConsultaDTO dto) throws Exception;
	
	@GetMapping(value = "/consulta-beneficiario-dt-page/")
	public ResponseEntity<ConsultaPageDTO> findBeneficiarioConsultaComIdDataSolicitacao_page(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit,
			@RequestParam int id,
			@RequestParam String startdt,
			@RequestParam String enddt
	) throws Exception;
	
	
	
}
