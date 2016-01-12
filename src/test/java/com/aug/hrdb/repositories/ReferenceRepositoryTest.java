package com.aug.hrdb.repositories;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

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

import java.util.Calendar;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-bean-db-test.xml"})
@TransactionConfiguration
@Transactional
public class ReferenceRepositoryTest {

  @Autowired
  private MasCoreSkillRepository masCoreSkillRepository;

  @Autowired
  private MasJobLevelRepository masJobLevelRepository;

  @Autowired
  private MasTechnologyRepository masTechnologyRepository;

  @Autowired
  private ApplicantRepository applicantRepository;

  @Autowired
  private MasDivisionRepository masDivisionRepository;

  @Autowired
  private EmployeeRepository employeeRepository;

  @Autowired
  private ReferenceRepository referenceRepository;

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

    // create reference
    reference = new Reference();
    reference.setAuditFlag("C");
    reference.setCreatedBy(1);
    reference.setCreatedTimeStamp(Calendar.getInstance().getTime());
    reference.setName("NAME");
    reference.setOccupation("OCCUPATION");
    reference.setTel("000-0000000");
    reference.setApplicant(applicant);
    referenceRepository.create(reference);

  }

  @Test
  public void testLoadRepositoriesShouldPass() throws Exception {
    assertNotNull(referenceRepository);
    assertNotNull(masCoreSkillRepository);
    assertNotNull(masJobLevelRepository);
    assertNotNull(masTechnologyRepository);
    assertNotNull(applicantRepository);

  }

  @Test
  public void testFindWithReferenceRepositoryShouldReturnReferenceThatSetup() throws Exception {
    Reference result = referenceRepository.find(reference.getId());
    assertNotNull(result);
    assertThat(result.getApplicant().getFirstNameEN(), is("Anat"));
    assertThat(result.getName(), is("NAME"));
    assertThat(result.getOccupation(), is("OCCUPATION"));

  }

  @Test
  public void testFindAllWithReferenceRepositoryShouldReturnListOfAllReference() throws Exception {
    List<Reference> result = referenceRepository.findAll();
    assertNotNull(result);
    assertThat(result.size(), is(new GreaterOrEqual<>(1)));

  }

  @Test
  public void testUpdateWithReferenceRepositoryShouldReturnReferenceThatUpdate() throws Exception {
    Reference update = referenceRepository.find(reference.getId());
    assertThat(update.getName(), is("NAME"));
    assertThat(update.getOccupation(), is("OCCUPATION"));

    update.setOccupation("OCCUPATION UPDATE");
    referenceRepository.update(update);

    Reference result = referenceRepository.find(update.getId());
    assertThat(result.getOccupation(), is("OCCUPATION UPDATE"));

  }

  @Test
  public void testDeleteWithReferenceRepositoryShouldNotFindThatReference() throws Exception {
    Reference delete = referenceRepository.find(reference.getId());
    referenceRepository.delete(delete);

    Reference result = referenceRepository.find(delete.getId());
    assertNull(result);

  }

  @Test
  public void testDeleteByIdWithReferenceRepositoryShouldNotFindThatReference() throws Exception {
    Reference delete = referenceRepository.find(reference.getId());
    referenceRepository.deleteById(delete.getId());

    Reference result = referenceRepository.find(delete.getId());
    assertNull(result);

  }

  @Test
  public void testFindByCriteriaWithReferenceRepositoryShouldReturnListOfReferenceOfThatName() throws Exception {
    List<Reference> result = referenceRepository.findByCriteria(reference);
    assertNotNull(result);
    assertThat(result.get(0).getName(), is("NAME"));

  }

  @Test
  public void testSearchReferenceWithReferenceRepositoryShouldReturnListOfReferenceDtoOfThatEmployeeId() throws Exception {
    List<ReferenceDto> result = referenceRepository.searchReference(employee.getId());
    assertNotNull(result);
    assertThat(result.get(0).getName(), is("NAME"));
    assertThat(result.get(0).getApplicantId(), is(reference.getApplicant().getId()));

  }

  @Test
  public void testFindReferenceByIdWithReferenceRepositoryShouldReturnListOfReferenceDtoOfThatApplicantId() throws Exception {
    List<ReferenceDto> result = referenceRepository.findReferenceById(reference.getApplicant().getId());
    assertNotNull(result);
    assertThat(result.get(0).getName(), is("NAME"));
    assertThat(result.get(0).getOccupation(), is("OCCUPATION"));

  }

  @Test
  public void testFindReferenceWithReferenceRepositoryShouldReturnReferenceDtoOfThatReferenceId() throws Exception {
    ReferenceDto result = referenceRepository.findReference(reference.getId());
    assertNotNull(result);
    assertThat(result.getName(), is("NAME"));
    assertThat(result.getOccupation(), is("OCCUPATION"));

  }

}