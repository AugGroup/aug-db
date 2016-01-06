package com.aug.hrdb.services;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.dto.EmployeeDto;
import com.aug.hrdb.dto.EmployeeListDto;
import com.aug.hrdb.dto.ReportEmployeeDto;
import com.aug.hrdb.dto.ReportLeaveDto;
import com.aug.hrdb.dto.ReportStatusEmployeeDto;
import com.aug.hrdb.entities.Employee;
import com.aug.hrdb.repositories.EmployeeRepository;




@Service("employeeDtoService")
@Transactional
public class EmployeeDtoService {

	@Autowired private EmployeeRepository employeeDaoRepository;
	
	public List<EmployeeListDto> searchEmployee(){
		return employeeDaoRepository.searchEmployee();
	}
	
	public List<ReportEmployeeDto> reportEmployee(String nameEng){
		return employeeDaoRepository.reportEmployee(nameEng);
	}
	
	public List<ReportEmployeeDto> reportEmployeeCode(String code){
		return employeeDaoRepository.reportEmployeeCode(code);
	}

	
	public List<ReportStatusEmployeeDto> reportStatusEmployee(String statusStaff){
		return employeeDaoRepository.reportStatusEmployee(statusStaff);
	}
	
	
	public List<ReportLeaveDto> reportLeave(String nameEng){
		return employeeDaoRepository.reportLeave(nameEng);
	}
	
//	public Employee findOfficial(Integer id){
//		return employeeDaoRepository.findOfficial(id);
//	}
	
	public List<ReportEmployeeDto> findByName(Employee employee) {
		return employeeDaoRepository.findByName(employee);
	}
	
	public List<ReportStatusEmployeeDto> findByNameStatus(Employee employee) {
		return employeeDaoRepository.findByNameStatus(employee);
	}
	
	
	public List<EmployeeListDto> searchEmpForUniqueIdCard(Integer id,String idCard) {
		return employeeDaoRepository.searchEmpForUniqueIdCard(id, idCard);
	}

	
}
