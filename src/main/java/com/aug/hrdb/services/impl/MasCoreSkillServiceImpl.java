/**
 *
 * @author Pranrajit
 * @date 8 พ.ค. 2558
 */
package com.aug.hrdb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.MasCoreSkill;
import com.aug.hrdb.repositories.MasCoreSkillRepository;
import com.aug.hrdb.services.MasCoreSkillService;



@Service("masCoreSkillService")
@Transactional
public class MasCoreSkillServiceImpl implements MasCoreSkillService{

	
	
	@Autowired
	private MasCoreSkillRepository masCoreSkillRepository;
	
	@Override
	public void create(MasCoreSkill masCoreSkill) {
		masCoreSkillRepository.create(masCoreSkill);
		
	}
	
	@Override
	public void update(MasCoreSkill masCoreSkill) {
		masCoreSkillRepository.update(masCoreSkill);
		
	}

	@Override
	public void delete(MasCoreSkill masCoreSkill) {
		masCoreSkillRepository.delete(masCoreSkill);
	}

	@Override
	public MasCoreSkill find(Integer id) {
		// TODO Auto-generated method stub
		return masCoreSkillRepository.find(id);
	}

	@Override
	public List<MasCoreSkill> findAll() {
		// TODO Auto-generated method stub
		return masCoreSkillRepository.findAll();
	}

	@Override
	public List<MasCoreSkill> findByCriteria(MasCoreSkill masCoreSkill) {
		// TODO Auto-generated method stub
		return masCoreSkillRepository.findByCriteria(masCoreSkill);
	}

	@Override
	public void deleteById(Integer id) {
	
		masCoreSkillRepository.deleteById(id);
	}

}
