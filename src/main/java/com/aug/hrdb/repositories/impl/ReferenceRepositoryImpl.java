package com.aug.hrdb.repositories.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.aug.hrdb.dto.ReferenceDto;
import com.aug.hrdb.entities.Reference;
import com.aug.hrdb.repositories.ReferenceRepository;
import com.mysql.jdbc.StringUtils;

@SuppressWarnings("unchecked")
@Repository(value = "referenceRepository")
public class ReferenceRepositoryImpl extends GenericRepositoryImpl<Reference, Integer> implements ReferenceRepository {

  public ReferenceRepositoryImpl() {
    super(Reference.class);
  }

  @Override
  public List<Reference> findByCriteria(Reference reference) {

    Criteria c = getCurrentSession().createCriteria(Reference.class);
    if (!StringUtils.isNullOrEmpty(reference.getName())) {
      c.add(Restrictions.like("name", "%" + reference.getName() + "%"));
    }

    return c.list();

  }

  @Override
  public List<ReferenceDto> searchReference(Integer id) {
    Query query = getCurrentSession().getNamedQuery("searchReference").setInteger("empId", id);

    return (List<ReferenceDto>) query.list();

  }

  @Override
  public List<ReferenceDto> findReferenceById(Integer id) {
    Query query = getCurrentSession().getNamedQuery("SEARCH_REFERENCE");
    query.setParameter("ID", id);

    return (List<ReferenceDto>) query.list();

  }

  @Override
  public ReferenceDto findReference(Integer id) {
    Query query = getCurrentSession().getNamedQuery("SEARCH_REFERENCE_ID");
    query.setParameter("ID", id);

    return (ReferenceDto) query.list().get(0);

  }

}