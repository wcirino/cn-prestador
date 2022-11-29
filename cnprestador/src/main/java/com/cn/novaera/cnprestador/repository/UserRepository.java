package com.cn.novaera.cnprestador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cn.novaera.cnprestador.dto.userDTO;

@Repository
public interface UserRepository extends JpaRepository<userDTO,Integer>{

	userDTO findByLogin(String login);
	userDTO findByEmail(String email);
	userDTO save(int id);
}
