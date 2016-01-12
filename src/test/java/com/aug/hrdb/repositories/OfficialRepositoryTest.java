/**
 * @author natechanok
 * @date Sep 4, 2015
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
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-bean-db-test.xml"})
@TransactionConfiguration
@Transactional
public class OfficialRepositoryTest {

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
  private OfficialRepository officialRepository;

  private Official official;

  private Date start, probation;

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
    applicant.setEmployedPosition("Java Consultant");
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

    //create official
    start =  Calendar.getInstance().getTime();
    probation =  Calendar.getInstance().getTime();

    official = new Official();
    official.setAuditFlag("C");
    official.setCreatedBy(1);
    official.setCreatedTimeStamp(Calendar.getInstance().getTime());
    official.setStartWorkDate(start);
    official.setProbationDate(probation);
    official.setApplicant(applicant);
    officialRepository.create(official);

    // update official for applicant
    applicant.setOfficial(official);
    applicantRepository.update(applicant);

  }

  @Test
  public void testLoadRepositoriesShouldPass() throws Exception {
    assertNotNull(masCoreSkillRepository);
    assertNotNull(masJobLevelRepository);
    assertNotNull(masDivisionRepository);
    assertNotNull(masTechnologyRepository);
    assertNotNull(employeeRepository);
    assertNotNull(applicantRepository);
    assertNotNull(officialRepository);

  }

  @Test
  public void testFindWithOfficialRepositoryShouldReturnOfficialThatSetup() throws Exception {
    Official result = officialRepository.find(official.getId());
    assertNotNull(result);
    assertThat(result.getApplicant().getFirstNameEN(), is("Anat"));
    assertThat(result.getStartWorkDate(), is(start));
    assertThat(result.getProbationDate(), is(probation));

  }

  @Test
  public void testFindAllWithOfficialRepositoryShouldReturnListOfAllOfficial() throws Exception {
    List<Official> result = officialRepository.findAll();
    assertNotNull(result);
    assertThat(result.size(), is(new GreaterOrEqual<>(1)));

  }

  @Test
  public void testUpdateWithOfficialRepositoryShouldReturnOfficialThatUpdate() throws Exception {
    Official update = officialRepository.find(official.getId());
    assertThat(update.getStartWorkDate(), is(start));
    assertThat(update.getProbationDate(), is(probation));

    Date updateDate = Calendar.getInstance().getTime();
    update.setProbationDate(updateDate);
    officialRepository.update(update);

    Official result = officialRepository.find(update.getId());
    assertThat(result.getProbationDate(), is(updateDate));

  }

  @Test
  public void testDeleteWithOfficialRepositoryShouldNotFindThatOfficial() throws Exception {
    Official delete = officialRepository.find(official.getId());
    officialRepository.delete(delete);

    Official result = officialRepository.find(delete.getId());
    assertNull(result);

  }

  @Test
  public void testDeleteByIdWithOfficialRepositoryShouldNotFindThatOfficial() throws Exception {
    Official delete = officialRepository.find(official.getId());
    officialRepository.deleteById(delete.getId());

    Official result = officialRepository.find(delete.getId());
    assertNull(result);

  }

  @Test
  public void testFindByCriteriaWithOfficialRepositoryShouldReturnListOfOfficialOfThatEmployedPosition() throws Exception {
    List<Official> result = officialRepository.findByCriteria(official.getApplicant());
    assertNotNull(result);
    assertThat(result.get(0).getApplicant().getEmployedPosition(), is("Java Consultant"));

  }

  @Test
  public void testSearchEmpIdToOfficialWithOfficialRepositoryShouldReturnLastOfficial() throws Exception {
    Official result = officialRepository.searchEmpIdToOfficial();
    assertNotNull(result);
    assertThat(result.getStartWorkDate(), is(start));
    assertThat(result.getProbationDate(), is(probation));

  }

  //  wait clear
//  @Test
//  public void testSaveOfficialByNameQueryWithOfficialRepositoryShouldPass() throws Exception {
//
//  }

//  wait clear
//  @Test
//  public void testUpdateOfficialByNameQueryWithOfficialRepositoryShouldPass() throws Exception {
//
//  }

}