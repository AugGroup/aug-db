package com.aug.hrdb.repositories.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.aug.hrdb.entities.MasStaffType;
import com.aug.hrdb.repositories.MasStaffTypeRepository;



@Repository
public class MasStaffTypeRepositoryImpl extends GenericRepositoryImpl<MasStaffType, Integer> implements MasStaffTypeRepository,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MasStaffTypeRepositoryImpl() {
		super(MasStaffType.class);
	}

}
