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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cn.novaera.cnprestador.dto.BeneficiarioDTO;
import com.cn.novaera.cnprestador.service.BeneficiarioServiceClient;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Consultas2", description = "Consultas medicas2", tags = { "Consultas2 EndPoint" })
@RestController
@RequestMapping(value = "/api-prestador-benef")
public class BeneficiarioController {

	@Autowired
	private BeneficiarioServiceClient service;

	private static final Logger LOG = LoggerFactory.getLogger(BeneficiarioController.class);

	@ApiOperation(value = "Busca consulta por id")
	@GetMapping(value = "/beneficiario-all")
	public ResponseEntity<?> findbeneficiarioAll() throws Exception {
		LOG.info("Iniciando findbeneficiarioAll");
		try {
			List<BeneficiarioDTO> lista = service.findAllService();
			LOG.info("Retorno findbeneficiarioAll");
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			throw new Exception("Ocorreu um erro não previsto no sistema");
		}
	}

	@ApiOperation(value = "Busca consulta por id")
	@GetMapping(value = "/beneficiario-id/{id}")
	public ResponseEntity<?> findIdBeneficiario(@PathVariable int id) throws Exception {
		LOG.info("Iniciando findbeneficiarioAll");
		try {
			BeneficiarioDTO dto = service.findAIDService(id);
			LOG.info("Retorno findbeneficiarioAll");
			return new ResponseEntity<>(dto, HttpStatus.OK);
		} catch (Exception e) {
			throw new Exception("Ocorreu um erro não previsto no sistema");
		}
	}

	@ApiOperation(value = "Busca consulta por id")
	@PostMapping(value = "/beneficiario")
	public ResponseEntity<?> InsertBeneficiario(@RequestBody BeneficiarioDTO dto) throws Exception {
		LOG.info("iniciando InsertBeneficiario");
		return new ResponseEntity<>(service.beneficiarioSave(dto), HttpStatus.CREATED);
	}
	 	
	@ApiOperation(value = "Busca consulta por id")
	@PutMapping(value = "/beneficiario")
	public ResponseEntity<?> updateBeneficiario(@RequestBody BeneficiarioDTO dto) throws Exception {
		LOG.info("iniciando InsertBeneficiario");
		return new ResponseEntity<>(service.beneficiarioSave(dto), HttpStatus.CREATED);
	}
	 

}
