/**
 * @author Pranrajit
 * @date 25 พ.ค. 2558
 */
package com.aug.hrdb.services;

import java.util.List;

import com.aug.hrdb.dto.LeaveDto;
import com.aug.hrdb.dto.ReportLeaveDto;
import com.aug.hrdb.entities.Leave;

public interface LeaveService {

  List<Leave> findAll();

  void create(Leave leave);

  void update(Leave leave);

  void delete(Leave leave);

  Leave findById(Integer id);

  void deleteById(Integer id);

  List<LeaveDto> searchLeave(Integer id);

  List<ReportLeaveDto> reportLeave(String searchText);

  List<Leave> findLeaveType(Integer idLeave, Integer idEmp);

}
