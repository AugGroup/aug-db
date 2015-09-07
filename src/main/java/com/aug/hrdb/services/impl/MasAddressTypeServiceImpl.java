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

import com.aug.hrdb.entities.MasAddressType;
import com.aug.hrdb.repositories.MasAddressTypeRepository;
import com.aug.hrdb.services.MasAddressTypeService;


@Service("masAddressTypeService")
@Transactional
public class MasAddressTypeServiceImpl implements MasAddressTypeService{
	
	@Autowired
	private MasAddressTypeRepository masAddressTypeResp;

	@Override
	public void create(MasAddressType masAddressType) {
		masAddressTypeResp.create(masAddressType);
		
	}

	@Override
	public void update(MasAddressType masAddressType) {
		masAddressTypeResp.update(masAddressType);
	}

	@Override
	public void delete(MasAddressType masAddressType) {
		masAddressTypeResp.delete(masAddressType);
		
	}


	@Override
	public List<MasAddressType> findAll() {
		return masAddressTypeResp.findAll();
	}

	@Override
	public MasAddressType findById(Integer Id) {
		return masAddressTypeResp.find(Id);
	}

	@Override
	public List<MasAddressType> findByCriteria(MasAddressType masAddressType) {
		return masAddressTypeResp.findByCriteria(masAddressType);
	}

	@Override
	public void deleteById(Integer id) {
		 masAddressTypeResp.deleteById(id);
	}
	

}
