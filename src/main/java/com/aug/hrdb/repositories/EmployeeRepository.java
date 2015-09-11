/**
 *
 * @author natechanok
 * @date Apr 27, 2015
 */

package com.aug.hrdb.repositories;

import java.util.List;

import com.aug.hrdb.dto.AimEmployeeDto;
import com.aug.hrdb.dto.EmployeeCodeDto;
import com.aug.hrdb.dto.EmployeeDto;
import com.aug.hrdb.dto.EmployeeIdDto;
import com.aug.hrdb.dto.ReportEmployeeDto;
import com.aug.hrdb.dto.ReportLeaveDto;
import com.aug.hrdb.dto.ReportStatusEmployeeDto;
import com.aug.hrdb.entities.Employee;



public interface EmployeeRepository extends GenericRepository<Employee, Integer>{
	
	public List<Employee> findByCriteria(Employee employee);

	public void deleteById(Integer id);

	public List<EmployeeDto> searchEmployee();
	
	public List<AimEmployeeDto> listEmployeeAim();
	public void saveByNameQuery(EmployeeDto allEmployeeDto);
	public Employee searhEmpIdtoAddress(); 	//find last id of employee
	public List<ReportEmployeeDto> reportEmployee(String nameEng);
	public List<ReportStatusEmployeeDto> reportStatusEmployee(String statusStaff);
	public EmployeeCodeDto serchRunningNo(String code);
	public List<ReportLeaveDto> reportLeave(String nameEng);
	public void updateByNameQuery(EmployeeDto allEmployeeDto);
	public EmployeeIdDto findCurrentId();
	public Employee findEmployeeAndOfficial(Integer id);
	public void deleteEmployeeByNameQuery(Employee employee);
	public List<Employee> findAimRelateWithEmployee(Integer id);
	public Employee findOfficial(Integer id);
	public List<ReportEmployeeDto> findByName(Employee employee);
	public List<ReportStatusEmployeeDto> findByNameStatus(Employee employee);
	public List<ReportEmployeeDto> reportEmployeeCode(String code);
	public Employee findEmployeeCode(Integer locationId);

	
}
