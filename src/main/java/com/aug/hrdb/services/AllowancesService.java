/**
 *
 * @author Preeyaporn
 * @date 3 มิ.ย. 2558
 */
package com.aug.hrdb.services;

import java.util.List;

import com.aug.hrdb.entities.Allowance;

public interface AllowancesService {

	public List<Allowance> findAll();
	public void create(Allowance allowances);
	public void update(Allowance allowances);
	public void delete(Allowance allowances);
	public Allowance findById(Integer id);
	public void deleteById(Integer id);
}
