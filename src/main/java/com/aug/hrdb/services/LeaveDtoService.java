/**
 *
 * @author Preeyaporn
 * @date 25 พ.ค. 2558
 */
package com.aug.hrdb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.dto.LeaveDto;
import com.aug.hrdb.dto.ReportLeaveDto;
import com.aug.hrdb.repositories.LeaveRepository;



@Service("leaveDtoService")
@Transactional
public class LeaveDtoService {
	
	@Autowired private LeaveRepository leaveRepository;
	
	public List<LeaveDto> searchLeave(Integer id){
		return leaveRepository.searchLeave(id);
	}

	public List<ReportLeaveDto> reportLeave(String searchText) {
		// TODO Auto-generated method stub
		return leaveRepository.reportLeave(searchText);
	}





	/*public List<ReportLeaveDto> reportLeave(String nameEng){
		return leaveRepository.reportLeave(nameEng);
	}*/
	
	
}
