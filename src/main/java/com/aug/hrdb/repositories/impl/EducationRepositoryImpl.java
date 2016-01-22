package com.aug.hrdb.repositories.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.aug.hrdb.dto.EducationDto;
import com.aug.hrdb.entities.Education;
import com.aug.hrdb.repositories.EducationRepository;

@SuppressWarnings("unchecked")
@Repository(value = "educationRepository")
public class EducationRepositoryImpl extends GenericRepositoryImpl<Education, Serializable> implements EducationRepository {

  public EducationRepositoryImpl() {
    super(Education.class);
  }

  @Override
  public List<EducationDto> findEducationById(Integer id) {
    Query query = getCurrentSession().getNamedQuery("SEARCH_EDUCATION");
    query.setParameter("ID", id);
    List<EducationDto> result = query.list();

    return result;

  }

  @Override
  public EducationDto findByEducationId(Integer id) {
    Query query = getCurrentSession().getNamedQuery("SEARCH_EDUCATION_ID");
    query.setParameter("ID", id);
    List<EducationDto> result = query.list();
    EducationDto app = result.get(0);

    return app;

  }

  @Override
  public List<EducationDto> searchEducation(Integer id) {
    Query namedQuery = getCurrentSession().getNamedQuery("SEARCH_EDUCATION").setInteger("ID", id);
    List<EducationDto> edDto = namedQuery.list();

    return edDto;

  }

}