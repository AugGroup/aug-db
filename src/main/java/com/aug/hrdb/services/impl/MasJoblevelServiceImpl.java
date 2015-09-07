package com.aug.hrdb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.MasJoblevel;
import com.aug.hrdb.repositories.MasJoblevelRepository;
import com.aug.hrdb.services.MasJoblevelService;

@Service("masJoblevelService")
@Transactional
public class MasJoblevelServiceImpl implements MasJoblevelService {

	
	@Autowired private MasJoblevelRepository masJoblevelRepository;
	
	@Override
	public void create(MasJoblevel masJoblevel) {
		masJoblevelRepository.create(masJoblevel);
		
	}

	@Override
	public void update(MasJoblevel masJoblevel) {
		masJoblevelRepository.update(masJoblevel);
		
	}

	@Override
	public void delete(MasJoblevel masJoblevel) {
		masJoblevelRepository.delete(masJoblevel);
		
	}

	@Override
	public MasJoblevel find(Integer id) {
		
		return masJoblevelRepository.find(id);
	}

	@Override
	public List<MasJoblevel> findAll() {
		// TODO Auto-generated method stub
		return masJoblevelRepository.findAll();
	}

	@Override
	public List<MasJoblevel> findByCriteria(MasJoblevel masJoblevel) {
		// TODO Auto-generated method stub
		return masJoblevelRepository.findByCriteria(masJoblevel);
	}


}
