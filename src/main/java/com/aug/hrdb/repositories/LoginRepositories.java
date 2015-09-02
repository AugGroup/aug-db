package com.aug.hrdb.repositories;

import java.util.List;
import com.aug.hr.entity.Login;

public interface LoginRepositories extends GenericDao<Login, Integer>{

	public Login findByUserName(String name);
	
	public Login deleteById(Integer id);

	public Login searhEmpIdtoLogin();
}
