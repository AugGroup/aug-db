/**
 *
 * @author Pranrajit
 * @date 25 พ.ค. 2558
 */
package com.aug.hrdb.services;

import java.util.List;

import com.aug.hrdb.entities.Leave;





public interface LeaveService {

	public List<Leave> findAll();
	public void create(Leave leave);
	public void update(Leave leave);
	public void delete(Leave leave);
	public Leave  findById(Integer id);
	//public List<Leave> findByCriteria(Leave leave);
	public Leave deleteById(Integer id);
	//public List<Leave> findLeaveType(Integer idLeave,Integer idEmp);
}
