package com.aug.hrdb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.dto.ExperienceDto;
import com.aug.hrdb.entities.Experience;
import com.aug.hrdb.repositories.ExperienceRepository;
import com.aug.hrdb.services.ExperienceService;

@Transactional
@Service(value = "experienceService")
public class ExperienceServiceImpl implements ExperienceService {

  @Autowired
  private ExperienceRepository experienceRepository;

  @Override
  public Experience findById(Integer id) {
    return experienceRepository.find(id);
  }

  @Override
  public void create(Experience experience) {
    experienceRepository.create(experience);
  }

  @Override
  public void update(Experience experience) {
    experienceRepository.update(experience);
  }

  @Override
  public void delete(Experience experience) {
    experienceRepository.delete(experience);
  }

  @Override
  public void deleteById(Integer id) {
    experienceRepository.deleteById(id);
  }

  @Override
  public List<Experience> findAll() {
    return experienceRepository.findAll();
  }

  @Override
  public List<ExperienceDto> findExperienceById(Integer id) {
    return experienceRepository.findExperienceById(id);
  }

  @Override
  public ExperienceDto findExperience(Integer id) {
    return experienceRepository.findExperience(id);
  }

  @Override
  public List<ExperienceDto> searchExperience(Integer id) {
    return experienceRepository.searchExperience(id);
  }

}