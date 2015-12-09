package com.aug.hrdb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.MasSpecialty;
import com.aug.hrdb.repositories.MasSpecialtyRepository;
import com.aug.hrdb.services.MasSpecialtyService;

@Service(value="masSpecialtyService")
@Transactional
public class MasSpecialtyServiceImpl implements MasSpecialtyService{
	
	@Autowired
	private MasSpecialtyRepository masSpecialtyRepository;
	
	public List<MasSpecialty> findAll(){
		return masSpecialtyRepository.findAll();
	}
	
    public void create(MasSpecialty specialty){
    	masSpecialtyRepository.create(specialty);
    }
    
    public void update(MasSpecialty specialty){
    	masSpecialtyRepository.update(specialty);
    }
    
    public void delete(MasSpecialty specialty){
    	masSpecialtyRepository.delete(specialty);
    }

	public MasSpecialty findById(Integer id) {
		return masSpecialtyRepository.find(id);
	}

	public List<MasSpecialty> findByCriteria(MasSpecialty  specialty){
		return masSpecialtyRepository.findByCriteria(specialty);
	}

	public void deleteById(Integer id){
		 masSpecialtyRepository.deleteById(id);
	}

}