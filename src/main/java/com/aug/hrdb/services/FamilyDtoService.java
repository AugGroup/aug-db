package com.aug.hrdb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.dto.FamilyDto;
import com.aug.hrdb.repositories.FamilyRepository;



@Service
@Transactional
public class FamilyDtoService {
	
	@Autowired
	private FamilyRepository familyRepository;
	
	
	public  List<FamilyDto> listFamily(Integer id){
		return familyRepository.findFamilyList(id);
		
	}
	

}
