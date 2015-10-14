/**
 *
 * @author natechanok
 * @date Apr 27, 2015
 */

package com.aug.hrdb.repositories.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.aug.hrdb.dto.AimEmployeeDto;
import com.aug.hrdb.dto.EducationDto;
import com.aug.hrdb.dto.EmployeeCodeDto;
import com.aug.hrdb.dto.EmployeeDto;
import com.aug.hrdb.dto.EmployeeIdDto;
import com.aug.hrdb.dto.EmployeeListDto;
import com.aug.hrdb.dto.ReportEmployeeDto;
import com.aug.hrdb.dto.ReportLeaveDto;
import com.aug.hrdb.dto.ReportStatusEmployeeDto;
import com.aug.hrdb.entities.Employee;
import com.aug.hrdb.repositories.EmployeeRepository;
import com.mysql.jdbc.StringUtils;


@Repository
public class EmployeeRepositoryImpl extends GenericRepositoryImpl<Employee, Integer> implements EmployeeRepository{

	public EmployeeRepositoryImpl() {
		super(Employee.class);
	}

	
	@SuppressWarnings("unchecked")
	public List<Employee> findByCriteria(Employee employee) {
		
		Criteria c = getCurrentSession().createCriteria(Employee.class);
		c.setFetchMode("applicant",FetchMode.JOIN);
		c.createAlias("applicant", "applicant");
		
		if (!StringUtils.isNullOrEmpty(employee.getApplicant().getFirstNameEN())) {			
			c.add(Restrictions.like("firstNameEN", "%" +employee.getApplicant().getFirstNameEN() + "%"));
		}
		return c.list();
		
	}

	
	/*public Employee deleteById(Integer id) {
		
		Employee employee =(Employee)getCurrentSession().load(Employee.class, id);
		getCurrentSession().delete(employee);
		return employee;
	}*/




