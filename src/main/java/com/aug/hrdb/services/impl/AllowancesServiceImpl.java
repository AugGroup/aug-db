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

import com.aug.hrdb.entities.Allowance;
import com.aug.hrdb.repositories.AllowanceRepository;
import com.aug.hrdb.services.AllowanceService;

@Service(value="allowanceService")
@Transactional
public class AllowancesServiceImpl implements AllowanceService {

	@Autowired
	private AllowanceRepository allowancesRepository;
	
	@Override
	public List<Allowance> findAll() {
		return allowancesRepository.findAll();
	}

	@Override
	public void create(Allowance allowances) {
		allowancesRepository.create(allowances);
	}

	@Override
	public void update(Allowance allowances) {
		allowancesRepository.update(allowances);
	}

	@Override
	public void delete(Allowance allowances) {
		allowancesRepository.delete(allowances);
	}

	@Override
	public Allowance findById(Integer id) {
		return allowancesRepository.find(id);
	}

	@Override
	public void deleteById(Integer id) {
		allowancesRepository.deleteById(id);
	}

}
