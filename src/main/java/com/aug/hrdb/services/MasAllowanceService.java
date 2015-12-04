/**
 *
 * @author Preeyaporn
 * @date 5 มิ.ย. 2558
 */
package com.aug.hrdb.services;

import java.util.List;

import com.aug.hrdb.entities.MasAllowance;

public interface MasAllowanceService {

	public void create(MasAllowance masAllowances);
	public void update(MasAllowance masAllowances);
	public void delete(MasAllowance masAllowances);
	public MasAllowance find(Integer id);
	public List<MasAllowance> findAll();
	public List<MasAllowance> findByCriteria(MasAllowance masAllowances);
	public void deleteById(Integer id);
	
}
