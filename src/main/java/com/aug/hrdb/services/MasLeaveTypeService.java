/**
 *
 * @author Pranrajit
 * @date 25 พ.ค. 2558
 */
package com.aug.hrdb.services;

import java.util.List;

import com.aug.hrdb.entities.MasLeaveType;

public interface MasLeaveTypeService {

	public void create(MasLeaveType masLeaveType);
	public void update(MasLeaveType masLeaveType);
	public void delete(MasLeaveType masLeaveType);
	public MasLeaveType findById(Integer id);
	public List<MasLeaveType> findAll();
	public List<MasLeaveType> findByCriteria(MasLeaveType masLeaveType);
	public void deleteById(Integer id);
	
}
