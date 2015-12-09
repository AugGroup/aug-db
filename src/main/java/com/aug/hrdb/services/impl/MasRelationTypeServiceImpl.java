package com.aug.hrdb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.MasRelationType;
import com.aug.hrdb.repositories.MasRelationTypeRepository;
import com.aug.hrdb.services.MasRelationTypeService;

@Service(value="masRelationTypeService")
@Transactional
public class MasRelationTypeServiceImpl implements MasRelationTypeService {
	
	@Autowired
	private MasRelationTypeRepository masRelationTypeRepository;

	@Override
	public void create(MasRelationType masRelationType) {
		masRelationTypeRepository.create(masRelationType);
	}

	@Override
	public void update(MasRelationType masRelationType) {
		masRelationTypeRepository.update(masRelationType);
	}

	@Override
	public void delete(MasRelationType masRelationType) {
		masRelationTypeRepository.delete(masRelationType);
	}

	@Override
	public MasRelationType findById(Integer Id) {
		return masRelationTypeRepository.find(Id);
	}

	@Override
	public List<MasRelationType> findAll() { 
		return masRelationTypeRepository.findAll();
	}

	@Override
	public MasRelationType findByName(String name) {
		return masRelationTypeRepository.findByName(name);
	}

	@Override
	public void deleteById(Integer id) {
		masRelationTypeRepository.deleteById(id);
	}

}