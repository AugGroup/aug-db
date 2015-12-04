package com.aug.hrdb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.MasJobLevel;
import com.aug.hrdb.repositories.MasJoblevelRepository;
import com.aug.hrdb.services.MasJoblevelService;

@Service("masJoblevelService")
@Transactional
public class MasJoblevelServiceImpl implements MasJoblevelService {

	
	@Autowired private MasJoblevelRepository masJoblevelRepository;
	
	@Override
	public void create(MasJobLevel masJoblevel) {
		masJoblevelRepository.create(masJoblevel);
		
	}

	@Override
	public void update(MasJobLevel masJoblevel) {
		masJoblevelRepository.update(masJoblevel);
		
	}

	@Override
	public void delete(MasJobLevel masJoblevel) {
		masJoblevelRepository.delete(masJoblevel);
		
	}

	@Override
	public MasJobLevel find(Integer id) {
		return masJoblevelRepository.find(id);
	}

	@Override
	public List<MasJobLevel> findAll() {
		return masJoblevelRepository.findAll();
	}

	@Override
	public List<MasJobLevel> findByCriteria(MasJobLevel masJoblevel) {
		return masJoblevelRepository.findByCriteria(masJoblevel);
	}


}
