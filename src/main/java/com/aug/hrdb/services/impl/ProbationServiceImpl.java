package com.aug.hrdb.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.aug.hrdb.entities.Probation;
import com.aug.hrdb.repositories.ProbationRepository;
import com.aug.hrdb.services.ProbationService;

@Service("probationService")
@Transactional
public class ProbationServiceImpl implements ProbationService{

	@Autowired private ProbationRepository probationRepository;
	@Override
	public List<Probation> findAll() throws DataAccessException {
		return probationRepository.findAll();
	}

	@Override
	public Probation find(Integer id) {
		return probationRepository.find(id);
	}

	@Override
	public void create(Probation probation) {
		probationRepository.create(probation);
		
	}

	@Override
	public void update(Probation probation) {
		probationRepository.update(probation);
		
	}

	@Override
	public void delete(Probation probation) {
		probationRepository.delete(probation);
		
	}

	@Override
	public List<Probation> findByCriteria(Probation probation) {
		return probationRepository.findByCriteria(probation);
	}

	@Override
	public void deleteById(Integer id) {
		probationRepository.deleteById(id);		
	}
}
