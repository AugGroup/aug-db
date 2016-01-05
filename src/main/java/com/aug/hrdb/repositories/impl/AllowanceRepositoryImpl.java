/**
 * @author Preeyaporn
 * @date 3 มิ.ย. 2558
 */
package com.aug.hrdb.repositories.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.aug.hrdb.dto.AllowanceDto;
import com.aug.hrdb.entities.Allowance;
import com.aug.hrdb.repositories.AllowanceRepository;

@Repository(value = "allowanceRepository")
public class AllowanceRepositoryImpl extends GenericRepositoryImpl<Allowance, Integer> implements AllowanceRepository {

  public AllowanceRepositoryImpl() {
    super(Allowance.class);
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<AllowanceDto> searchAllowances(Integer id) {
    Query namedQuery = getCurrentSession().getNamedQuery("searchAllowances").setInteger("empId", id);
    List<AllowanceDto> allowancesDtos = namedQuery.list();

    return allowancesDtos;

  }

}
