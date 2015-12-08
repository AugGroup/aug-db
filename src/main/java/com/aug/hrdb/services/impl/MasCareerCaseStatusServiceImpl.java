package com.aug.hrdb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.MasCareerCaseStatus;
import com.aug.hrdb.repositories.MasCareerCaseStatusRepository;
import com.aug.hrdb.services.MasCareerCaseStatusService;

@Service(value="masCareerCaseStatusService")
@Transactional
public class MasCareerCaseStatusServiceImpl implements MasCareerCaseStatusService {
	
	@Autowired
	private MasCareerCaseStatusRepository masCareerCaseStatusRepository;

	@Override
	public void create(MasCareerCaseStatus masCareerCaseStatus) {
		masCareerCaseStatusRepository.create(masCareerCaseStatus);
	}

	@Override
	public void update(MasCareerCaseStatus masCareerCaseStatus) {
		masCareerCaseStatusRepository.update(masCareerCaseStatus);
	}

	@Override
	public void delete(MasCareerCaseStatus masCareerCaseStatus) {
		masCareerCaseStatusRepository.delete(masCareerCaseStatus);
	}

	@Override
	public MasCareerCaseStatus findById(Integer id) {
		return masCareerCaseStatusRepository.find(id);
	}

	@Override
	public List<MasCareerCaseStatus> findAll() {
		return masCareerCaseStatusRepository.findAll();
	}

	@Override
	public void deleteById(Integer id) {
		masCareerCaseStatusRepository.deleteById(id);
	}
	
}
