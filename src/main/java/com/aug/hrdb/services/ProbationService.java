package com.aug.hrdb.services;

import java.util.List;

import com.aug.hrdb.dto.ProbationDto;
import org.springframework.dao.DataAccessException;

import com.aug.hrdb.entities.Probation;

public interface ProbationService {

  List<Probation> findAll() throws DataAccessException;

  Probation find(Integer id);

  void create(Probation probation);

  void update(Probation probation);

  void delete(Probation probation);

  void deleteById(Integer id);

  List<ProbationDto> searchProbation(Integer id);

}