package com.aug.hrdb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.Punish;
import com.aug.hrdb.repositories.PunishRepository;
import com.aug.hrdb.services.PunishService;


@Service("punishService")
@Transactional
public class PunishServiceImpl implements PunishService {
	
	@Autowired
	private  PunishRepository punishRepository;

	
	
	@Override
	public List<Punish> findAll() {
			return punishRepository.findAll();
	}
	
	@Override
	public void create(Punish punish) {
		punishRepository.create(punish);
		
	}

	@Override
	public void update(Punish punish) {
		punishRepository.update(punish);
		
	}

	@Override
	public void delete(Punish punish) {
		punishRepository.delete(punish);
		
	}

	@Override
	public Punish findById(Integer id) {
		return punishRepository.find(id);
	}


	@Override
	public List<Punish> findByCriteria(Punish punish) {
		return punishRepository.findByCriteria(punish);
	}

	@Override
	public Punish deleteById(Integer id) {
		return punishRepository.deleteById(id);
	}


	
	
	

}
