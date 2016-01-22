/**
 * @author Preeyaporn
 * @date 7 ก.ย. 2558
 */
package com.aug.hrdb.repositories;

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
public class HistoryRepositoryTest {

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
  private HistoryRepository historyRepository;

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
    Employee employee = new Employee();
    employee.setAuditFlag("C");
    employee.setCreatedBy(1);
    employee.setCreatedTimeStamp(Calendar.getInstance().getTime());
    employee.setEmployeeCode("TEST0001");
    employee.setStatusEmp("Employee");
    employee.setTelHome("02-9998877");
    employee.setApplicant(applicant);
    employee.setMasDivision(masDivision);
    employeeRepository.create(employee);

    // create history
    history = new History();
    history.setAuditFlag("C");
    history.setCreatedBy(1);
    history.setCreatedTimeStamp(Calendar.getInstance().getTime());
    history.setDateOfAdjustment(Calendar.getInstance().getTime());
    history.setPosition("Manager");
    history.setSalary((double) 30000);
    history.setEmployee(employee);
    historyRepository.create(history);

  }

  @Test
  public void testLoadRepositoriesShouldPass() throws Exception {
    assertNotNull(historyRepository);
    assertNotNull(masCoreSkillRepository);
    assertNotNull(masJobLevelRepository);
    assertNotNull(masDivisionRepository);
    assertNotNull(masTechnologyRepository);
    assertNotNull(employeeRepository);
    assertNotNull(applicantRepository);

  }
  @Test
  public void testFindWithHistoryRepositoryShouldReturnHistoryThatSetup() throws Exception {
    History result = historyRepository.find(history.getId());
    assertNotNull(result);
    assertThat(result.getPosition(), is("Manager"));
    assertThat(result.getSalary(), is((double) 30000));

  }

  @Test
  public void testFindAllWithHistoryRepositoryShouldReturnListOfAllHistory() throws Exception {
    List<History> result = historyRepository.findAll();
    assertNotNull(result);
    assertThat(result.size(), is(new GreaterOrEqual<>(1)));

  }

  @Test
  public void testUpdateWithHistoryRepositoryShouldReturnHistoryThatUpdate() throws Exception {
    History update = historyRepository.find(history.getId());
    assertThat(update.getPosition(), is("Manager"));
    assertThat(update.getSalary(), is((double) 30000));

    update.setPosition("High Manager");
    update.setSalary((double) 50000);
    historyRepository.update(update);

    History result = historyRepository.find(update.getId());
    assertThat(result.getPosition(), is("High Manager"));
    assertThat(result.getSalary(), is((double) 50000));

  }

  @Test
  public void testDeleteWithHistoryRepositoryShouldNotFindThatHistory() throws Exception {
    History delete = historyRepository.find(history.getId());
    historyRepository.delete(delete);

    History result = historyRepository.find(delete.getId());
    assertNull(result);

  }

  @Test
  public void testDeleteByIdWithHistoryRepositoryShouldNotFindThatHistory() throws Exception {
    History delete = historyRepository.find(history.getId());
    historyRepository.deleteById(delete.getId());

    History result = historyRepository.find(delete.getId());
    assertNull(result);

  }

  @Test
  public void testFindByCriteriaWithHistoryRepositoryShouldReturnListOfHistoryOfThatPosition() throws Exception {
    List<History> result = historyRepository.findByCriteria(history);
    assertNotNull(result);
    assertThat(result.get(0).getPosition(), is("Manager"));

  }

  @Test
  public void testSearchHistoryWithHistoryRepositoryShouldReturnListOfHistoryDtoOfThatEmployeeId() throws Exception {
    List<HistoryDto> result = historyRepository.searchHistory(history.getEmployee().getId());
    assertNotNull(result);
    assertThat(result.get(0).getPosition(), is("Manager"));
    assertThat(result.get(0).getSalary(), is((double) 30000));

  }

}