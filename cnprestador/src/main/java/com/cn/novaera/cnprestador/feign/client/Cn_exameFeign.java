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

import com.cn.novaera.cnprestador.dto.ExameDTO;
import com.cn.novaera.cnprestador.dto.ExamePageDTO;

@Component
@FeignClient(contextId = "exame", value = "cn-agendamento-exame-consulta", path ="/api-exame")
public interface Cn_exameFeign {

	@GetMapping(value = "/exame")
	public ResponseEntity<List<ExameDTO>> findAllExame() throws Exception;
	
	@GetMapping(value = "/exame-id/{id}")
	public ResponseEntity<ExameDTO> findIDExame(@PathVariable int id) throws Exception;
	
	@PostMapping(value = "/exame")
	public ResponseEntity<ExameDTO> InsertExame(@RequestBody ExameDTO dto)throws Exception;
	
	@PutMapping(value = "/exame")
	public  ResponseEntity<ExameDTO> Updateconsulta(@RequestBody ExameDTO dto) throws Exception;
	
	@GetMapping(value = "/exame-beneficiario-dt-page/")
	public ResponseEntity<ExamePageDTO> findBeneficiarioConsultaSemIdDataSolicitacao_page(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit,
			@RequestParam String startdt,
			@RequestParam String enddt
	) throws Exception;
	
	@GetMapping(value = "/exame-beneficiario-page/")
	public ResponseEntity<ExamePageDTO> findBeneficiarioExameComIdDataSolicitacao_page(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit,
			@RequestParam int id,
			@RequestParam String startdt,
			@RequestParam String enddt
	) throws Exception;
}
