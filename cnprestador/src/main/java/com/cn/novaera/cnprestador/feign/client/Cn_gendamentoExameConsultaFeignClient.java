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

import com.cn.novaera.cnprestador.dto.AgendamentoDTO;

@Component

@FeignClient(value = "cn-agendamento-exame-consulta-a", path = "/api-consulta")
public interface Cn_gendamentoExameConsultaFeignClient {

	@GetMapping(value = "/agendamento-all")
	public ResponseEntity<List<AgendamentoDTO>> findAllAgendamento() throws Exception;

	@GetMapping(value = "/agendamento-id/{id}")
	public ResponseEntity<AgendamentoDTO> findIDAgendamento(@PathVariable int id) throws Exception;

	@PostMapping(value = "/agendamento")
	public ResponseEntity<AgendamentoDTO> InsertAgendamento(@RequestBody AgendamentoDTO dto) throws Exception;

	@PutMapping(value = "/agendamento")
	public ResponseEntity<AgendamentoDTO> Updateconsulta(@RequestBody AgendamentoDTO dto) throws Exception;

}
