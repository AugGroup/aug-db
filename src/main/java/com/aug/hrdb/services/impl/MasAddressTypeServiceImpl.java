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

@Service(value="masAddressTypeService")
@Transactional
public class MasAddressTypeServiceImpl implements MasAddressTypeService{
	
	@Autowired
	private MasAddressTypeRepository masAddressTypeRepository;

	@Override
	public void create(MasAddressType masAddressType) {
		masAddressTypeRepository.create(masAddressType);
	}

	@Override
	public void update(MasAddressType masAddressType) {
		masAddressTypeRepository.update(masAddressType);
	}

	@Override
	public void delete(MasAddressType masAddressType) {
		masAddressTypeRepository.delete(masAddressType);
	}

	@Override
	public List<MasAddressType> findAll() {
		return masAddressTypeRepository.findAll();
	}

	@Override
	public MasAddressType findById(Integer Id) {
		return masAddressTypeRepository.find(Id);
	}

	@Override
	public List<MasAddressType> findByCriteria(MasAddressType masAddressType) {
		return masAddressTypeRepository.findByCriteria(masAddressType);
	}

	@Override
	public void deleteById(Integer id) {
		masAddressTypeRepository.deleteById(id);
	}
	
}