	@SuppressWarnings("unchecked")
	public List<EmployeeListDto> searchEmployee() {
		Query namedQuery = getCurrentSession().getNamedQuery("searchEmployee");
		List<EmployeeListDto> empDto = namedQuery.list();
		return empDto;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<AimEmployeeDto> listEmployeeAim() {
		Query aimnamedQuery = getCurrentSession().getNamedQuery("listEmployeeAim");
		List<AimEmployeeDto> aimemp = aimnamedQuery.list();
		return aimemp;
	}


	
public Employee findOfficial(Integer id) {
		
		Criteria c = getCurrentSession().createCriteria(Employee.class,"employee");
		c.setFetchMode("official",FetchMode.JOIN);
		c.createAlias("official", "official");
		c.add(Restrictions.eq("employee.id", id));
		return (Employee) c.uniqueResult();
		
	}
	

	

	@Override
	public Employee searhEmpIdtoAddress() {
		Query query = getCurrentSession().getNamedQuery("searchIdEmptoAddress");
		List<Employee> employee = query.list();	
		return employee.get(0);
	}


	@Override
	public EmployeeCodeDto serchRunningNo(String code) {
		// TODO Auto-generated method stub
		Query query = getCurrentSession().getNamedQuery("runningNo").setString("location",code);
		List<EmployeeCodeDto> employeeCode = query.list();	
		return employeeCode.get(0);
	}


	@Override
	public List<ReportEmployeeDto> reportEmployee(String nameEng) {
		Query query = getCurrentSession().getNamedQuery("reportEmployee").setString("name","%"+ nameEng +"%");
		List<ReportEmployeeDto> employees = query.list();	
		return employees;
	}
	
	@Override
	public List<ReportEmployeeDto> reportEmployeeCode(String code) {
		Query query = getCurrentSession().getNamedQuery("reportEmployeeCode").setString("code","%"+ code +"%");
		List<ReportEmployeeDto> employees = query.list();	
		return employees;
	}

	
	@Override
	public List<ReportStatusEmployeeDto> reportStatusEmployee(String statusStaff) {
		
		Query query = getCurrentSession().getNamedQuery("reportStatusEmployee").setString("statusStaff","%"+ statusStaff +"%");
		List<ReportStatusEmployeeDto> employee = query.list();	
		return employee;
	}

	@Override
	public List<ReportLeaveDto> reportLeave(String nameEng) {
		Query query = getCurrentSession().getNamedQuery("reportLeave").setString("name","%"+ nameEng +"%");
				List<ReportLeaveDto> leaves = query.list();	
		return leaves;
	}
	
	@SuppressWarnings("unchecked")
	public List<ReportEmployeeDto> findByName(Employee employee) {
		
		Criteria c = getCurrentSession().createCriteria(ReportEmployeeDto.class);
		c.setFetchMode("applicant", FetchMode.JOIN);
		c.createAlias("applicant", "applicant");
		
		if (!StringUtils.isNullOrEmpty(employee.getApplicant().getFirstNameEN())) {
			c.add(Restrictions.like("firstNameEN", "%" +employee.getApplicant().getFirstNameEN() + "%"));
		}
		return c.list();
		
	}
	

	
	@SuppressWarnings("unchecked")
	public List<ReportStatusEmployeeDto> findByNameStatus(Employee employee) {
		
		Criteria c = getCurrentSession().createCriteria(ReportEmployeeDto.class);
		c.setFetchMode("applicant", FetchMode.JOIN);
		c.createAlias("applicant", "applicant");
		
		if (!StringUtils.isNullOrEmpty(employee.getApplicant().getFirstNameEN())) {
			c.add(Restrictions.like("firstNameEN", "%" +employee.getApplicant().getFirstNameEN() + "%"));
		}
		return c.list();
		
	}
	

	@Override
	public EmployeeIdDto findCurrentId() {
		// TODO Auto-generated method stub

		Query query = getCurrentSession().getNamedQuery("findCurrentId");
		return (EmployeeIdDto) query.list().get(0);
	}


	@Override
	public Employee findEmployeeAndOfficial(Integer id) {
		// TODO Auto-generated method stub
		Criteria c = getCurrentSession().createCriteria(Employee.class,"employee");
		c.setFetchMode("official", FetchMode.JOIN);
		c.createAlias("official", "official");
		c.add(Restrictions.eq("employee.id", id));				 
		return (Employee) c.uniqueResult();
	}



	@Override
	public List<Employee> findAimRelateWithEmployee(Integer id) {
		// TODO Auto-generated method stub
		Criteria c = getCurrentSession().createCriteria(Employee.class,"employee");
		c.setFetchMode("aimempid", FetchMode.JOIN)	;
		c.createAlias("aimempid", "aimempid");
		c.add(Restrictions.eq("aimempid.id", id));
		return c.list();
	}


	@Override
	public Employee findEmployeeCode(Integer locationId) {
		// TODO Auto-generated method stub
		Criteria c = getCurrentSession().createCriteria(Employee.class,"employee");
		c.add(Restrictions.eq("employee.masLocation.id",locationId));
		c.addOrder(Order.desc("employee.id"));
	    c.setMaxResults(1);
		return  (Employee) c.uniqueResult();
	}

	@Override
	public List<AimEmployeeDto> listEmployeeAimForUpdate(Integer id) {
		Query aimnamedQuery = getCurrentSession().getNamedQuery("listEmployeeAimUpdateEmployee").setInteger("empId", id);
		List<AimEmployeeDto> aimemp = aimnamedQuery.list();
		return aimemp;
	}


	@Override
	public List<EmployeeListDto> searchEmpForUniqueIdCard(Integer id, String idCard) {
		// TODO Auto-generated method stub
		Query query  =  getCurrentSession().getNamedQuery("searchEmpForUniqueIdCard");
		query.setInteger("empId", id);
		query.setString("idcard", idCard);
		return query.list();
	}

}
	
