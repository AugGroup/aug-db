package com.aug.hrdb.repositories;

import java.util.List;

import com.aug.hrdb.entities.Login;


public interface LoginRepository extends GenericRepository<Login, Integer>{

	public Login findByUserName(String name);
	
	//public Login deleteById(Integer id);

	public Login searhEmpIdtoLogin();
}
