package com.aug.hrdb.repositories.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.aug.hrdb.dto.SiteDto;
import com.aug.hrdb.entities.Site;
import com.aug.hrdb.repositories.SiteRepository;

@SuppressWarnings("unchecked")
@Repository(value = "siteRepository")
public class SiteRepositoryImpl extends GenericRepositoryImpl<Site, Integer> implements SiteRepository {

  public SiteRepositoryImpl() {
    super(Site.class);
  }

  @Override
  public List<SiteDto> listByNameNativeQuery(Integer id) {
    Query query = getCurrentSession().getNamedQuery("listSite").setInteger("empId", id);

    return query.list();

  }

}