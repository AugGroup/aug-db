/**
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
import com.aug.hrdb.entities.Applicant;
import com.aug.hrdb.entities.Official;
import com.aug.hrdb.repositories.OfficialRepository;
import com.mysql.jdbc.StringUtils;

@SuppressWarnings("unchecked")
@Repository(value = "officialRepository")
public class OfficialRepositoryImpl extends GenericRepositoryImpl<Official, Integer> implements OfficialRepository {

  public OfficialRepositoryImpl() {
    super(Official.class);
  }

  public List<Official> findByCriteria(Applicant applicant) {
    Criteria c = getCurrentSession().createCriteria(Official.class);
    c.setFetchMode("applicant", FetchMode.JOIN);
    c.createAlias("applicant", "applicant");

    if (!StringUtils.isNullOrEmpty(applicant.getEmployedPosition())) {
      c.add(Restrictions.like("applicant.employedPosition", "%" + applicant.getEmployedPosition() + "%"));
    }

    return c.list();

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
    query.setInteger("EMPLOYEE_ID", officialDto.getEmployeeId());
    query.executeUpdate();

  }

  @Override
  public Official searchEmpIdToOfficial() {
    Query query = getCurrentSession().getNamedQuery("searchIdEmpToOfficial");
    List<Official> official = query.list();

    return official.get(0);

  }

  @Override
  public void updateOfficialByNameQuery(OfficialDto officialDto) {
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

}