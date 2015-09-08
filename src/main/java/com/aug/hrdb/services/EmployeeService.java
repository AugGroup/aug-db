/**
 *
 * @author natechanok
 * @date Apr 27, 2015
 */

package com.aug.hrdb.services;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.hibernate.JDBCException;
import org.springframework.dao.DataIntegrityViolationException;

import com.aug.hrdb.dto.EmployeeDto;
import com.aug.hrdb.entities.Employee;



public interface EmployeeService {
	
	public void create(Employee employee);
	public void update(Employee employee);
	public void delete(Employee employee);
	public Employee findById(Integer Id);
	public List<Employee> findAll();
	public Employee deleteById(Integer id);
	public List<Employee> findByCriteria(Employee employee);
	public void createEmployeeAndAddress(Employee employee);
	public void saveByNameQuery(EmployeeDto allEmployeeDto);
	public Employee searhEmpIdtoAddress();
	public void saveEmpAndWithRelateTable(EmployeeDto allEmployeeDto);
	public EmployeeDto findEmployeeByEmployeeIdWithSetToDto(Integer id); 
	public Employee createEmployeeAndReturnId(EmployeeDto allEmployeeDto,String employeeCode) throws JDBCException;
	public Employee updateEmployeeAndReturnId(EmployeeDto allEmployeeDto,String employeeCode) throws DataIntegrityViolationException;
	public void deleteEmployeeByHibernate(Employee employee);
	public Employee findAndinitializeOfficial(Integer id);
	public List<Employee> findAimRelateWithEmployee(Integer id);
	public Employee findOfficial(Integer id);
	public Employee findEmployeeCode(Integer locationId);
	public String generateEmployeeCode(EmployeeDto allEmployeeDto);
}
