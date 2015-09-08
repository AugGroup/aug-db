package com.aug.hrdb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.dto.EmployeeCodeDto;
import com.aug.hrdb.repositories.EmployeeRepository;

@Service
@Transactional
public class EmployeeCodeDtoService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	public EmployeeCodeDto serchRunningNo(String code){
		return employeeRepository.serchRunningNo(code);		
	}

}
