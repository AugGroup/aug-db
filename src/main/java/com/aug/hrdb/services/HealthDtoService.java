package com.aug.hrdb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.dto.HealthDto;
import com.aug.hrdb.repositories.HealthRepository;


@Service
@Transactional
public class HealthDtoService {
	
	@Autowired
	private HealthRepository healthRepository;
	
	
	public  List<HealthDto> listHealth(Integer id){
		return healthRepository.listHealth(id);
		
	}
	

}
