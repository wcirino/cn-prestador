
package com.cn.novaera.cnprestador.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.novaera.cnprestador.dto.AgendamentoDTO;
import com.cn.novaera.cnprestador.dto.AgendamentoPageDTO;
import com.cn.novaera.cnprestador.feign.client.Cn_gendamentoExameConsultaFeignClient;


@Service
public class AgendamentoServiceClient {

	@Autowired(required = true)
	private Cn_gendamentoExameConsultaFeignClient service;

	private static final Logger LOG = LoggerFactory.getLogger(ConsultaServiceClient.class);

	public AgendamentoDTO findIdConsulta(int id) throws Exception {
		LOG.info("Iniciando a comunicação com outro microsserivo CN-Consulta");
		try {
			AgendamentoDTO dto = service.findIDAgendamento(id).getBody();
			LOG.info("Retornando comunicação com outro microsserivo CN-Consulta");
			return dto;
		} catch (Exception e) {
			throw new Exception("Ocorreu um erro não previsto no sistema /n " + e.getMessage());
		}
	}

	public List<AgendamentoDTO> findAllConsulta() throws Exception {
		LOG.info("Iniciando a comunicação com outro microsserivo CN-Consulta");
		try {
			List<AgendamentoDTO> dto = service.findAllAgendamento().getBody();
			LOG.info("Retornando comunicação com outro microsserivo CN-Consulta");
			return dto;
		} catch (Exception e) {
			throw new Exception("Ocorreu um erro não previsto no sistema /n " + e.getMessage());
		}
	}

	/*
	 * public List<AgendamentoDTO> findconsultaBetween(String data1, String data2)
	 * throws Exception {
	 * 
	 * LOG.info("Inicio chamada do microservico findconsultaBetween");
	 * Optional<List<AgendamentoDTO>> obj = Optional .ofNullable(service.(data1,
	 * data2).getBody()); LOG.info("Fim findconsultaBetween"); return
	 * obj.orElseThrow(() -> new Exception()); }
	 * 
	 * public List<AgendamentoDTO> findconsultaPage(int page, int limit) throws
	 * Exception {
	 * 
	 * LOG.info("Inicio chamada do microservico findconsultaBetween");
	 * Optional<List<AgendamentoDTO>> obj = Optional
	 * .ofNullable(service.findDataoneSolicitacao_page(page, limit).getBody());
	 * LOG.info("Fim findconsultaBetween"); return obj.orElseThrow(() -> new
	 * Exception()); }
	 */

	public AgendamentoDTO beneficiarioInsert(AgendamentoDTO dto) throws Exception {
		try {
			LOG.info("Iniciando comunicação com o web service cn-beneficiario");
			AgendamentoDTO obj = service.InsertAgendamento(dto).getBody();
			LOG.info("Retornando os dados da  comunicação com o web service cn-beneficiario");
			return obj;

		} catch (Exception e) {
			throw new Exception("ocorreu um erro não esperado /n" + e.getMessage());
		}
	}
	
	public AgendamentoPageDTO findAgendamentoBetweenIDPage(int page,int limit, int id, String start, String end) throws Exception{	
		
		LOG.info("Inicio chamada do microservico findconsultaBetween");
		Optional<AgendamentoPageDTO> obj = Optional.ofNullable(service.findBeneficiarioAgendamentoComIdDataSolicitacao_page(page, limit,id,start,end).getBody());
		LOG.info("Fim findconsultaBetween");
		return obj.orElseThrow(() -> new Exception());
	}
	
	public AgendamentoPageDTO findAgendamentoBetweenSemIDPage(int page, int limit, String start, String end)
			throws Exception {

		LOG.info("Inicio chamada do microservico findconsultaBetween");
		Optional<AgendamentoPageDTO> obj = Optional.ofNullable(service.findBeneficiarioAgendamentoSemIdDataSolicitacao_page(page,limit,start,end).getBody());
		LOG.info("Fim findconsultaBetween");
		return obj.orElseThrow(() -> new Exception());
	}

}
