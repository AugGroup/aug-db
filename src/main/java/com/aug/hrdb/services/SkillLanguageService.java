package com.aug.hrdb.services;

import java.util.List;

import com.aug.hr.entity.SkillLanguage;
import com.aug.hr.entity.dto.SkillLanguageDto;

public interface SkillLanguageService {

	public void create(SkillLanguage skillLanguage);
	public void update(SkillLanguage skillLanguage);
	public void delete(SkillLanguage skillLanguage);
	public SkillLanguage find(Integer Id);
	public List<SkillLanguage> findAll();
	
	public List<SkillLanguage> findAllByEmployee(Integer IdEmployee);	
	public void saveByFindEmployee(Integer employeeId,SkillLanguageDto skillLanguage);
	public SkillLanguageDto findSkillLanguageById(Integer id);
    public SkillLanguage findJoinMasSkillLanguage(Integer id);
	public void updateSetSkillLanguage(SkillLanguageDto skillLanguage);
	
}
