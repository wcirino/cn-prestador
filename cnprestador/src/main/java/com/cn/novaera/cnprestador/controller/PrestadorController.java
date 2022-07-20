package com.cn.novaera.cnprestador.controller;

import java.util.List;

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

import com.cn.novaera.cnprestador.dto.Prestador;
import com.cn.novaera.cnprestador.service.PrestadorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Prestador", description = "Prestadores que acessam o sistema", tags = {"Prestador EndPoint"})
@RestController
@RequestMapping(value = "/api-prestador")
public class PrestadorController {

	@Autowired
	PrestadorService PrestProxy;
	
	@ApiOperation(value = "Busca todos os prestadores")
	@GetMapping(value = "/prestador-all")
	public ResponseEntity<?> findAll() throws Exception{
		List<Prestador> prest = PrestProxy.findAll_Prestador();
		return new ResponseEntity<>(prest,HttpStatus.OK);
	}
	
	@ApiOperation(value = "Busca prestador por id")
	@GetMapping(value = "/prestador-id/{id}")
	public ResponseEntity<?> findbyId(@PathVariable int id) throws Exception{
		List<Prestador> prest = PrestProxy.find_prestador_id(id);
		return new ResponseEntity<>(prest,HttpStatus.OK);
	}
	
	@ApiOperation(value = "inserir prestador")
	@PostMapping(value = "/prestador")
	public ResponseEntity<?> InsertPrestador(@RequestBody Prestador dto)throws Exception{
		return new  ResponseEntity<>(PrestProxy.InsertPrestador(dto),HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "alterar prestador")
	@PutMapping(value = "/prestador")
	public  ResponseEntity<?> UpdatePrestador(@RequestBody Prestador dto) throws Exception{
		return new ResponseEntity<>(PrestProxy.UpdatePrestador(dto),HttpStatus.OK);
	}
	
	@ApiOperation(value = "teste")
	@GetMapping(value = "/")
	public ResponseEntity<?> findtest() throws Exception{
		return new ResponseEntity<>("teste ok",HttpStatus.OK);
	}
	
}
