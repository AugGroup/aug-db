package com.aug.hrdb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.MasJoblevel;
import com.aug.hrdb.services.MasJoblevelService;

@Service("masJoblevelService")
@Transactional
public class MasJoblevelServiceImpl implements MasJoblevelService {

	
	@Autowired private MasJoblevelRepositories masJoblevelRepositories;
	
	@Override
	public void create(MasJoblevel masJoblevel) {
		masJoblevelRepositories.create(masJoblevel);
		
	}

	@Override
	public void update(MasJoblevel masJoblevel) {
		masJoblevelRepositories.update(masJoblevel);
		
	}

	@Override
	public void delete(MasJoblevel masJoblevel) {
		masJoblevelRepositories.delete(masJoblevel);
		
	}

	@Override
	public MasJoblevel find(Integer id) {
		
		return masJoblevelRepositories.find(id);
	}

	@Override
	public List<MasJoblevel> findAll() {
		// TODO Auto-generated method stub
		return masJoblevelRepositories.findAll();
	}

	@Override
	public List<MasJoblevel> findByCriteria(MasJoblevel masJoblevel) {
		// TODO Auto-generated method stub
		return masJoblevelRepositories.findByCriteria(masJoblevel);
	}

	@Override
	public MasJoblevel deleteById(Integer id) {
		// TODO Auto-generated method stub
		return masJoblevelRepositories.deleteById(id);
	}

}
