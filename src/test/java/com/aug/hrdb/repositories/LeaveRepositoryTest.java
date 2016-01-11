/**
 * @author Pranrajit
 * @date 4 ก.ย. 2558
 */
package com.aug.hrdb.repositories;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import com.aug.hrdb.entities.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.GreaterOrEqual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-bean-db-test.xml"})
@TransactionConfiguration
@Transactional
public class LeaveRepositoryTest {

  @Autowired
  private MasCoreSkillRepository masCoreSkillRepository;

  @Autowired
  private MasJobLevelRepository masJobLevelRepository;

  @Autowired
  private MasTechnologyRepository masTechnologyRepository;

  @Autowired
  private MasDivisionRepository masDivisionRepository;

  @Autowired
  private ApplicantRepository applicantRepository;

  @Autowired
  private EmployeeRepository employeeRepository;

  @Autowired
  private MasLeaveTypeRepository masLeaveTypeRepository;

  @Autowired
  private LeaveRepository leaveRepository;

  private Leave leave;

  private Employee employee;

  @Before
  public void setUp() throws Exception {
    // create applicant
    MasCoreSkill masCoreSkill = new MasCoreSkill();
    masCoreSkill.setAuditFlag("C");
    masCoreSkill.setCreatedBy(1);
    masCoreSkill.setCreatedTimeStamp(Calendar.getInstance().getTime());
    masCoreSkill.setIsActive(true);
    masCoreSkill.setCode("ITS");
    masCoreSkill.setName("ITS");
    masCoreSkillRepository.create(masCoreSkill);

    MasJobLevel masJobLevel = new MasJobLevel();
    masJobLevel.setAuditFlag("C");
    masJobLevel.setCreatedBy(1);
    masJobLevel.setCreatedTimeStamp(Calendar.getInstance().getTime());
    masJobLevel.setIsActive(true);
    masJobLevel.setCode("C");
    masJobLevel.setName("Consultant");
    masJobLevelRepository.create(masJobLevel);

    MasTechnology masTechnology = new MasTechnology();
    masTechnology.setAuditFlag("C");
    masTechnology.setCreatedBy(1);
    masTechnology.setCreatedTimeStamp(Calendar.getInstance().getTime());
    masTechnology.setIsActive(true);
    masTechnology.setCode("1");
    masTechnology.setName("Java");
    masTechnologyRepository.create(masTechnology);

    Applicant applicant = new Applicant();
    applicant.setAuditFlag("C");
    applicant.setCreatedBy(1);
    applicant.setCreatedTimeStamp(Calendar.getInstance().getTime());
    applicant.setFirstNameEN("Anat");
    applicant.setCoreSkill(masCoreSkillRepository.find(masCoreSkill.getId()));
    applicant.setJoblevel(masJobLevelRepository.find(masJobLevel.getId()));
    applicant.setTechnology(masTechnologyRepository.find(masTechnology.getId()));
    applicantRepository.create(applicant);

    // create mas division
    MasDivision masDivision = new MasDivision();
    masDivision.setAuditFlag("C");
    masDivision.setCreatedBy(1);
    masDivision.setCreatedTimeStamp(Calendar.getInstance().getTime());
    masDivision.setIsActive(true);
    masDivision.setCode("ITS");
    masDivision.setName("Integrate Technology Services");
    masDivisionRepository.create(masDivision);

    // create employee
    employee = new Employee();
    employee.setAuditFlag("C");
    employee.setCreatedBy(1);
    employee.setCreatedTimeStamp(Calendar.getInstance().getTime());
    employee.setEmployeeCode("TEST0001");
    employee.setStatusEmp("Employee");
    employee.setTelHome("02-9998877");
    employee.setApplicant(applicant);
    employee.setMasDivision(masDivision);
    employeeRepository.create(employee);

    MasLeaveType masLeaveType = new MasLeaveType();
    masLeaveType.setName("test");
    masLeaveType.setCode("MD-01");
    masLeaveType.setIsactive(true);
    masLeaveType.setAuditFlag("C");
    masLeaveType.setCreatedBy(1);
    masLeaveType.setCreatedTimeStamp(Calendar.getInstance().getTime());
    masLeaveTypeRepository.create(masLeaveType);

    leave = new Leave();
    leave.setAuditFlag("C");
    leave.setCreatedBy(1);
    leave.setCreatedTimeStamp(Calendar.getInstance().getTime());
    leave.setEmployee(employee);
    leave.setMasleavetype(masLeaveType);
    leave.setAim("Adisorn");
    leaveRepository.create(leave);

  }

  @Test
  public void testLoadRepositoriesShouldPass() throws Exception {
    assertNotNull(masLeaveTypeRepository);
    assertNotNull(leaveRepository);
    assertNotNull(masCoreSkillRepository);
    assertNotNull(masJobLevelRepository);
    assertNotNull(masDivisionRepository);
    assertNotNull(masTechnologyRepository);
    assertNotNull(employeeRepository);
    assertNotNull(applicantRepository);

  }

  @Test
  public void testFindWithLeaveRepositoryShouldReturnLeaveThatSetup() throws Exception {
    Leave result = leaveRepository.find(leave.getId());
    assertNotNull(result);
    assertThat(result.getAim(), is("Adisorn"));
    assertThat(result.getEmployee().getApplicant().getFirstNameEN(), is("Anat"));
    assertThat(result.getMasleavetype().getName(), is("test"));

  }

  @Test
  public void testFindAllWithLeaveRepositoryShouldReturnListOfAllLeave() throws Exception {
    List<Leave> result = leaveRepository.findAll();
    assertNotNull(result);
    assertThat(result.size(), is(new GreaterOrEqual<>(1)));

  }

  @Test
  public void testUpdateWithLeaveRepositoryShouldReturnLeaveThatUpdate() throws Exception {
    Leave update = leaveRepository.find(leave.getId());
    assertThat(update.getAim(), is("Adisorn"));
    assertThat(update.getEmployee().getApplicant().getFirstNameEN(), is("Anat"));
    assertThat(update.getMasleavetype().getName(), is("test"));

    update.setAim("Ekkachai");
    leaveRepository.update(update);

    Leave result = leaveRepository.find(update.getId());
    assertThat(result.getAim(), is("Ekkachai"));

  }

  @Test
  public void testDeleteWithLeaveRepositoryShouldNotFindThatLeave() throws Exception {
    Leave delete = leaveRepository.find(leave.getId());
    leaveRepository.delete(delete);

    Leave result = leaveRepository.find(delete.getId());
    assertNull(result);

  }

  @Test
  public void testDeleteByIdWithLeaveRepositoryShouldNotFindThatLeave() throws Exception {
    Leave delete = leaveRepository.find(leave.getId());
    leaveRepository.deleteById(delete.getId());

    Leave result = leaveRepository.find(delete.getId());
    assertNull(result);

  }

//  phase 2
//  @Test
//  public void testSearchLeaveWithLeaveRepositoryShouldReturnListOfLeaveDtoOfThatEmployeeId() throws Exception {
//
//  }

//  phase 2
//  @Test
//  public void testReportLeaveWithLeaveRepositoryShouldReturnListOfReportLeaveDtoOfThatName() throws Exception {
//
//  }

//  phase 2
//  @Test
//  public void testFindLeaveTypeWithLeaveRepositoryShouldReturnListOfLeaveOfThatMasLeaveTypeIdAndEmployeeId() throws Exception {
//
//  }

}