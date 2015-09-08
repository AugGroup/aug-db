package com.aug.hrdb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.dto.EmployeeIdDto;
import com.aug.hrdb.repositories.EmployeeRepository;

@Service
@Transactional
public class EmployeeIdDtoService {
	
	@Autowired
	private EmployeeRepository employeeDaoRepository;
	
	public EmployeeIdDto findCurrentId(){
		return employeeDaoRepository.findCurrentId();		
	}

}
