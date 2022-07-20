
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
import org.springframework.web.bind.annotation.RestController;

import com.cn.novaera.cnprestador.dto.AgendamentoDTO;
import com.cn.novaera.cnprestador.service.AgendamentoServiceClient;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Prestador agendamento", description = "agendamentos medicos", tags = { "Agendamentos EndPoint" })

@RestController

@RequestMapping(value = "/api-prest-agendamento")
public class AgendamentoController {

	@Autowired
	private AgendamentoServiceClient agendamentoProxy;

	private static final Logger LOG = LoggerFactory.getLogger(AgendamentoController.class);

	@ApiOperation(value = "Busca todos agendamento")

	@GetMapping(value = "/agendamento-all")
	public ResponseEntity<?> findAllAgendamento() throws Exception {
		LOG.info("Iniciando  controller agendamento Metodo: findAll_agendamento");
		List<AgendamentoDTO> agendamento = agendamentoProxy.findAllConsulta();
		LOG.info("Fim da chamada endpoint agendamento  : FindAll_agendamento");
		return new ResponseEntity<>(agendamento, HttpStatus.OK);
	}

	@ApiOperation(value = "Busca agendamento por id")

	@GetMapping(value = "/agendamento-id/{id}")
	public ResponseEntity<?> findIDAgendamento(@PathVariable int id) throws Exception {
		LOG.info("Iniciando  controller agendamento Metodo: findID ");
		AgendamentoDTO agendamento = agendamentoProxy.findIdConsulta(id);
		LOG.info("Iniciando  controller agendamento Metodo: ");
		return new ResponseEntity<>(agendamento, HttpStatus.OK);
	}

	@ApiOperation(value = "inserir agendamento")

	@PostMapping(value = "/agendamento")
	public ResponseEntity<?> InsertAgendamento(@RequestBody AgendamentoDTO dto) throws Exception {
		LOG.info("Iniciando  controller agendamento Metodo: inseriragendamento");
		return new ResponseEntity<>(agendamentoProxy.beneficiarioInsert(dto), HttpStatus.CREATED);
	}

	/*
	 * @ApiOperation(value = "alterar agendamento")
	 * 
	 * @PutMapping(value = "/agendamento") public ResponseEntity<?>
	 * Updateconsulta(@RequestBody AgendamentoDTO dto) throws Exception {
	 * LOG.info("Iniciando  controller agendamento Metodo: Updateagendamento");
	 * return new ResponseEntity<>(agendamentoProxy.(dto), HttpStatus.OK); }
	 */

}
