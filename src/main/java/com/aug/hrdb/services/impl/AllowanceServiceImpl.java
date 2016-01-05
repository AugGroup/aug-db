/**
 *
 * @author Preeyaporn
 * @date 3 มิ.ย. 2558
 */
package com.aug.hrdb.services.impl;

import java.util.List;

import com.aug.hrdb.dto.AllowanceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.Allowance;
import com.aug.hrdb.repositories.AllowanceRepository;
import com.aug.hrdb.services.AllowanceService;

@Service(value="allowanceService")
@Transactional
public class AllowanceServiceImpl implements AllowanceService {

	@Autowired
	private AllowanceRepository allowanceRepository;
	
	@Override
	public List<Allowance> findAll() {
		return allowanceRepository.findAll();
	}

	@Override
	public void create(Allowance allowances) {
		allowanceRepository.create(allowances);
	}

	@Override
	public void update(Allowance allowances) {
		allowanceRepository.update(allowances);
	}

	@Override
	public void delete(Allowance allowances) {
		allowanceRepository.delete(allowances);
	}

	@Override
	public Allowance findById(Integer id) {
		return allowanceRepository.find(id);
	}

	@Override
	public void deleteById(Integer id) {
		allowanceRepository.deleteById(id);
	}

	@Override
	public List<AllowanceDto> searchAllowances(Integer id) {
		return allowanceRepository.searchAllowances(id);
	}

}
