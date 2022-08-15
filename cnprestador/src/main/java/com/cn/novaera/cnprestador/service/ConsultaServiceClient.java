package com.cn.novaera.cnprestador.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cn.novaera.cnprestador.dto.ConsultaDTO;
import com.cn.novaera.cnprestador.dto.ConsultaPageDTO;
import com.cn.novaera.cnprestador.feign.client.Cn_consultaFeign;

@Service
public class ConsultaServiceClient {

	@Autowired
	private Cn_consultaFeign service;
	
	private static final Logger LOG = LoggerFactory.getLogger(ConsultaServiceClient.class);
	
	public ConsultaDTO findIdConsulta(int id) throws Exception {
		LOG.info("Iniciando a comunicação com outro microsserivo CN-Consulta");
		try {
			ConsultaDTO dto = service.findIDConsultas(id).getBody();
			LOG.info("Retornando comunicação com outro microsserivo CN-Consulta");
			return dto;
		} catch (Exception e) {
			throw new Exception("Ocorreu um erro não previsto no sistema /n "+e.getMessage());
		}
	}
	
	public List<ConsultaDTO> findAllConsulta(int id) throws Exception {
		LOG.info("Iniciando a comunicação com outro microsserivo CN-Consulta");
		try {
			List<ConsultaDTO> dto = service.findAllConsultas().getBody();
			LOG.info("Retornando comunicação com outro microsserivo CN-Consulta");
			return dto;
		} catch (Exception e) {
			throw new Exception("Ocorreu um erro não previsto no sistema /n "+e.getMessage());
		}
	}
	
	public List<ConsultaDTO> findconsultaBetween(String data1,String data2) throws Exception{	
		
		LOG.info("Inicio chamada do microservico findconsultaBetween");
		Optional<List<ConsultaDTO>> obj = Optional.ofNullable(service.find_Consultas_between(data1, data2).getBody());
		LOG.info("Fim findconsultaBetween");
		return obj.orElseThrow(() -> new Exception());
	}
	
	public List<ConsultaDTO> findconsultaPage(int page,int limit) throws Exception{	
		
		LOG.info("Inicio chamada do microservico findconsultaBetween");
		Optional<List<ConsultaDTO>> obj = Optional.ofNullable(service.findDataoneSolicitacao_page(page, limit).getBody());
		LOG.info("Fim findconsultaBetween");
		return obj.orElseThrow(() -> new Exception());
	}
	
	public ConsultaDTO beneficiarioUpdate(ConsultaDTO dto) throws Exception {
		try {
			LOG.info("Iniciando comunicação com o web service cn-beneficiario");
			ConsultaDTO obj = service.InsertBeneficiario(dto).getBody();
			LOG.info("Retornando os dados da  comunicação com o web service cn-beneficiario");
			return obj;

		} catch (Exception e) {
			throw new Exception("ocorreu um erro não esperado /n" + e.getMessage());
		}
	}

	public ConsultaPageDTO findExameBetweenIDPage(int page, int limit, int id, String start, String end) throws Exception {

		LOG.info("Inicio chamada do microservico findconsultaBetween");
		Optional<ConsultaPageDTO> obj = Optional.ofNullable(service.findBeneficiarioConsultaComIdDataSolicitacao_page(page, limit, id, start, end).getBody());
		LOG.info("Fim findconsultaBetween");
		return obj.orElseThrow(() -> new Exception());
	}
	
}
