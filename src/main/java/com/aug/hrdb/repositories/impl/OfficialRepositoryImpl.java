/**
 *
 * @author natechanok
 * @date Apr 30, 2015
 */

package com.aug.hrdb.repositories.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.aug.hrdb.dto.OfficialDto;
import com.aug.hrdb.entities.Official;
import com.aug.hrdb.repositories.OfficialRepository;
import com.mysql.jdbc.StringUtils;
@Repository
public class OfficialRepositoryImpl extends GenericRepositoryImpl<Official, Integer> implements OfficialRepository{

	public OfficialRepositoryImpl() {
		super(Official.class);
		// TODO Auto-generated constructor stub
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<Official> findByCriteria(Official official){
		
		Criteria c = getCurrentSession().createCriteria(Official.class);
		if (!StringUtils.isNullOrEmpty(official.getPositionAppliedFor())) {
			c.add(Restrictions.like("name", "%" + official.getPositionAppliedFor() + "%"));
		}
		return c.list();
		
	}
	
	public Official deleteById(Integer id){
		
		Official official =(Official)getCurrentSession().load(Official.class, id);
		getCurrentSession().delete(official);
		return official;
	}


	@Override
	public void saveOfficialByNameQuery(OfficialDto officialDto) {
		
		Query query = getCurrentSession().getNamedQuery("insertOfficial");
		query.setDate("OFFICIAL_DATE", officialDto.getOfficialDate());
		query.setDate("START_WORK_DATE", officialDto.getStartWorkDate());
		query.setDate("END_WORK_DATE", officialDto.getEndWorkDate());
		query.setString("POSITION_APPLIED_FOR", officialDto.getPositionAppliedFor());
		query.setString("SALARY_EXPECTED", officialDto.getSalaryExpected());
		query.setDate("PROBATION_DATE", officialDto.getProbationDate());
		//query.setInteger("EMPLOYEE_ID", officialDto.getEmployeeId());
		
		query.executeUpdate();
		
		
	}



	@SuppressWarnings("unchecked")
	public List<OfficialDto> searchOfficial() {
		Query namedQuery = getCurrentSession().getNamedQuery("searchOfficial");
		List<OfficialDto> offDto = namedQuery.list();
		return offDto;
	}



	@Override
	public Official searhEmpIdtoOfficial() {
		Query query = getCurrentSession().getNamedQuery("searchIdEmptoOfficial");
		List<Official> official = query.list();
		return official.get(0);
	}



	@Override
	public void updateOfficialByNameQuery(OfficialDto officialDto) {
		// TODO Auto-generated method stub

		Query query = getCurrentSession().getNamedQuery("updateOfficial");
		query.setDate("OFFICIAL_DATE", officialDto.getOfficialDate());
		query.setDate("START_WORK_DATE", officialDto.getStartWorkDate());
		query.setDate("END_WORK_DATE", officialDto.getEndWorkDate());
		query.setString("POSITION_APPLIED_FOR", officialDto.getPositionAppliedFor());
		query.setString("SALARY_EXPECTED", officialDto.getSalaryExpected());
		query.setDate("PROBATION_DATE", officialDto.getProbationDate());
		query.setInteger("updatedBy", officialDto.getEmployeeId());
		query.setInteger("ID", officialDto.getId());
		
		query.executeUpdate();
		
		
	}



	@Override
	public void deleteOfficialByNameQuery(Official official) {
		// TODO Auto-generated method stub
		Query query = getCurrentSession().getNamedQuery("deleteOfficial");
		query.setInteger("id", official.getId());
		query.executeUpdate();
	}





}
