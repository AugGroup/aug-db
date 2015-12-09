package com.aug.hrdb.repositories.impl;

import org.springframework.stereotype.Repository;

import com.aug.hrdb.entities.MasTechnology;
import com.aug.hrdb.repositories.MasTechnologyRepository;

@Repository(value="masTechnologyRepository")
public class MasTechnologyRepositoryImpl extends GenericRepositoryImpl<MasTechnology, Integer> implements MasTechnologyRepository {

	public MasTechnologyRepositoryImpl() {
		super(MasTechnology.class);
	}

}