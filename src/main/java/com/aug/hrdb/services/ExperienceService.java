package com.aug.hrdb.services;

import java.util.List;

import com.aug.hrdb.dto.ExperienceDto;
import com.aug.hrdb.entities.Experience;

public interface ExperienceService {

  void create(Experience experience);

  Experience findById(Integer id);

  void update(Experience experience);

  void deleteById(Integer id);

  void delete(Experience experience);

  List<Experience> findAll();

  List<ExperienceDto> findExperienceById(Integer id);

  ExperienceDto findExperience(Integer id);

  List<ExperienceDto> searchExperience(Integer id);

}