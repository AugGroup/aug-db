/**
 *
 * @author natechanok
 * @date Apr 29, 2015
 */

package com.aug.hrdb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.MasEmployment;
import com.aug.hrdb.repositories.MasEmploymentRepository;
import com.aug.hrdb.services.MasEmploymentService;


@Service("masEmploymentService")
@Transactional
public class MasEmploymentServiceImpl implements MasEmploymentService{

	@Autowired
	private MasEmploymentRepository masEmploymentResp;
	
	@Override
	public void create(MasEmployment masEmployment) {
		masEmploymentResp.create(masEmployment);
		
	}

	@Override
	public void update(MasEmployment masEmployment) {
		masEmploymentResp.update(masEmployment);
		
	}

	@Override
	public void delete(MasEmployment masEmployment) {
		masEmploymentResp.delete(masEmployment);
		
	}

	@Override
	public List<MasEmployment> findAll() {
		return masEmploymentResp.findAll();
	}

	@Override
	public MasEmployment findById(Integer Id) {
		return masEmploymentResp.find(Id);
	}

	@Override
	public List<MasEmployment> findByCriteria(MasEmployment masEmployment) {
		return masEmploymentResp.findByCriteria(masEmployment);
	}

	@Override
	public MasEmployment deleteById(Integer id) {
		return masEmploymentResp.deleteById(id);
	}
	
	

}
