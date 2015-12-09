package com.aug.hrdb.repositories.impl;

import org.springframework.stereotype.Repository;

import com.aug.hrdb.entities.MasStaffType;
import com.aug.hrdb.repositories.MasStaffTypeRepository;

@Repository(value="masStaffTypeRepository")
public class MasStaffTypeRepositoryImpl extends GenericRepositoryImpl<MasStaffType, Integer> implements MasStaffTypeRepository {

	public MasStaffTypeRepositoryImpl() {
		super(MasStaffType.class);
	}

}