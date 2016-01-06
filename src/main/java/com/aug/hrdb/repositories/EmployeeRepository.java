/**
 * @author natechanok
 * @date Apr 27, 2015
 */

package com.aug.hrdb.repositories;

import java.util.List;

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

public interface EmployeeRepository extends GenericRepository<Employee, Integer> {

  List<Employee> findByCriteria(Employee employee);

  List<EmployeeListDto> searchEmployee();

  List<AimEmployeeDto> listEmployeeAim();

  Employee searchEmpIdToAddress();  //find last id of employee

  List<ReportEmployeeDto> reportEmployee(String nameEng);

  List<ReportStatusEmployeeDto> reportStatusEmployee(String statusStaff);

  List<ReportLeaveDto> reportLeave(String nameEng);

  EmployeeIdDto findCurrentId();

  Employee findEmployeeAndOfficial(Integer id);

  List<Employee> findAimRelateWithEmployee(Integer id);

  List<ReportEmployeeDto> findByName(Employee employee);

  List<ReportStatusEmployeeDto> findByNameStatus(Employee employee);

  List<ReportEmployeeDto> reportEmployeeCode(String code);

  List<AimEmployeeDto> listEmployeeAimForUpdate(Integer id);

  List<EmployeeListDto> searchEmpForUniqueIdCard(Integer id, String idCard);

  List<EmployeeCodeDto> findEmployeeCode(Integer location_id);

  List<DivisionDto> checkTag(String tag);

  List<JoblevelDto> checkTagDivision(String tag);

  String findByIdDivision(Integer id);

}