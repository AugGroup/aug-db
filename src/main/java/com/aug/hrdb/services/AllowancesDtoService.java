/**
 *
 * @author Preeyaporn
 * @date 3 มิ.ย. 2558
 */
package com.aug.hrdb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.dto.AllowanceDto;
import com.aug.hrdb.repositories.AllowanceRepository;

@Service("allowancesDtoService")
@Transactional
public class AllowancesDtoService {

@Autowired private AllowanceRepository allowancesRepository;
	
	public List<AllowanceDto> searchAllowances(Integer id){
		return allowancesRepository.searchAllowances(id);
	}
}
