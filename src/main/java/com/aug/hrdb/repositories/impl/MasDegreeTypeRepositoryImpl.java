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

import com.aug.hrdb.entities.MasDegreeType;
import com.aug.hrdb.repositories.MasDegreeTypeRepository;
import com.mysql.jdbc.StringUtils;

@Repository(value="masDegreeTypeRepository")
public class MasDegreeTypeRepositoryImpl extends GenericRepositoryImpl<MasDegreeType,Integer> implements MasDegreeTypeRepository {

	public MasDegreeTypeRepositoryImpl() {
		super(MasDegreeType.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MasDegreeType> findByCriteria(MasDegreeType masDegreeType) {
		
		Criteria c = getCurrentSession().createCriteria(MasDegreeType.class);
		
		if (!StringUtils.isNullOrEmpty(masDegreeType.getName())) {
			c.add(Restrictions.like("name", "%" + masDegreeType.getName() + "%"));
		}
		
		return c.list();
		
	}

}
