package com.aug.hrdb.repositories.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.aug.hrdb.entities.MasTechnology;
import com.aug.hrdb.repositories.MasTechnologyRepository;

@Repository
public class MasTechnologyRepositoryImpl extends GenericRepositoryImpl<MasTechnology, Integer> implements MasTechnologyRepository{

	public MasTechnologyRepositoryImpl() {
		super(MasTechnology.class);
	}

	
}
