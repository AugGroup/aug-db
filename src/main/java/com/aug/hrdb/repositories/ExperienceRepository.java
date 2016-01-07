package com.aug.hrdb.repositories;

import java.io.Serializable;
import java.util.List;

import com.aug.hrdb.dto.ExperienceDto;
import com.aug.hrdb.entities.Experience;

public interface ExperienceRepository extends GenericRepository<Experience, Serializable> {

  List<ExperienceDto> findExperienceById(Integer id);

  ExperienceDto findExperience(Integer id);

  List<ExperienceDto> searchExperience(Integer id);

}