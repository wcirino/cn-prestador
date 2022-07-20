package com.cn.novaera.cnprestador.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.novaera.cnprestador.dto.ExameDTO;
import com.cn.novaera.cnprestador.feign.client.Cn_exameFeign;

@Service
public class ExameServiceClient {

	@Autowired
	private Cn_exameFeign service;
	
	private static final Logger LOG = LoggerFactory.getLogger(ConsultaServiceClient.class);
	
	public ExameDTO findIdExame(int id) throws Exception {
		LOG.info("Iniciando a comunicação com outro microsserivo CN-Consulta");
		try {
			ExameDTO dto = service.findIDExame(id).getBody();
			LOG.info("Retornando comunicação com outro microsserivo CN-Consulta");
			return dto;
		} catch (Exception e) {
			throw new Exception("Ocorreu um erro não previsto no sistema /n "+e.getMessage());
		}
	}
	
	public List<ExameDTO> findAllExame() throws Exception {
		LOG.info("Iniciando a comunicação com outro microsserivo CN-Consulta");
		try {
			List<ExameDTO> dto = service.findAllExame().getBody();
			LOG.info("Retornando comunicação com outro microsserivo CN-Consulta");
			return dto;
		} catch (Exception e) {
			throw new Exception("Ocorreu um erro não previsto no sistema /n "+e.getMessage());
		}
	}
	
	/*
	 * public List<ExameDTO> findconsultaBetween(String data1,String data2) throws
	 * Exception{
	 * 
	 * LOG.info("Inicio chamada do microservico findconsultaBetween");
	 * Optional<List<ExameDTO>> obj =
	 * Optional.ofNullable(service.find_Consultas_between(data1, data2).getBody());
	 * LOG.info("Fim findconsultaBetween"); return obj.orElseThrow(() -> new
	 * Exception()); }
	 */
	
	/*
	 * public List<ExameDTO> findconsultaPage(int page,int limit) throws Exception{
	 * 
	 * LOG.info("Inicio chamada do microservico findconsultaBetween");
	 * Optional<List<ExameDTO>> obj =
	 * Optional.ofNullable(service.findDataoneSolicitacao_page(page,
	 * limit).getBody()); LOG.info("Fim findconsultaBetween"); return
	 * obj.orElseThrow(() -> new Exception()); }
	 */
	
	public ExameDTO beneficiarioinsert(ExameDTO dto) throws Exception {
		try {
			LOG.info("Iniciando comunicação com o web service cn-beneficiario");
			ExameDTO obj = service.InsertExame(dto).getBody();
			LOG.info("Retornando os dados da  comunicação com o web service cn-beneficiario");
			return obj;

		} catch (Exception e) {
			throw new Exception("ocorreu um erro não esperado /n" + e.getMessage());
		}
	}

	
}
