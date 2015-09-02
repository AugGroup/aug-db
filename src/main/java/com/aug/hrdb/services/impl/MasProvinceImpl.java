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
import com.aug.hrdb.repositories.MasProvinceRespository;
import com.aug.hrdb.services.MasProvinceService;

@Service("masProvinceService")
@Transactional
public class MasProvinceImpl implements MasProvinceService {

	@Autowired
	private MasProvinceRespository masProvinceResp;
	
	@Override
	public void create(MasProvince masProvince) {
		masProvinceResp.create(masProvince);
	}

	@Override
	public void update(MasProvince masProvince) {
		
		masProvinceResp.update(masProvince);
		
	}

	@Override
	public void delete(MasProvince masProvince) {
		
		masProvinceResp.delete(masProvince);
	}

	@Override
	public MasProvince find(Integer Id) {
		
		return masProvinceResp.find(Id);
	}

	@Override
	public List<MasProvince> findAll() {
		
		return masProvinceResp.findAll();
	}

	@Override
	public List<MasProvince> findByCriteria(MasProvince masProvince) {
		
		return null;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
