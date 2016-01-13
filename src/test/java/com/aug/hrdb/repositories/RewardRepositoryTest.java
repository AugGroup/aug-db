package com.aug.hrdb.repositories;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import com.aug.hrdb.dto.RewardDto;
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
public class RewardRepositoryTest {

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
  private RewardRepository rewardRepository;

  private Reward reward;

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

    // create reward
    reward = new Reward();
    reward.setAuditFlag("C");
    reward.setCreatedBy(1);
    reward.setCreatedTimeStamp(Calendar.getInstance().getTime());
    reward.setTypeReward("TYPE");
    reward.setName("NAME");
    reward.setYear("1992");
    reward.setEmployee(employee);
    rewardRepository.create(reward);

  }

  @Test
  public void testLoadRepositoriesShouldPass() throws Exception {
    assertNotNull(rewardRepository);
    assertNotNull(masCoreSkillRepository);
    assertNotNull(masJobLevelRepository);
    assertNotNull(masDivisionRepository);
    assertNotNull(masTechnologyRepository);
    assertNotNull(employeeRepository);
    assertNotNull(applicantRepository);

  }

  @Test
  public void testFindWithRewardRepositoryShouldReturnRewardThatSetup() throws Exception {
    Reward result = rewardRepository.find(reward.getId());
    assertNotNull(result);
    assertThat(result.getEmployee().getApplicant().getFirstNameEN(), is("Anat"));
    assertThat(result.getTypeReward(), is("TYPE"));
    assertThat(result.getName(), is("NAME"));
    assertThat(result.getYear(), is("1992"));

  }

  @Test
  public void testFindAllWithRewardRepositoryShouldReturnListOfAllReward() throws Exception {
    List<Reward> result = rewardRepository.findAll();
    assertNotNull(result);
    assertThat(result.size(), is(new GreaterOrEqual<>(1)));

  }

  @Test
  public void testUpdateWithRewardRepositoryShouldReturnRewardThatUpdate() throws Exception {
    Reward update = rewardRepository.find(reward.getId());
    assertThat(update.getEmployee().getApplicant().getFirstNameEN(), is("Anat"));
    assertThat(update.getTypeReward(), is("TYPE"));

    update.setTypeReward("UPDATE TYPE");
    rewardRepository.update(update);

    Reward result = rewardRepository.find(update.getId());
    assertThat(result.getTypeReward(), is("UPDATE TYPE"));

  }

  @Test
  public void testDeleteWithRewardRepositoryShouldNotFindThatReward() throws Exception {
    Reward delete = rewardRepository.find(reward.getId());
    rewardRepository.delete(delete);

    Reward result = rewardRepository.find(delete.getId());
    assertNull(result);

  }

  @Test
  public void testDeleteByIdWithRewardRepositoryShouldNotFindThatReward() throws Exception {
    Reward delete = rewardRepository.find(reward.getId());
    rewardRepository.deleteById(delete.getId());

    Reward result = rewardRepository.find(delete.getId());
    assertNull(result);

  }

  @Test
  public void testFindByCriteriaWithRewardRepositoryShouldReturnListOfRewardOfThatName() throws Exception {
    List<Reward> result = rewardRepository.findByCriteria(reward);
    assertNotNull(result);
    assertThat(result.get(0).getName(), is("NAME"));

  }

  @Test
  public void testSearchRewardWithRewardRepositoryShouldReturnListOfRewardDtoOfThatEmployeeId() throws Exception {
    List<RewardDto> result = rewardRepository.searchReward(reward.getEmployee().getId());
    assertNotNull(result);
    assertThat(result.get(0).getYear(), is("1992"));
    assertThat(result.get(0).getTypeReward(), is("TYPE"));

  }

}