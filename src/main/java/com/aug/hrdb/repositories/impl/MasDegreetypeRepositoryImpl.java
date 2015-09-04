/**
 *
 * @author Pranrajit
 * @date 27 เม.ย. 2558
 */
package com.aug.hrdb.repositories.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;





import com.aug.hrdb.entities.MasDegreetype;
import com.aug.hrdb.repositories.MasDegreetypeRepository;
import com.mysql.jdbc.StringUtils;


@Repository
public class MasDegreetypeRepositoryImpl extends GenericRepositoryImpl<MasDegreetype,Integer> implements MasDegreetypeRepository{

	public MasDegreetypeRepositoryImpl() {
		super(MasDegreetype.class);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MasDegreetype> findByCriteria(MasDegreetype masDegreetype) {
		Criteria c = getCurrentSession().createCriteria(MasDegreetype.class);
		if (!StringUtils.isNullOrEmpty(masDegreetype.getName())) {
			c.add(Restrictions.like("Name", "%" + masDegreetype.getName() + "%"));
		}
		return c.list();
	}

	@Override
	public MasDegreetype deleteById(Integer id) {
		MasDegreetype masDegreetype =(MasDegreetype)getCurrentSession().load(MasDegreetype.class, id);
		getCurrentSession().delete(masDegreetype);
		return masDegreetype;
	}

}
