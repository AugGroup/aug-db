/**
 *
 * @author Pranrajit
 * @date 25 พ.ค. 2558
 */
package com.aug.hrdb.repositories.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;





import com.aug.hrdb.dto.LeaveDto;
import com.aug.hrdb.dto.ReportLeaveDto;
import com.aug.hrdb.entities.Leave;
import com.aug.hrdb.repositories.LeaveRepository;
import com.mysql.jdbc.StringUtils;



@Repository
public class LeaveRepositoryImpl extends GenericRepositoryImpl<Leave, Integer> implements LeaveRepository{

	public LeaveRepositoryImpl() {
		super(Leave.class);
		
	}

	@SuppressWarnings("unchecked")
	public List<Leave> findByCriteria(Leave leave) {
		Criteria c = getCurrentSession().createCriteria(Leave.class);
		if (!StringUtils.isNullOrEmpty(leave.getName())) {
			c.add(Restrictions.like("name", "%" + leave.getName() + "%"));
		}
		return c.list();
	}

	

	@SuppressWarnings("unchecked")
	@Override
	public List<LeaveDto> searchLeave(Integer id) {
		Query namedQuery = getCurrentSession().getNamedQuery("searchLeave").setInteger("empId" ,id);
		//namedQuery.executeUpdate();
		List<LeaveDto> leaDto = namedQuery.list();
	     return leaDto;

	}

	@Override
	public List<ReportLeaveDto> reportLeave(String searchText) {
		Query query = getCurrentSession().getNamedQuery("reportLeave").setString("name","%"+ searchText +"%");
		List<ReportLeaveDto> leaves = query.list();	
return leaves;
	}

	/*@Override
	public List<Leave> findLeaveType(Integer idLeave,Integer idEmp) {
		Criteria c = getCurrentSession().createCriteria(Leave.class,"leave");
		c.setFetchMode("employee",FetchMode.JOIN);
		c.createAlias("employee", "employee");
		c.add(Restrictions.eq("employee.id", idEmp));
		c.add(Restrictions.eq("leave.masleavetype.id",idLeave));
		return c.list();
		
	}*/

	/*@Override
	public List<ReportLeaveDto> reportLeave(String nameEng) {
		Query query = getCurrentSession().getNamedQuery("reportLeave").setString("name","%"+ nameEng +"%");
		List<ReportLeaveDto> leaves = query.list();	
return leaves;
	}*/



	


}
