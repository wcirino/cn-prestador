package com.cn.novaera.cnprestador.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cn.novaera.cnprestador.dto.ConsultaDTO;
import com.cn.novaera.cnprestador.dto.ConsultaPageDTO;
import com.cn.novaera.cnprestador.service.ConsultaServiceClient;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Consultas", description = "Consultas medicas", tags = {"Consultas EndPoint"})
@RestController
@RequestMapping(value ="/api-prest-consultas")
public class ConsultaController {

	@Autowired
	private ConsultaServiceClient proxyConsult;
	
	@Autowired
	private static final Logger LOG = LoggerFactory.getLogger(ConsultaController.class); 
	
	@ApiOperation(value = "Busca todas as consultas")
	@GetMapping(value = "/consulta-all")
	public ResponseEntity<List<ConsultaDTO>> findAllConsultas() throws Exception{
        LOG.info("Consulta ...");
		List<ConsultaDTO> consult = proxyConsult.findAllConsulta(1);
		return new ResponseEntity<>(consult,HttpStatus.OK);
	}
	
	@ApiOperation(value = "Busca consulta por id")
	@GetMapping(value = "/consulta-id/{id}")
	public ResponseEntity<?> findIDConsultas(@PathVariable int id) throws Exception{
		ConsultaDTO consult = proxyConsult.findIdConsulta(id);
		return new ResponseEntity<>(consult,HttpStatus.OK);
	}
	
	@ApiOperation(value = "Busca todas as consultas entre datas between")
	@GetMapping(value = "/consulta-data-between/{data1}/{data2}")
	public ResponseEntity<?> find_Consultas_between(@PathVariable String data1,@PathVariable String data2) throws Exception{
					
		List<ConsultaDTO> consult = proxyConsult.findconsultaBetween(data1,data2);
		return new ResponseEntity<>(consult,HttpStatus.OK);
	}
	
	@ApiOperation(value ="Consulta paginada all")
	@GetMapping(value = "/consulta-all-page/")
	public ResponseEntity<?> findDataoneSolicitacao_page(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit
	) throws Exception{
		
		List<ConsultaDTO> consult = proxyConsult.findconsultaPage(page,limit);
		return new ResponseEntity<>(consult,HttpStatus.OK);
	}
	
	@ApiOperation(value = "inserir consultas")
	@PostMapping(value = "/consulta")
	public ResponseEntity<?> InsertBeneficiario(@RequestBody ConsultaDTO dto)throws Exception{
		return new  ResponseEntity<>(proxyConsult.beneficiarioUpdate(dto),HttpStatus.CREATED);
	}
	
	@ApiOperation(value ="Consulta paginada com beneficiario e seu id all")
	@GetMapping(value = "/consulta-beneficiario-dt-page/")
	public ResponseEntity<?> findBeneficiarioConsultaComIdDataSolicitacao_page(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit,
			@RequestParam int id,
			@RequestParam String startdt,
			@RequestParam String enddt
	) throws Exception{

        LOG.info("Consulta paginada com beneficiario e seu id all");
		ConsultaPageDTO consult = proxyConsult.findExameBetweenIDPage(page, limit, id, startdt, enddt);
		LOG.info("fim Consulta paginada com beneficiario e seu id all");
		return new ResponseEntity<>(consult,HttpStatus.OK);
	}
}
