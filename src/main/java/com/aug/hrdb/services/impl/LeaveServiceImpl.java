/**
 *
 * @author Pranrajit
 * @date 25 พ.ค. 2558
 */
package com.aug.hrdb.services.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.Leave;
import com.aug.hrdb.repositories.LeaveRepository;
import com.aug.hrdb.services.LeaveService;

@Service("leaveService")
@Transactional
public class LeaveServiceImpl implements LeaveService {

	
	@Autowired private LeaveRepository leaveRepository;
	
	@Override
	public List<Leave> findAll() {
		
		return leaveRepository.findAll();
	}

	@Override
	public void create(Leave leave) {
		leaveRepository.create(leave);
		
	}

	@Override
	public void update(Leave leave) {
		leaveRepository.update(leave);
		
	}

	@Override
	public void delete(Leave leave) {
		leaveRepository.delete(leave);
		
	}

	@Override
	public Leave findById(Integer id) {
		
		return leaveRepository.find(id);
	}

	/*@Override
	public List<Leave> findByCriteria(Leave leave) {
		
		return leaveRepository.findByCriteria(leave);
	}
*/
	@Override
	public void deleteById(Integer id) {
		 leaveRepository.deleteById(id);
	}

	/*@Override
	public List<Leave> findLeaveType(Integer idLeave,Integer idEmp) {
		// TODO Auto-generated method stub
		return leaveRepository.findLeaveType(idLeave,idEmp);
	}*/

	
}
