package com.aug.hrdb.repositories.impl;

import org.springframework.stereotype.Repository;

import com.aug.hrdb.entities.MasCareerCaseStatus;
import com.aug.hrdb.repositories.MasCareerCaseStatusRepository;

@Repository(value="masCareerCaseStatusRepository")
public class MasCareerCaseStatusRepositoryImpl extends GenericRepositoryImpl<MasCareerCaseStatus, Integer> implements MasCareerCaseStatusRepository {

	public MasCareerCaseStatusRepositoryImpl() {
		super(MasCareerCaseStatus.class);
	}
	
}
