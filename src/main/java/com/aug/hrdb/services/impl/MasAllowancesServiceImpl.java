/**
 *
 * @author Preeyaporn
 * @date 5 มิ.ย. 2558
 */
package com.aug.hrdb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.MasAllowances;
import com.aug.hrdb.repositories.MasAllowancesRepository;
import com.aug.hrdb.services.MasAllowancesService;

@Service("masAllowancesService")
@Transactional
public class MasAllowancesServiceImpl implements MasAllowancesService{

	@Autowired
	private MasAllowancesRepository masAllowancesRepository;
	
	@Override
	public void create(MasAllowances masAllowances) {
		masAllowancesRepository.create(masAllowances);
	}

	@Override
	public void update(MasAllowances masAllowances) {
		masAllowancesRepository.update(masAllowances);
	}

	@Override
	public void delete(MasAllowances masAllowances) {
		masAllowancesRepository.delete(masAllowances);
	}

	@Override
	public MasAllowances find(Integer id) {
		return masAllowancesRepository.find(id);
	}

	@Override
	public List<MasAllowances> findAll() {
		return masAllowancesRepository.findAll();
	}

	@Override
	public List<MasAllowances> findByCriteria(MasAllowances masAllowances) {
		return masAllowancesRepository.findByCriteria(masAllowances);
	}

	@Override
	public void deleteById(Integer id) {
		masAllowancesRepository.deleteById(id);
	}

}
