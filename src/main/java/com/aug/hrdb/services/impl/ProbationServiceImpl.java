package com.aug.hrdb.services.impl;

import java.util.List;

import com.aug.hrdb.dto.ProbationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.aug.hrdb.entities.Probation;
import com.aug.hrdb.repositories.ProbationRepository;
import com.aug.hrdb.services.ProbationService;

@Transactional
@Service(value = "probationService")
public class ProbationServiceImpl implements ProbationService {

  @Autowired
  private ProbationRepository probationRepository;

  @Override
  public List<Probation> findAll() throws DataAccessException {
    return probationRepository.findAll();
  }

  @Override
  public Probation find(Integer id) {
    return probationRepository.find(id);
  }

  @Override
  public void create(Probation probation) {
    probationRepository.create(probation);
  }

  @Override
  public void update(Probation probation) {
    probationRepository.update(probation);
  }

  @Override
  public void delete(Probation probation) {
    probationRepository.delete(probation);
  }

  @Override
  public void deleteById(Integer id) {
    probationRepository.deleteById(id);
  }

  @Override
  public List<ProbationDto> searchProbation(Integer id) {
    return probationRepository.searchProbation(id);
  }

}