package com.aug.hrdb.services;

import java.util.List;

import com.aug.hrdb.entities.MasCareerCaseStatus;

public interface MasCareerCaseStatusService {
	
	public void create(MasCareerCaseStatus masCareerCaseStatus);
	public void update(MasCareerCaseStatus masCareerCaseStatus);
	public void delete(MasCareerCaseStatus masCareerCaseStatus);
	public MasCareerCaseStatus findById(Integer id);
	public List<MasCareerCaseStatus> findAll();
	public void deleteById(Integer id);

}
