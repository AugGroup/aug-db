/**
 *
 * @author natechanok
 * @date May 20, 2015
 */

package com.aug.hrdb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.dto.AimEmployeeDto;
import com.aug.hrdb.repositories.EmployeeRepository;



@Service("aimEmployeeDtoService")
@Transactional
public class AimEmployeeDtoService {
	
	@Autowired private EmployeeRepository employeeRepository;
	
	public List<AimEmployeeDto> listEmployeeAim(){
		return employeeRepository.listEmployeeAim();

	}
}
