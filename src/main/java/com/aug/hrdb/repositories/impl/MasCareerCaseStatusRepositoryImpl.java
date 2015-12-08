package com.aug.hrdb.repositories.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.aug.hrdb.entities.MasCareerCaseStatus;
import com.aug.hrdb.repositories.MasCareerCaseStatusRepository;

@Repository(value="masCareerCaseStatusRepository")
public class MasCareerCaseStatusRepositoryImpl extends GenericRepositoryImpl<MasCareerCaseStatus, Integer> implements MasCareerCaseStatusRepository {

	public MasCareerCaseStatusRepositoryImpl() {
		super(MasCareerCaseStatus.class);
	}

	@Override
	public Session getCurrentSession() {
		return super.getCurrentSession();
	}

	@Override
	public List<MasCareerCaseStatus> findAll() throws DataAccessException {
		return super.findAll();
	}

	@Override
	public MasCareerCaseStatus find(Integer id) {
		return super.find(id);
	}

	@Override
	public void create(MasCareerCaseStatus e) {
		super.create(e);
	}

	@Override
	public void update(MasCareerCaseStatus e) {
		super.update(e);
	}

	@Override
	public void delete(MasCareerCaseStatus e) {
		super.delete(e);
	}

	@Override
	public void deleteById(Integer id) {
		super.deleteById(id);
	}

	@Override
	public void flush() {
		super.flush();
	}

}
