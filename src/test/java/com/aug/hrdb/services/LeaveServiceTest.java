/**
 * @author Pranrajit
 * @date 4 ก.ย. 2558
 */
package com.aug.hrdb.services;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;

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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-bean-db-test.xml"})
@TransactionConfiguration
@Transactional
public class LeaveServiceTest {

  @Autowired
  private MasCoreSkillService masCoreSkillService;

  @Autowired
  private MasJobLevelService masJobLevelService;

  @Autowired
  private MasTechnologyService masTechnologyService;

  @Autowired
  private MasDivisionService masDivisionService;

  @Autowired
  private ApplicantService applicantService;

  @Autowired
  private EmployeeService employeeService;

  @Autowired
  private MasLeaveTypeService masLeaveTypeService;

  @Autowired
  private LeaveService leaveService;

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
    masCoreSkillService.create(masCoreSkill);

    MasJobLevel masJobLevel = new MasJobLevel();
    masJobLevel.setAuditFlag("C");
    masJobLevel.setCreatedBy(1);
    masJobLevel.setCreatedTimeStamp(Calendar.getInstance().getTime());
    masJobLevel.setIsActive(true);
    masJobLevel.setCode("C");
    masJobLevel.setName("Consultant");
    masJobLevelService.create(masJobLevel);

    MasTechnology masTechnology = new MasTechnology();
    masTechnology.setAuditFlag("C");
    masTechnology.setCreatedBy(1);
    masTechnology.setCreatedTimeStamp(Calendar.getInstance().getTime());
    masTechnology.setIsActive(true);
    masTechnology.setCode("1");
    masTechnology.setName("Java");
    masTechnologyService.create(masTechnology);

    Applicant applicant = new Applicant();
    applicant.setAuditFlag("C");
    applicant.setCreatedBy(1);
    applicant.setCreatedTimeStamp(Calendar.getInstance().getTime());
    applicant.setFirstNameEN("Anat");
    applicant.setCoreSkill(masCoreSkillService.findById(masCoreSkill.getId()));
    applicant.setJoblevel(masJobLevelService.findById(masJobLevel.getId()));
    applicant.setTechnology(masTechnologyService.findById(masTechnology.getId()));
    applicantService.create(applicant);

    // create mas division
    MasDivision masDivision = new MasDivision();
    masDivision.setAuditFlag("C");
    masDivision.setCreatedBy(1);
    masDivision.setCreatedTimeStamp(Calendar.getInstance().getTime());
    masDivision.setIsActive(true);
    masDivision.setCode("ITS");
    masDivision.setName("Integrate Technology Services");
    masDivisionService.create(masDivision);

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
    employeeService.create(employee);

    MasLeaveType masLeaveType = new MasLeaveType();
    masLeaveType.setName("test");
    masLeaveType.setCode("MD-01");
    masLeaveType.setIsactive(true);
    masLeaveType.setAuditFlag("C");
    masLeaveType.setCreatedBy(1);
    masLeaveType.setCreatedTimeStamp(Calendar.getInstance().getTime());
    masLeaveTypeService.create(masLeaveType);

    leave = new Leave();
    leave.setAuditFlag("C");
    leave.setCreatedBy(1);
    leave.setCreatedTimeStamp(Calendar.getInstance().getTime());
    leave.setEmployee(employee);
    leave.setMasleavetype(masLeaveType);
    leave.setAim("Adisorn");
    leaveService.create(leave);

  }

  @Test
  public void testLoadServicesShouldPass() throws Exception {
    assertNotNull(masLeaveTypeService);
    assertNotNull(leaveService);
    assertNotNull(masCoreSkillService);
    assertNotNull(masJobLevelService);
    assertNotNull(masDivisionService);
    assertNotNull(masTechnologyService);
    assertNotNull(employeeService);
    assertNotNull(applicantService);

  }

  @Test
  public void testFindWithLeaveServiceShouldReturnLeaveThatSetup() throws Exception {
    Leave result = leaveService.findById(leave.getId());
    assertNotNull(result);
    assertThat(result.getAim(), is("Adisorn"));
    assertThat(result.getEmployee().getApplicant().getFirstNameEN(), is("Anat"));
    assertThat(result.getMasleavetype().getName(), is("test"));

  }

  @Test
  public void testFindAllWithLeaveServiceShouldReturnListOfAllLeave() throws Exception {
    List<Leave> result = leaveService.findAll();
    assertNotNull(result);
    assertThat(result.size(), is(new GreaterOrEqual<>(1)));

  }

  @Test
  public void testUpdateWithLeaveServiceShouldReturnLeaveThatUpdate() throws Exception {
    Leave update = leaveService.findById(leave.getId());
    assertThat(update.getAim(), is("Adisorn"));
    assertThat(update.getEmployee().getApplicant().getFirstNameEN(), is("Anat"));
    assertThat(update.getMasleavetype().getName(), is("test"));

    update.setAim("Ekkachai");
    leaveService.update(update);

    Leave result = leaveService.findById(update.getId());
    assertThat(result.getAim(), is("Ekkachai"));

  }

  @Test
  public void testDeleteWithLeaveServiceShouldNotFindThatLeave() throws Exception {
    Leave delete = leaveService.findById(leave.getId());
    leaveService.delete(delete);

    Leave result = leaveService.findById(delete.getId());
    assertNull(result);

  }

  @Test
  public void testDeleteByIdWithLeaveServiceShouldNotFindThatLeave() throws Exception {
    Leave delete = leaveService.findById(leave.getId());
    leaveService.deleteById(delete.getId());

    Leave result = leaveService.findById(delete.getId());
    assertNull(result);

  }

//  phase 2
//  @Test
//  public void testSearchLeaveWithLeaveServiceShouldReturnListOfLeaveDtoOfThatEmployeeId() throws Exception {
//
//  }

//  phase 2
//  @Test
//  public void testReportLeaveWithLeaveServiceShouldReturnListOfReportLeaveDtoOfThatName() throws Exception {
//
//  }

//  phase 2
//  @Test
//  public void testFindLeaveTypeWithLeaveServiceShouldReturnListOfLeaveOfThatMasLeaveTypeIdAndEmployeeId() throws Exception {
//
//  }
  
}