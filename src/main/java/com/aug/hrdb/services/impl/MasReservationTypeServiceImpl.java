package com.aug.hrdb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.MasReservationType;
import com.aug.hrdb.repositories.MasReservationTypeRepository;
import com.aug.hrdb.services.MasReservationTypeService;

@Service("masReservationTypeService")
@Transactional
public class MasReservationTypeServiceImpl implements MasReservationTypeService{
	
	@Autowired
	private MasReservationTypeRepository masReservationTypeRepository;

	@Override
	public void create(MasReservationType masReservationType) {
		masReservationTypeRepository.create(masReservationType);
		
	}

	@Override
	public void update(MasReservationType masReservationType) {
		masReservationTypeRepository.update(masReservationType);
	}

	@Override
	public void delete(MasReservationType masReservationType) {
		masReservationTypeRepository.delete(masReservationType);
		
	}


	@Override
	public List<MasReservationType> findAll() {
		return masReservationTypeRepository.findAll();
	}

	@Override
	public MasReservationType findById(Integer Id) {
		return masReservationTypeRepository.find(Id);
	}

	@Override
	public void deleteById(Integer id) {
		masReservationTypeRepository.deleteById(id);
	}
	

}
