/**
 * @author Pranrajit
 * @date 25 พ.ค. 2558
 */
package com.aug.hrdb.services.impl;

import java.util.List;

import com.aug.hrdb.dto.LeaveDto;
import com.aug.hrdb.dto.ReportLeaveDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.Leave;
import com.aug.hrdb.repositories.LeaveRepository;
import com.aug.hrdb.services.LeaveService;

@Transactional
@Service(value = "leaveService")
public class LeaveServiceImpl implements LeaveService {

  @Autowired
  private LeaveRepository leaveRepository;

  @Override
  public List<Leave> findAll() {
    return leaveRepository.findAll();
  }

  @Override
  public void create(Leave leave) {
    leaveRepository.create(leave);
  }

  @Override
  public void update(Leave leave) {
    leaveRepository.update(leave);
  }

  @Override
  public void delete(Leave leave) {
    leaveRepository.delete(leave);
  }

  @Override
  public Leave findById(Integer id) {
    return leaveRepository.find(id);
  }

  @Override
  public void deleteById(Integer id) {
    leaveRepository.deleteById(id);
  }

  @Override
  public List<LeaveDto> searchLeave(Integer id) {
    return searchLeave(id);
  }

  @Override
  public List<ReportLeaveDto> reportLeave(String searchText) {
    return leaveRepository.reportLeave(searchText);
  }

  @Override
  public List<Leave> findLeaveType(Integer idLeave, Integer idEmp) {
    return leaveRepository.findLeaveType(idLeave, idEmp);
  }

}