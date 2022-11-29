package com.cn.novaera.cnprestador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.novaera.cnprestador.dto.Prestador;
import com.cn.novaera.cnprestador.repository.PrestadorRepository;

@Service
public class PrestadorService {

	@Autowired
	PrestadorRepository prestProxy;

	public List<Prestador> findAll_Prestador() throws Exception{
		Optional<List<Prestador>> obj = Optional.ofNullable(prestProxy.findAll());
		return obj.orElseThrow(() -> new Exception());
	}
		
	public List<Prestador> find_prestador_id(int id) throws Exception{
		Optional<List<Prestador>> obj = Optional.ofNullable(prestProxy.findByidPrest(id));
		return obj.orElseThrow(() -> new Exception());
	}
					
	public Prestador InsertPrestador(Prestador dto) throws Exception{
		if(!prestProxy.existsById(dto.getIdPrest())) {		
			Prestador obj = prestProxy.save(dto);
			return obj;
		}
		else {
			throw new Exception("O Prestador possui Id");
		}
	}
		
	public Prestador UpdatePrestador(Prestador dto) throws Exception{
		if(prestProxy.existsById(dto.getIdPrest())) {
			Prestador obj = prestProxy.save(dto);
			return obj;
		}
		else {
			throw new Exception(""
					+ "O Prestador não possui Id");
		}
	}
		
}
