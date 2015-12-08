package com.aug.hrdb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.MasJobLevel;
import com.aug.hrdb.repositories.MasJobLevelRepository;
import com.aug.hrdb.services.MasJobLevelService;

@Service(value="masJobLevelService")
@Transactional
public class MasJobLevelServiceImpl implements MasJobLevelService {
	
	@Autowired
	private MasJobLevelRepository masJobLevelRepository;
	
	@Override
	public void create(MasJobLevel masJoblevel) {
		masJobLevelRepository.create(masJoblevel);
	}

	@Override
	public void update(MasJobLevel masJoblevel) {
		masJobLevelRepository.update(masJoblevel);
	}

	@Override
	public void delete(MasJobLevel masJoblevel) {
		masJobLevelRepository.delete(masJoblevel);
	}

	@Override
	public MasJobLevel findById(Integer id) {
		return masJobLevelRepository.find(id);
	}

	@Override
	public List<MasJobLevel> findAll() {
		return masJobLevelRepository.findAll();
	}

	@Override
	public List<MasJobLevel> findByCriteria(MasJobLevel masJoblevel) {
		return masJobLevelRepository.findByCriteria(masJoblevel);
	}

	@Override
	public void deleteById(Integer id) {
		masJobLevelRepository.deleteById(id);
	}
	
}