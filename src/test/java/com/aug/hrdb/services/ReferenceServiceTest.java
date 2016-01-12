package com.aug.hrdb.services;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;

import com.aug.hrdb.dto.ReferenceDto;
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
public class ReferenceServiceTest {

  @Autowired
  private MasCoreSkillService masCoreSkillService;

  @Autowired
  private MasJobLevelService masJobLevelService;

  @Autowired
  private MasTechnologyService masTechnologyService;

  @Autowired
  private ApplicantService applicantService;

  @Autowired
  private MasDivisionService masDivisionService;

  @Autowired
  private EmployeeService employeeService;

  @Autowired
  private ReferenceService referenceService;

  private Reference reference;

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

    // create reference
    reference = new Reference();
    reference.setAuditFlag("C");
    reference.setCreatedBy(1);
    reference.setCreatedTimeStamp(Calendar.getInstance().getTime());
    reference.setName("NAME");
    reference.setOccupation("OCCUPATION");
    reference.setTel("000-0000000");
    reference.setApplicant(applicant);
    referenceService.create(reference);

  }

  @Test
  public void testLoadServicesShouldPass() throws Exception {
    assertNotNull(referenceService);
    assertNotNull(masCoreSkillService);
    assertNotNull(masJobLevelService);
    assertNotNull(masTechnologyService);
    assertNotNull(applicantService);

  }

  @Test
  public void testFindWithReferenceServiceShouldReturnReferenceThatSetup() throws Exception {
    Reference result = referenceService.findById(reference.getId());
    assertNotNull(result);
    assertThat(result.getApplicant().getFirstNameEN(), is("Anat"));
    assertThat(result.getName(), is("NAME"));
    assertThat(result.getOccupation(), is("OCCUPATION"));

  }

  @Test
  public void testFindAllWithReferenceServiceShouldReturnListOfAllReference() throws Exception {
    List<Reference> result = referenceService.findAll();
    assertNotNull(result);
    assertThat(result.size(), is(new GreaterOrEqual<>(1)));

  }

  @Test
  public void testUpdateWithReferenceServiceShouldReturnReferenceThatUpdate() throws Exception {
    Reference update = referenceService.findById(reference.getId());
    assertThat(update.getName(), is("NAME"));
    assertThat(update.getOccupation(), is("OCCUPATION"));

    update.setOccupation("OCCUPATION UPDATE");
    referenceService.update(update);

    Reference result = referenceService.findById(update.getId());
    assertThat(result.getOccupation(), is("OCCUPATION UPDATE"));

  }

  @Test
  public void testDeleteWithReferenceServiceShouldNotFindThatReference() throws Exception {
    Reference delete = referenceService.findById(reference.getId());
    referenceService.delete(delete);

    Reference result = referenceService.findById(delete.getId());
    assertNull(result);

  }

  @Test
  public void testDeleteByIdWithReferenceServiceShouldNotFindThatReference() throws Exception {
    Reference delete = referenceService.findById(reference.getId());
    referenceService.deleteById(delete.getId());

    Reference result = referenceService.findById(delete.getId());
    assertNull(result);

  }

  @Test
  public void testFindByCriteriaWithReferenceServiceShouldReturnListOfReferenceOfThatName() throws Exception {
    List<Reference> result = referenceService.findByCriteria(reference);
    assertNotNull(result);
    assertThat(result.get(0).getName(), is("NAME"));

  }

  @Test
  public void testSearchReferenceWithReferenceServiceShouldReturnListOfReferenceDtoOfThatEmployeeId() throws Exception {
    List<ReferenceDto> result = referenceService.searchReference(employee.getId());
    assertNotNull(result);
    assertThat(result.get(0).getName(), is("NAME"));
    assertThat(result.get(0).getApplicantId(), is(reference.getApplicant().getId()));

  }

  @Test
  public void testFindReferenceByIdWithReferenceServiceShouldReturnListOfReferenceDtoOfThatApplicantId() throws Exception {
    List<ReferenceDto> result = referenceService.findReferenceById(reference.getApplicant().getId());
    assertNotNull(result);
    assertThat(result.get(0).getName(), is("NAME"));
    assertThat(result.get(0).getOccupation(), is("OCCUPATION"));

  }

  @Test
  public void testFindReferenceWithReferenceServiceShouldReturnReferenceDtoOfThatReferenceId() throws Exception {
    ReferenceDto result = referenceService.findReference(reference.getId());
    assertNotNull(result);
    assertThat(result.getName(), is("NAME"));
    assertThat(result.getOccupation(), is("OCCUPATION"));

  }
  
}