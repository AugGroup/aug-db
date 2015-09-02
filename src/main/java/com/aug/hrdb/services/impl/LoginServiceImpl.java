package com.aug.hrdb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.Login;
import com.aug.hrdb.repositories.LoginRepository;
import com.aug.hrdb.services.LoginService;



//import com.aug.hr.entity.Official;


@Service("loginService")
@Transactional
public class LoginServiceImpl implements LoginService{

	@Autowired private LoginRepository loginRepository;
	
	@Override
	public void create(Login login) {
		loginRepository.create(login);
		
	}

	@Override
	public void update(Login login) {
		loginRepository.update(login);
	}

	@Override
	public void delete(Login login) {
		loginRepository.delete(login);
	}

	@Override
	public Login find(Integer id) {
		return loginRepository.find(id);
	}

	@Override
	public List<Login> findAll() {
		return loginRepository.findAll();
	}

	@Override
	public Login findByUserName(String name) {
		return loginRepository.findByUserName(name);
	}

/*	@Override
	public Login deleteById(Integer id) {
		return loginRepository.deleteById(id);
	}*/

	@Override
	public Login searhEmpIdtoLogin() {		
		return loginRepository.searhEmpIdtoLogin();
	}


}
