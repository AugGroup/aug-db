/**
 *
 * @author Preeyaporn
 * @date 29 เม.ย. 2558
 */
package com.aug.hrdb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.MasDivision;
import com.aug.hrdb.repositories.MasDivisionRepository;
import com.aug.hrdb.services.MasDivisionService;

@Service("masDivisionService")
@Transactional
public class MasDivisionServiceImpl implements MasDivisionService {

	@Autowired
	private MasDivisionRepository masDivisionRepository;
	
	@Override
	public List<MasDivision> findAll() {
		return masDivisionRepository.findAll();
	}

	@Override
	public void create(MasDivision masDivision) {
		masDivisionRepository.create(masDivision);
	}

	@Override
	public void update(MasDivision masDivision) {
		masDivisionRepository.update(masDivision);
	}

	@Override
	public void delete(MasDivision masDivision) {
		masDivisionRepository.delete(masDivision);
	}

	@Override
	public MasDivision findById(Integer id) {
		return masDivisionRepository.find(id);
	}

	@Override
	public List<MasDivision> findByCriteria(MasDivision masDivision) {
		return null;
	}

	@Override
	public MasDivision deleteById(Integer id) {
		return null;
	}

	
}
