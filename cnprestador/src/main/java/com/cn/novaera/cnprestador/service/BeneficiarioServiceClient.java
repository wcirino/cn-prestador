package com.cn.novaera.cnprestador.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.novaera.cnprestador.dto.BeneficiarioDTO;
import com.cn.novaera.cnprestador.feign.client.Cn_beneficiario;

@Service
public class BeneficiarioServiceClient {

	@Autowired
	private Cn_beneficiario service;
	
	private static final Logger LOG = LoggerFactory.getLogger(BeneficiarioServiceClient.class);
	
	public List<BeneficiarioDTO> findAllService() throws Exception{
		LOG.info("Iniciando comunicação com o web service cn-beneficiario");
		Optional<List<BeneficiarioDTO>> obj = Optional.ofNullable(service.findAllBeneficiarios().getBody());
		LOG.info("Retornando os dados da  comunicação com o web service cn-beneficiario");
		return obj.orElseThrow(() -> new Exception());		
	}
	
	public BeneficiarioDTO findAIDService(int id) throws Exception{
		LOG.info("Iniciando comunicação com o web service cn-beneficiario");
		Optional<BeneficiarioDTO> obj = Optional.ofNullable(service.findBeneficiario(id).getBody());
		LOG.info("Retornando os dados da  comunicação com o web service cn-beneficiario");
		return obj.orElseThrow(() -> new Exception());		
	}
	
	public BeneficiarioDTO beneficiarioSave(BeneficiarioDTO dto) throws Exception {
		
		try {
		
			LOG.info("Iniciando comunicação com o web service cn-beneficiario");
			BeneficiarioDTO obj = service.InsertBeneficiario(dto).getBody();
			LOG.info("Retornando os dados da  comunicação com o web service cn-beneficiario");
			return obj;
			
		} catch (Exception e) {
			throw new Exception("ocorreu um erro não esperado /n" + e.getMessage());
		}
	}
	
	public BeneficiarioDTO beneficiarioUpdate(BeneficiarioDTO dto) throws Exception {
		
		try {
		
			LOG.info("Iniciando comunicação com o web service cn-beneficiario");
			BeneficiarioDTO obj = service.UpdateBeneficiario(dto).getBody();
			LOG.info("Retornando os dados da  comunicação com o web service cn-beneficiario");
			return obj;
			
		} catch (Exception e) {
			throw new Exception("ocorreu um erro não esperado /n" + e.getMessage());
		}
	}
}
