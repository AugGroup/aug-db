/**
 * @author Preeyaporn
 * @date 13 พ.ค. 2558
 */
package com.aug.hrdb.repositories.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.aug.hrdb.dto.HistoryDto;
import com.aug.hrdb.entities.History;
import com.aug.hrdb.repositories.HistoryRepository;
import com.mysql.jdbc.StringUtils;

@Repository(value = "historyRepository")
public class HistoryRepositoryImpl extends GenericRepositoryImpl<History, Integer> implements HistoryRepository {

  public HistoryRepositoryImpl() {
    super(History.class);
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<History> findByCriteria(History history) {
    Criteria c = getCurrentSession().createCriteria(History.class);
    if (!StringUtils.isNullOrEmpty(history.getPosition())) {
      c.add(Restrictions.like("position", "%" + history.getPosition() + "%"));
    }

    return c.list();

  }

  @SuppressWarnings("unchecked")
  @Override
  public List<HistoryDto> searchHistory(Integer id) {
    Query namedQuery = getCurrentSession().getNamedQuery("searchHistory").setInteger("empId", id);
    List<HistoryDto> hisDto = namedQuery.list();

    return hisDto;

  }

}