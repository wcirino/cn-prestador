package com.cn.novaera.cnprestador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.novaera.cnprestador.dto.Prestador;
import com.cn.novaera.cnprestador.dto.userDTO;
import com.cn.novaera.cnprestador.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public userDTO findUserLoginService(String login) throws Exception {
		return repository.findByLogin(login);
	}
	
	public userDTO findUserEmailService(String email) throws Exception {
		return repository.findByLogin(email);
	}
	
	public userDTO InsertUserPrestador(userDTO dto) throws Exception {
		userDTO obj = repository.save(dto);
		return obj;
	}
	
	public List<userDTO> findUserServiceALL() throws Exception {
		return repository.findAll();
	}
	
}
