package com.aug.hrdb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.aug.hrdb.entities.Reference;
import com.aug.hrdb.repositories.ReferenceRepository;
import com.aug.hrdb.services.ReferenceService;

@Service("referenceService")
@Transactional
public class ReferenceServiceImpl implements ReferenceService{

	@Autowired
	private ReferenceRepository referenceRepository;
	
	@Override
	public void create(Reference reference) {
		referenceRepository.create(reference);

	}

	@Override
	public void update(Reference reference) {
		referenceRepository.update(reference);

	}

	@Override
	public void delete(Reference reference) {
		referenceRepository.delete(reference);

	}

	@Override
	public Reference findById(Integer id) {
		return referenceRepository.find(id);
	}

	@Override
	public List<Reference> findAll() {
		return referenceRepository.findAll();
	}

	@Override
	public List<Reference> findByCriteria(Reference reference) {
		return referenceRepository.findByCriteria(reference);
	}

	@Override
	public Reference deleteById(Integer id) {
		return referenceRepository.deleteById(id);

	}
}
