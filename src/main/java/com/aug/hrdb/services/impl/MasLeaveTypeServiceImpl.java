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

import com.aug.hrdb.entities.MasLeaveType;
import com.aug.hrdb.repositories.MasLeaveTypeRepository;
import com.aug.hrdb.services.MasLeaveTypeService;

@Service(value="masLeaveTypeService")
@Transactional
public class MasLeaveTypeServiceImpl implements MasLeaveTypeService{
	
	@Autowired 
	private MasLeaveTypeRepository masLeaveTypeRepository;
	
	@Override
	public void create(MasLeaveType masLeaveType) {
		masLeaveTypeRepository.create(masLeaveType);
	}

	@Override
	public void update(MasLeaveType masLeaveType) {
		masLeaveTypeRepository.update(masLeaveType);	
	}

	@Override
	public void delete(MasLeaveType masLeaveType) {
		masLeaveTypeRepository.delete(masLeaveType);
	}

	@Override
	public MasLeaveType findById(Integer id) {
		return masLeaveTypeRepository.find(id);
	}

	@Override
	public List<MasLeaveType> findAll() {
		return masLeaveTypeRepository.findAll();
	}

	@Override
	public List<MasLeaveType> findByCriteria(MasLeaveType masLeaveType) {
		return masLeaveTypeRepository.findByCriteria(masLeaveType);
	}

	@Override
	public void deleteById(Integer id) {
		 masLeaveTypeRepository.deleteById(id);
	}
	
}