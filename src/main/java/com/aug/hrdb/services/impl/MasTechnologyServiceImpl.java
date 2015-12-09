package com.aug.hrdb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.MasTechnology;
import com.aug.hrdb.repositories.MasTechnologyRepository;
import com.aug.hrdb.services.MasTechnologyService;

@Service(value="masTechnologyService")
@Transactional
public class MasTechnologyServiceImpl implements MasTechnologyService {

	@Autowired
	private MasTechnologyRepository masTechnologyRepository;
	
	@Override
	public void create(MasTechnology masTechnology) {
		masTechnologyRepository.create(masTechnology);
	}

	@Override
	public void update(MasTechnology masTechnology) {
		masTechnologyRepository.update(masTechnology);
	}

	@Override
	public MasTechnology findById(Integer id) {
		return masTechnologyRepository.find(id);
	}
	
	@Override
	public void delete(MasTechnology masTechnology) {
		masTechnologyRepository.delete(masTechnology);
	}

	@Override
	public List<MasTechnology> findAll() {
		 return masTechnologyRepository.findAll();
	}

	@Override
	public void deleteById(Integer id) {
		masTechnologyRepository.deleteById(id);
		
	}

}