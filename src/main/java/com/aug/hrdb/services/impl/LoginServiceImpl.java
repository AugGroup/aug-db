package com.aug.hrdb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hr.dao.LoginDao;
import com.aug.hr.entity.Login;
import com.aug.hr.entity.Official;
import com.aug.hr.services.LoginService;

@Service("loginService")
@Transactional
public class LoginServiceImpl implements LoginService{

	@Autowired private LoginRepositories loginRepositories;
	
	@Override
	public void create(Login login) {
		loginRepositories.create(login);
		
	}

	@Override
	public void update(Login login) {
		loginRepositories.update(login);
	}

	@Override
	public void delete(Login login) {
		loginRepositories.delete(login);
	}

	@Override
	public Login find(Integer id) {
		return loginRepositories.find(id);
	}

	@Override
	public List<Login> findAll() {
		return loginRepositories.findAll();
	}

	@Override
	public Login findByUserName(String name) {
		return loginRepositories.findByUserName(name);
	}

	@Override
	public Login deleteById(Integer id) {
		return loginRepositories.deleteById(id);
	}
	
	@Override
	public Login searhEmpIdtoLogin() {		
		return loginRepositories.searhEmpIdtoLogin();
	}

}
