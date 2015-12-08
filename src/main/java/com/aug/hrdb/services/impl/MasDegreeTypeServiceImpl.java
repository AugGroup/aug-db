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

import com.aug.hrdb.entities.MasDegreeType;
import com.aug.hrdb.repositories.MasDegreeTypeRepository;
import com.aug.hrdb.services.MasDegreeTypeService;

@Service("masDegreeTypeService")
@Transactional
public class MasDegreeTypeServiceImpl implements MasDegreeTypeService {

	@Autowired
	private MasDegreeTypeRepository masDegreeTypeRepository;
	
	@Override
	public void create(MasDegreeType masDegreeType) {
		masDegreeTypeRepository.create(masDegreeType);
	}

	@Override
	public void update(MasDegreeType masDegreeType) {
		masDegreeTypeRepository.update(masDegreeType);
	}

	@Override
	public void delete(MasDegreeType masDegreeType) {
		masDegreeTypeRepository.delete(masDegreeType);
	}

	@Override
	public MasDegreeType findById(Integer id) {
		return masDegreeTypeRepository.find(id);
	}

	@Override
	public List<MasDegreeType> findAll() {
		return masDegreeTypeRepository.findAll();
	}

	@Override
	public List<MasDegreeType> findByCriteria(MasDegreeType masDegreeType) {
		return masDegreeTypeRepository.findByCriteria(masDegreeType);
	}

	@Override
	public void deleteById(Integer id) {
		 masDegreeTypeRepository.deleteById(id);
	}

}
