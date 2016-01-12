package com.aug.hrdb.repositories.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.aug.hrdb.dto.PunishDto;
import com.aug.hrdb.entities.Punish;
import com.aug.hrdb.repositories.PunishRepository;
import com.mysql.jdbc.StringUtils;

@SuppressWarnings("unchecked")
@Repository(value = "punishRepository")
public class PunishRepositoryImpl extends GenericRepositoryImpl<Punish, Integer> implements PunishRepository {


  public PunishRepositoryImpl() {
    super(Punish.class);
  }


  @Override
  public List<Punish> findByCriteria(Punish punish) {
    Criteria c = getCurrentSession().createCriteria(Punish.class);

    if (!StringUtils.isNullOrEmpty(punish.getDescription())) {
      c.add(Restrictions.like("description", "%" + punish.getDescription() + "%"));
    }

    return c.list();

  }

  @Override
  public List<PunishDto> searchPunish(Integer id) {
    Query query = getCurrentSession().getNamedQuery("searchPunish").setInteger("empId", id);

    return query.list();

  }

}