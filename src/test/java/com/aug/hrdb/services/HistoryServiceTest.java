/**
 * @author Preeyaporn
 * @date 7 ก.ย. 2558
 */
package com.aug.hrdb.services;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;

import com.aug.hrdb.dto.HistoryDto;
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
public class HistoryServiceTest {


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
  private HistoryService historyService;

  private History history;

  @Before
  public void setHistory() {
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
    Employee employee = new Employee();
    employee.setAuditFlag("C");
    employee.setCreatedBy(1);
    employee.setCreatedTimeStamp(Calendar.getInstance().getTime());
    employee.setEmployeeCode("TEST0001");
    employee.setStatusEmp("Employee");
    employee.setTelHome("02-9998877");
    employee.setApplicant(applicant);
    employee.setMasDivision(masDivision);
    employeeService.create(employee);

    // create history
    history = new History();
    history.setAuditFlag("C");
    history.setCreatedBy(1);
    history.setCreatedTimeStamp(Calendar.getInstance().getTime());
    history.setDateOfAdjustment(Calendar.getInstance().getTime());
    history.setPosition("Manager");
    history.setSalary((double) 30000);
    history.setEmployee(employee);
    historyService.create(history);

  }

  @Test
  public void testLoadServicesShouldPass() throws Exception {
    assertNotNull(historyService);
    assertNotNull(masCoreSkillService);
    assertNotNull(masJobLevelService);
    assertNotNull(masDivisionService);
    assertNotNull(masTechnologyService);
    assertNotNull(employeeService);
    assertNotNull(applicantService);

  }
  
  @Test
  public void testFindWithHistoryServiceShouldReturnHistoryThatSetup() throws Exception {
    History result = historyService.findById(history.getId());
    assertNotNull(result);
    assertThat(result.getPosition(), is("Manager"));
    assertThat(result.getSalary(), is((double) 30000));

  }

  @Test
  public void testFindAllWithHistoryServiceShouldReturnListOfAllHistory() throws Exception {
    List<History> result = historyService.findAll();
    assertNotNull(result);
    assertThat(result.size(), is(new GreaterOrEqual<>(1)));

  }

  @Test
  public void testUpdateWithHistoryServiceShouldReturnHistoryThatUpdate() throws Exception {
    History update = historyService.findById(history.getId());
    assertThat(update.getPosition(), is("Manager"));
    assertThat(update.getSalary(), is((double) 30000));

    update.setPosition("High Manager");
    update.setSalary((double) 50000);
    historyService.update(update);

    History result = historyService.findById(update.getId());
    assertThat(result.getPosition(), is("High Manager"));
    assertThat(result.getSalary(), is((double) 50000));

  }

  @Test
  public void testDeleteWithHistoryServiceShouldNotFindThatHistory() throws Exception {
    History delete = historyService.findById(history.getId());
    historyService.delete(delete);

    History result = historyService.findById(delete.getId());
    assertNull(result);

  }

  @Test
  public void testDeleteByIdWithHistoryServiceShouldNotFindThatHistory() throws Exception {
    History delete = historyService.findById(history.getId());
    historyService.deleteById(delete.getId());

    History result = historyService.findById(delete.getId());
    assertNull(result);

  }

  @Test
  public void testFindByCriteriaWithHistoryServiceShouldReturnListOfHistoryOfThatPosition() throws Exception {
    List<History> result = historyService.findByCriteria(history);
    assertNotNull(result);
    assertThat(result.get(0).getPosition(), is("Manager"));

  }

  @Test
  public void testSearchHistoryWithHistoryServiceShouldReturnListOfHistoryDtoOfThatEmployeeId() throws Exception {
    List<HistoryDto> result = historyService.searchHistory(history.getEmployee().getId());
    assertNotNull(result);
    assertThat(result.get(0).getPosition(), is("Manager"));
    assertThat(result.get(0).getSalary(), is((double) 30000));

  }

}