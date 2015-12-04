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

import com.aug.hrdb.entities.MasAllowance;
import com.aug.hrdb.repositories.MasAllowanceRepository;
import com.aug.hrdb.services.MasAllowanceService;

@Service("masAllowancesService")
@Transactional
public class MasAllowanceServiceImpl implements MasAllowanceService{

	@Autowired
	private MasAllowanceRepository masAllowancesRepository;
	
	@Override
	public void create(MasAllowance masAllowances) {
		masAllowancesRepository.create(masAllowances);
	}

	@Override
	public void update(MasAllowance masAllowances) {
		masAllowancesRepository.update(masAllowances);
	}

	@Override
	public void delete(MasAllowance masAllowances) {
		masAllowancesRepository.delete(masAllowances);
	}

	@Override
	public MasAllowance find(Integer id) {
		return masAllowancesRepository.find(id);
	}

	@Override
	public List<MasAllowance> findAll() {
		return masAllowancesRepository.findAll();
	}

	@Override
	public List<MasAllowance> findByCriteria(MasAllowance masAllowances) {
		return masAllowancesRepository.findByCriteria(masAllowances);
	}

	@Override
	public void deleteById(Integer id) {
		masAllowancesRepository.deleteById(id);
	}

}
