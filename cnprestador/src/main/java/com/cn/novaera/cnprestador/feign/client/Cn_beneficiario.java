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
import com.cn.novaera.cnprestador.dto.BeneficiarioDTO;

@Component
@FeignClient(value = "cnbeneficiario", path ="/api-beneficiario")
public interface Cn_beneficiario {

	@GetMapping(value = "/beneficiario/{id}")
	public ResponseEntity<BeneficiarioDTO> findBeneficiario(@PathVariable int id) throws Exception;
	
	@GetMapping(value = "/beneficiarios")
	public ResponseEntity<List<BeneficiarioDTO>> findAllBeneficiarios() throws Exception;

	@PostMapping(value = "/beneficiario")
	public ResponseEntity<BeneficiarioDTO> InsertBeneficiario(@RequestBody BeneficiarioDTO dto)throws Exception;
	
	@PutMapping(value = "/beneficiario")
	public  ResponseEntity<BeneficiarioDTO> UpdateBeneficiario(@RequestBody BeneficiarioDTO dto) throws Exception;
}
