/**
 *
 * @author Pranrajit
 * @date 29 เม.ย. 2558
 */
package com.aug.hrdb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.MasDegreetype;
import com.aug.hrdb.repositories.MasDegreetypeRepository;
import com.aug.hrdb.services.MasDegreetypeService;


@Service("masDegreetypeService")
@Transactional
public class MasDegreetypeServiceImpl implements MasDegreetypeService{

	@Autowired
	private MasDegreetypeRepository masDegreetypeRepository;
	
	@Override
	public void create(MasDegreetype masDegreetype) {
		masDegreetypeRepository.create(masDegreetype);
		
	}

	@Override
	public void update(MasDegreetype masDegreetype) {
		masDegreetypeRepository.update(masDegreetype);
	}

	@Override
	public void delete(MasDegreetype masDegreetype) {
		masDegreetypeRepository.delete(masDegreetype);
		
	}

	@Override
	public MasDegreetype find(Integer id) {
		
		return masDegreetypeRepository.find(id);
	}

	@Override
	public List<MasDegreetype> findAll() {
		
		return masDegreetypeRepository.findAll();
	}

	@Override
	public List<MasDegreetype> findByCriteria(MasDegreetype masDegreetype) {
		// TODO Auto-generated method stub
		return masDegreetypeRepository.findByCriteria(masDegreetype);
	}

	@Override

	public MasDegreetype deleteById(Integer id) {
	return	 masDegreetypeRepository.deleteById(id);
		

	}


	

}
