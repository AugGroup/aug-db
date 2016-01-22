/**
 * @author natechanok
 * @date Apr 27, 2015
 */

package com.aug.hrdb.repositories.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.aug.hrdb.dto.AimEmployeeDto;
import com.aug.hrdb.dto.DivisionDto;
import com.aug.hrdb.dto.EmployeeCodeDto;
import com.aug.hrdb.dto.EmployeeIdDto;
import com.aug.hrdb.dto.EmployeeListDto;
import com.aug.hrdb.dto.JoblevelDto;
import com.aug.hrdb.dto.ReportEmployeeDto;
import com.aug.hrdb.dto.ReportLeaveDto;
import com.aug.hrdb.dto.ReportStatusEmployeeDto;
import com.aug.hrdb.entities.Employee;
import com.aug.hrdb.repositories.EmployeeRepository;
import com.mysql.jdbc.StringUtils;

@SuppressWarnings("unchecked")
@Repository(value = "employeeRepository")
public class EmployeeRepositoryImpl extends GenericRepositoryImpl<Employee, Integer> implements EmployeeRepository {

  public EmployeeRepositoryImpl() {
    super(Employee.class);
  }

  public List<Employee> findByCriteria(Employee employee) {

    Criteria c = getCurrentSession().createCriteria(Employee.class);
    c.setFetchMode("applicant", FetchMode.JOIN);
    c.createAlias("applicant", "applicant");

    if (!StringUtils.isNullOrEmpty(employee.getApplicant().getFirstNameEN())) {
      c.add(Restrictions.like("applicant.firstNameEN", "%" + employee.getApplicant().getFirstNameEN() + "%"));
    }

    return c.list();

  }

  public List<EmployeeListDto> searchEmployee() {
    Query query = getCurrentSession().getNamedQuery("searchEmployee");
    List<EmployeeListDto> employeeListDtoList = query.list();

    return employeeListDtoList;

  }

  @Override
  public List<AimEmployeeDto> listEmployeeAim() {
    Query query = getCurrentSession().getNamedQuery("listEmployeeAim");
    List<AimEmployeeDto> aimEmployeeDtoList = query.list();

    return aimEmployeeDtoList;

  }

  @Override
  public Employee searchEmpIdToAddress() {
    Query query = getCurrentSession().getNamedQuery("searchIdEmptoAddress");
    List<Employee> employee = query.list();

    return employee.get(0);

  }

  @Override
  public List<ReportEmployeeDto> reportEmployee(String nameEng) {
    Query query = getCurrentSession().getNamedQuery("reportEmployee").setString("name", "%" + nameEng + "%");
    List<ReportEmployeeDto> employees = query.list();

    return employees;

  }

  @Override
  public List<ReportStatusEmployeeDto> reportStatusEmployee(String statusStaff) {
    Query query = getCurrentSession().getNamedQuery("reportStatusEmployee").setString("statusStaff", "%" + statusStaff + "%");
    List<ReportStatusEmployeeDto> employee = query.list();

    return employee;

  }

  @Override
  public List<ReportLeaveDto> reportLeave(String nameEng) {
    Query query = getCurrentSession().getNamedQuery("reportLeave").setString("name", "%" + nameEng + "%");
    List<ReportLeaveDto> leaves = query.list();

    return leaves;

  }

  @Override
  public EmployeeIdDto findCurrentId() {
    Query query = getCurrentSession().getNamedQuery("findCurrentId");

    return (EmployeeIdDto) query.list().get(0);

  }

  @Override
  public Employee findEmployeeAndOfficial(Integer id) {
    Criteria c = getCurrentSession().createCriteria(Employee.class, "employee");
    c.setFetchMode("official", FetchMode.JOIN);
    c.createAlias("official", "official");
    c.add(Restrictions.eq("employee.id", id));

    return (Employee) c.uniqueResult();

  }

  @Override
  public List<Employee> findAimRelateWithEmployee(Integer id) {
    Criteria c = getCurrentSession().createCriteria(Employee.class, "employee");
    c.setFetchMode("aimEmpId", FetchMode.JOIN);
    c.createAlias("aimEmpId", "aimEmpId");
    c.add(Restrictions.eq("aimEmpId.id", id));

    return c.list();

  }

  public List<ReportEmployeeDto> findByName(Employee employee) {
    Query query = getCurrentSession().getNamedQuery("reportEmployee");
    query.setString("name", "%" + employee.getApplicant().getFirstNameEN() + "%");

    return query.list();

  }

  public List<ReportStatusEmployeeDto> findByNameStatus(Employee employee) {

    Criteria c = getCurrentSession().createCriteria(ReportStatusEmployeeDto.class);
    c.setFetchMode("applicant", FetchMode.JOIN);
    c.createAlias("applicant", "applicant");

    if (!StringUtils.isNullOrEmpty(employee.getApplicant().getFirstNameEN())) {
      c.add(Restrictions.like("firstNameEN", "%" + employee.getApplicant().getFirstNameEN() + "%"));
    }

    return c.list();

  }

  @Override
  public List<ReportEmployeeDto> reportEmployeeCode(String code) {
    Query query = getCurrentSession().getNamedQuery("reportEmployeeCode").setString("code", "%" + code + "%");
    List<ReportEmployeeDto> employees = query.list();

    return employees;

  }

  @Override
  public List<AimEmployeeDto> listEmployeeAimForUpdate(Integer id) {
    Query query = getCurrentSession().getNamedQuery("listEmployeeAimUpdateEmployee").setInteger("empId", id);
    List<AimEmployeeDto> aimEmp = query.list();

    return aimEmp;

  }

  @Override
  public List<EmployeeListDto> searchEmpForUniqueIdCard(Integer id, String idCard) {
    Query query = getCurrentSession().getNamedQuery("searchEmpForUniqueIdCard");
    query.setInteger("empId", id);
    query.setString("idcard", idCard);

    return query.list();

  }

  @Override
  public List<EmployeeCodeDto> findEmployeeCode(Integer location_id) {
    Query query = getCurrentSession().getNamedQuery("findEmployeeCode");
    query.setInteger("location_id", location_id);

    return query.list();

  }

  @Override
  public List<DivisionDto> checkTag(String tag) {
    Query query = getCurrentSession().getNamedQuery("CHECK_DIVISION");
    query.setParameter("TAG", tag);
    List<DivisionDto> result = query.list();

    return result;

  }

  @Override
  public List<JoblevelDto> checkTagDivision(String tag) {
    Query query = getCurrentSession().getNamedQuery("CHECK_TAG_DIVISION");
    query.setParameter("TAG_DIVISION", tag);
    List<JoblevelDto> result = query.list();

    return result;

  }

  @Override
  public String findByIdDivision(Integer id) {
    Query query = getCurrentSession().getNamedQuery("FIND_BY_ID_DIVISION");
    query.setParameter("ID", id);
    List<DivisionDto> result = query.list();
    DivisionDto divisionDto = result.get(0);

    return divisionDto.getTag();

  }

}