package com.aug.hrdb.repositories.impl;

import org.springframework.stereotype.Repository;

import com.aug.hrdb.entities.MasReservationType;
import com.aug.hrdb.repositories.MasReservationTypeRepository;
@Repository
public class MasReservationTypeRepositoryImpl extends GenericRepositoryImpl<MasReservationType, Integer> implements MasReservationTypeRepository{

	public MasReservationTypeRepositoryImpl() {
		super(MasReservationType.class);
		
	}


}
