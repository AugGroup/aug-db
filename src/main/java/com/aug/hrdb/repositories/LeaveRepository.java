/**
 *
 * @author Pranrajit
 * @date 25 พ.ค. 2558
 */
package com.aug.hrdb.repositories;

import java.util.List;

import com.aug.hrdb.dto.LeaveDto;
import com.aug.hrdb.dto.ReportLeaveDto;
import com.aug.hrdb.entities.Leave;






public interface LeaveRepository extends GenericRepository<Leave, Integer>{

	
	
  // public List<Leave> findByCriteria(Leave leave);
	


	public List<LeaveDto> searchLeave(Integer id);

	public List<ReportLeaveDto> reportLeave(String searchText);
	
	public List<Leave> findLeaveType(Integer idLeave,Integer idEmp);

	//public List<ReportLeaveDto> reportLeave(String nameEng);
}
