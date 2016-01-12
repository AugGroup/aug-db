package com.aug.hrdb.repositories.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.aug.hrdb.dto.ProbationDto;
import com.aug.hrdb.entities.Probation;
import com.aug.hrdb.repositories.ProbationRepository;

@SuppressWarnings("unchecked")
@Repository(value = "probationRepository")
public class ProbationRepositoryImpl extends GenericRepositoryImpl<Probation, Integer> implements ProbationRepository {

  public ProbationRepositoryImpl() {
    super(Probation.class);
  }

  @Override
  public List<ProbationDto> searchProbation(Integer id) {
    Query query = getCurrentSession().getNamedQuery("searchProbation").setInteger("empId", id);

    return query.list();

  }

}