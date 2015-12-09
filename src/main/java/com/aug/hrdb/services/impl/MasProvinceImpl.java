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

import com.aug.hrdb.entities.MasProvince;
import com.aug.hrdb.repositories.MasProvinceRepository;
import com.aug.hrdb.services.MasProvinceService;

@Service(value="masProvinceService")
@Transactional
public class MasProvinceImpl implements MasProvinceService {

	@Autowired
	private MasProvinceRepository masProvinceRepository;
	
	@Override
	public void create(MasProvince masProvince) {
		masProvinceRepository.create(masProvince);
	}

	@Override
	public void update(MasProvince masProvince) {
		masProvinceRepository.update(masProvince);
	}

	@Override
	public void delete(MasProvince masProvince) {
		masProvinceRepository.delete(masProvince);
	}

	@Override
	public MasProvince findById(Integer Id) {
		return masProvinceRepository.find(Id);
	}

	@Override
	public List<MasProvince> findAll() {
		return masProvinceRepository.findAll();
	}

	@Override
	public void deleteById(Integer id) {
		masProvinceRepository.deleteById(id);
	}

}