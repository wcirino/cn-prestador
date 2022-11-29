package com.cn.novaera.cnprestador.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cn.novaera.cnprestador.dto.userDTO;
import com.cn.novaera.cnprestador.service.PrestadorService;
import com.cn.novaera.cnprestador.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "User", description = "user que acessam o sistema", tags = {"user EndPoint"})
@RestController
@RequestMapping(value = "/api-user")
public class UserController {

	@Autowired
	PrestadorService PrestProxy;
	
	@Autowired
	UserService service;
	
	@ApiOperation(value = "Buscalogin user")
	@GetMapping(value = "/login/{login}")
	public ResponseEntity<userDTO> findLogin(@PathVariable String login) throws Exception{
		userDTO user = service.findUserLoginService(login);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@ApiOperation(value = "Busca email user")
	@GetMapping(value = "/email/{email}")
	public ResponseEntity<userDTO> findEmail(@PathVariable String email) throws Exception{
		userDTO user = service.findUserLoginService(email);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
}
