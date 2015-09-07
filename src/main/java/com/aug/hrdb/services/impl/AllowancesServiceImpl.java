/**
 *
 * @author Preeyaporn
 * @date 3 มิ.ย. 2558
 */
package com.aug.hrdb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.Allowances;
import com.aug.hrdb.repositories.AllowancesRepository;
import com.aug.hrdb.services.AllowancesService;

@Service("allowancesService")
@Transactional
public class AllowancesServiceImpl implements AllowancesService {

	@Autowired
	private AllowancesRepository allowancesRepository;
	
	@Override
	public List<Allowances> findAll() {
		return allowancesRepository.findAll();
	}

	@Override
	public void create(Allowances allowances) {
		allowancesRepository.create(allowances);
	}

	@Override
	public void update(Allowances allowances) {
		allowancesRepository.update(allowances);
	}

	@Override
	public void delete(Allowances allowances) {
		allowancesRepository.delete(allowances);
	}

	@Override
	public Allowances findById(Integer id) {
		return allowancesRepository.find(id);
	}

//	@Override
//	public List<Allowances> findByCriteria(Allowances allowances) {
//		return allowancesDao.findByCriteria(allowances);
//	}

	@Override
	public void deleteById(Integer id) {
		allowancesRepository.deleteById(id);
	}

}
