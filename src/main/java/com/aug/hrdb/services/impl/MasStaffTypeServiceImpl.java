package com.aug.hrdb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.MasStaffType;
import com.aug.hrdb.repositories.MasStaffTypeRepository;
import com.aug.hrdb.services.MasStaffTypeService;

@Service(value="masStaffTypeService")
@Transactional
public class MasStaffTypeServiceImpl implements MasStaffTypeService {
	
	@Autowired
	private MasStaffTypeRepository masStaffTypeRepository;

	@Override
	public void create(MasStaffType masStaffType) {
		masStaffTypeRepository.create(masStaffType);
	}

	@Override
	public void update(MasStaffType masStaffType) {
		masStaffTypeRepository.update(masStaffType);
	}

	@Override
	public void delete(MasStaffType masStaffType) {
		masStaffTypeRepository.delete(masStaffType);
	}

	@Override
	public MasStaffType findById(Integer id) {
			return masStaffTypeRepository.find(id);
	}

	@Override
	public List<MasStaffType> findAll() {
		return masStaffTypeRepository.findAll();
	}

	@Override
	public void deleteById(Integer id) {
		masStaffTypeRepository.deleteById(id);
	}

}