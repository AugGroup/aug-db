/**
 * @author natechanok
 * @date Apr 27, 2015
 */

package com.aug.hrdb.services;

import java.util.List;

import com.aug.hrdb.dto.*;
import org.springframework.dao.DataIntegrityViolationException;

import com.aug.hrdb.entities.Employee;


public interface EmployeeService {

  void create(Employee employee);

  void update(Employee employee);

  void delete(Employee employee);

  Employee findById(Integer Id);

  List<Employee> findAll();

  void deleteById(Integer id);

  List<Employee> findByCriteria(Employee employee);

  List<EmployeeListDto> searchEmployee();

  List<AimEmployeeDto> listEmployeeAim();

  Employee searchEmpIdToAddress();  //find last id of employee

  List<ReportEmployeeDto> reportEmployee(String nameEng);

  List<ReportStatusEmployeeDto> reportStatusEmployee(String statusStaff);

  EmployeeIdDto findCurrentId();

  List<ReportEmployeeDto> findByName(Employee employee);

  List<EmployeeCodeDto> findEmployeeCode(Integer location_id);

  List<Employee> findAimRelateWithEmployee(Integer id);

  List<DivisionDto> checkTag(String tag);

  List<JoblevelDto> checkTagDivision(String tag);

  String findByIdDivision(Integer id);

  //--- method not in repository---//

  EmployeeDto findEmployeeByEmployeeIdWithSetToDto(Integer id);

  Employee updateEmployeeAndReturnId(EmployeeDto employeeDto);

  Employee findAndInitializeOfficial(Integer id);

  String generateEmployeeCode(EmployeeDto employeeDto);

  String generateEmployeeCodeFixData(String location);

}