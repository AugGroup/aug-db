package com.aug.hrdb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.MasSpecialty;
import com.aug.hrdb.repositories.MasSpecialtyRepository;
import com.aug.hrdb.services.MasSpecialtyService;



@Service("masSpecialty")
@Transactional
public class MasSpecialtyServiceImpl implements MasSpecialtyService{
	
	@Autowired
	private MasSpecialtyRepository specialtyRepository;
	
	
	public List<MasSpecialty> findAll(){
		return specialtyRepository.findAll();
	}
	
    public void create(MasSpecialty specialty){
    	specialtyRepository.create(specialty);
    }
    
    public void update(MasSpecialty specialty){
    	specialtyRepository.update(specialty);
    }
    
    public void delete(MasSpecialty specialty){
    	specialtyRepository.delete(specialty);
    }

	public MasSpecialty findById(Integer id) {
		return specialtyRepository.find(id);
	}

	public List<MasSpecialty> findByCriteria(MasSpecialty  specialty){
		return specialtyRepository.findByCriteria(specialty);
	}

	public void deleteById(Integer id){
		 specialtyRepository.deleteById(id);
	}

}
