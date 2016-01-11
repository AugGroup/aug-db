/**
 * @author Pranrajit
 * @date 25 พ.ค. 2558
 */
package com.aug.hrdb.repositories.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.aug.hrdb.dto.LeaveDto;
import com.aug.hrdb.dto.ReportLeaveDto;
import com.aug.hrdb.entities.Leave;
import com.aug.hrdb.repositories.LeaveRepository;

@SuppressWarnings("unchecked")
@Repository(value = "leaveRepository")
public class LeaveRepositoryImpl extends GenericRepositoryImpl<Leave, Integer> implements LeaveRepository {

  public LeaveRepositoryImpl() {
    super(Leave.class);
  }

  @Override
  public List<LeaveDto> searchLeave(Integer id) {
    Query query = getCurrentSession().getNamedQuery("searchLeave").setInteger("empId", id);

    return query.list();

  }

  @Override
  public List<ReportLeaveDto> reportLeave(String searchText) {
    Query query = getCurrentSession().getNamedQuery("reportLeave").setString("name", "%" + searchText + "%");

    return query.list();

  }

  @Override
  public List<Leave> findLeaveType(Integer idLeave, Integer idEmp) {
    Criteria c = getCurrentSession().createCriteria(Leave.class, "leave");
    c.setFetchMode("employee", FetchMode.JOIN);
    c.createAlias("employee", "employee");
    c.add(Restrictions.eq("employee.id", idEmp));
    c.add(Restrictions.eq("leave.masleavetype.id", idLeave));

    return c.list();

  }

}