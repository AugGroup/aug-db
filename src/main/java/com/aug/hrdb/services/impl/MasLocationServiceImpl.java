/**
 *
 * @author Pranrajit
 * @date 13 พ.ค. 2558
 */
package com.aug.hrdb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.MasLocation;
import com.aug.hrdb.repositories.MasLocationRepository;
import com.aug.hrdb.services.MasLocationService;



@Service("masLocationService")
@Transactional
public class MasLocationServiceImpl implements MasLocationService{

	@Autowired
	private MasLocationRepository masLocationRepository;
	
	@Override
	public void create(MasLocation masLocation) {
		masLocationRepository.create(masLocation);
		
	}

	@Override
	public void update(MasLocation masLocation) {
		masLocationRepository.update(masLocation);
		
	}

	@Override
	public void delete(MasLocation masLocation) {
		masLocationRepository.delete(masLocation);
		
	}

	@Override
	public MasLocation find(Integer id) {
		
		return masLocationRepository.find(id);
	}

	@Override
	public List<MasLocation> findAll() {
		
		return masLocationRepository.findAll();
	}

	@Override
	public List<MasLocation> findByCriteria(MasLocation masLocation) {
		
		return masLocationRepository.findByCriteria(masLocation);
	}

	@Override
	public MasLocation deleteById(Integer id) {
		
		return masLocationRepository.deleteById(id);
	}

	@Override
	public MasLocation findByLocationCode(String locationCode) {
		
		return masLocationRepository.findByLocationCode(locationCode);
	}

}
