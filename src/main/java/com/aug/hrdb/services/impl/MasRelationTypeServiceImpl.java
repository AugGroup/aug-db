package com.aug.hrdb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.MasRelationType;
import com.aug.hrdb.repositories.MasRelationTypeRepository;
import com.aug.hrdb.services.MasRelationTypeService;


@Service
@Transactional
public class MasRelationTypeServiceImpl implements MasRelationTypeService{
	
	@Autowired
	private MasRelationTypeRepository masRelationTypeRepository;

	@Override
	public void create(MasRelationType masRelationType) {
		// TODO Auto-generated method stub
		masRelationTypeRepository.create(masRelationType);
	}

	@Override
	public void update(MasRelationType masRelationType) {
		// TODO Auto-generated method stub
		masRelationTypeRepository.update(masRelationType);
	}

	@Override
	public void delete(MasRelationType masRelationType) {
		// TODO Auto-generated method stub
		masRelationTypeRepository.delete(masRelationType);
	}

	@Override
	public MasRelationType find(Integer Id) {
		// TODO Auto-generated method stub
		MasRelationType masRelationType = masRelationTypeRepository.find(Id);
		return masRelationType;
	}

	@Override
	public List<MasRelationType> findAll() {
		// TODO Auto-generated method stub
		List<MasRelationType> masRelationTypeList = masRelationTypeRepository.findAll();
		return masRelationTypeList;
	}

	@Override
	public MasRelationType findByName(String name) {
		// TODO Auto-generated method stub
		MasRelationType masRelation = masRelationTypeRepository.findByName(name);
		return masRelation;
	}

}
