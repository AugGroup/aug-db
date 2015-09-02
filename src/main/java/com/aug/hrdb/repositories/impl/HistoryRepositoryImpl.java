/**
 *
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

@Repository
public class HistoryRepositoryImpl extends GenericRepositoryImpl<History, Integer> implements HistoryRepository{

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

	@Override
	public History deleteById(Integer id) {
		History history =(History)getCurrentSession().load(History.class, id);
		getCurrentSession().delete(history);
		return history;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistoryDto> searchHistory(Integer id) {

		Query namedQuery = getCurrentSession().getNamedQuery("searchHistory").setInteger("empId" ,id);
		//namedQuery.executeUpdate();
		List<HistoryDto> hisDto = namedQuery.list();
	     return hisDto;
	}

}
