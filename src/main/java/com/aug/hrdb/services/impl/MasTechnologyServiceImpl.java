package com.aug.hrdb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.MasTechnology;
import com.aug.hrdb.repositories.MasTechnologyRepository;
import com.aug.hrdb.services.MasTechnologyService;

@Service("masTechnologyService")
@Transactional
public class MasTechnologyServiceImpl implements MasTechnologyService{

	@Autowired
	private MasTechnologyRepository masTechnologyRepository;
	
	
	
	@Override
	public void create(MasTechnology masTechnology) {
		// TODO Auto-generated method stub
		masTechnologyRepository.create(masTechnology);
		
	}

	@Override
	public void update(MasTechnology masTechnology) {
		// TODO Auto-generated method stub
		masTechnologyRepository.update(masTechnology);
	}

	@Override
	public MasTechnology find(Integer id) {
		// TODO Auto-generated method stub
		MasTechnology mastech = masTechnologyRepository.find(id);
		return mastech;
	}
	
	@Override
	public void delete(MasTechnology masTechnology) {
		// TODO Auto-generated method stub
		masTechnologyRepository.delete(masTechnology);
	}

	@Override
	public List<MasTechnology> findAll() {
		// TODO Auto-generated method stub
		List<MasTechnology> mastech = masTechnologyRepository.findAll();
		return mastech;
	}

}
