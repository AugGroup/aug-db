/**
 * @author Pranrajit
 * @date 4 ก.ย. 2558
 */
package com.aug.hrdb.repositories;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;

import com.aug.hrdb.dto.AbilityDto;
import com.aug.hrdb.entities.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-bean-db-test.xml"})
@TransactionConfiguration
@Transactional
public class AbilityRepositoryTest {

  @Autowired
  private AbilityRepository abilityRepository;

  @Autowired
  private MasJobLevelRepository masJoblevelRepository;

  @Autowired
  private MasTechnologyRepository masTechnologyRepository;

  @Autowired
  private MasCoreSkillRepository masCoreSkillRepository;

  @Autowired
  private ApplicantRepository applicantRepository;

  @Autowired
  private MasSpecialtyRepository masSpecialtyRepository;

  private Ability ability;

  private Applicant applicant;

  private MasSpecialty hibernate, spring;

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
    masJoblevelRepository.create(masJobLevel);

    MasTechnology masTechnology = new MasTechnology();
    masTechnology.setAuditFlag("C");
    masTechnology.setCreatedBy(1);
    masTechnology.setCreatedTimeStamp(Calendar.getInstance().getTime());
    masTechnology.setIsActive(true);
    masTechnology.setCode("1");
    masTechnology.setName("Java");
    masTechnologyRepository.create(masTechnology);

    applicant = new Applicant();
    applicant.setAuditFlag("C");
    applicant.setCreatedBy(1);
    applicant.setCreatedTimeStamp(Calendar.getInstance().getTime());
    applicant.setCoreSkill(masCoreSkillRepository.find(masCoreSkill.getId()));
    applicant.setJoblevel(masJoblevelRepository.find(masJobLevel.getId()));
    applicant.setTechnology(masTechnologyRepository.find(masTechnology.getId()));
    applicantRepository.create(applicant);

    // create speciality
    hibernate = new MasSpecialty();
    hibernate.setAuditFlag("C");
    hibernate.setCreatedBy(1);
    hibernate.setCreatedTimeStamp(Calendar.getInstance().getTime());
    hibernate.setIsActive(true);
    hibernate.setCode("01");
    hibernate.setName("Hibernate");
    masSpecialtyRepository.create(hibernate);

    spring = new MasSpecialty();
    spring.setAuditFlag("C");
    spring.setCreatedBy(1);
    spring.setCreatedTimeStamp(Calendar.getInstance().getTime());
    spring.setIsActive(true);
    spring.setCode("01");
    spring.setName("Spring");
    masSpecialtyRepository.create(spring);

    //create ability
    ability = new Ability();
    ability.setAuditFlag("C");
    ability.setCreatedBy(1);
    ability.setCreatedTimeStamp(Calendar.getInstance().getTime());
    ability.setApplicant(applicant);
    ability.setMasspecialty(spring);
    ability.setRank(9);
    abilityRepository.create(ability);

  }

  @Test
  public void testLoadRepositoryShouldPass() throws Exception {
    assertNotNull(applicantRepository);
    assertNotNull(abilityRepository);
    assertNotNull(masSpecialtyRepository);
    assertNotNull(masJoblevelRepository);
    assertNotNull(masTechnologyRepository);

  }

  @Test
  public void testFindAbilityWithAbilityRepositoryShouldPass() throws Exception {
    Ability result = abilityRepository.find(ability.getId());
    assertEquals(result.getApplicant(), ability.getApplicant());

  }

  @Test
  public void testFindAllAbilityWithAbilityRepositorySholdReturnListOfAllAbility() throws Exception {
    List<Ability> abilities = abilityRepository.findAll();
    assertNotNull(abilities);

  }

  @Test
  public void testUpdateAbilityWithAbilityRepositoryShouldChangeSpringToHibernate() throws Exception {
    Ability update = abilityRepository.find(ability.getId());
    update.setMasspecialty(hibernate);
    abilityRepository.update(update);

    Ability result = abilityRepository.find(update.getId());
    assertThat(result.getMasspecialty().getName(), is("Hibernate"));

  }

  @Test
  public void testDeleteAbilityWithAbilityRepositoryShouldNotFindThatAbilityAfterDelete() throws Exception {
    Ability delete = abilityRepository.find(ability.getId());
    abilityRepository.delete(delete);

    Ability result = abilityRepository.find(delete.getId());
    assertNull(result);

  }

  @Test
  public void testDeleteAbilityByIdWithAbilityRepositoryShouldNotFindThatAbilityAfterDelete() throws Exception {
    Ability delete = abilityRepository.find(ability.getId());
    abilityRepository.deleteById(delete.getId());

    Ability result = abilityRepository.find(delete.getId());
    assertNull(result);

  }

  @Test
  public void testSearchAbilityWithAbilityRepositoryShouldReturnListOfThatAbilityDto() throws Exception {
    List<AbilityDto> result = abilityRepository.searchAbility(applicant.getId());
    assertNotNull(result);
    assertThat(result.get(0).getMasspecialty(), is("Spring"));

  }

  @Test
  public void testFindAbilityByIdWithAbilityRepositoryShouldReturnThatAbilityDto() throws Exception {
    AbilityDto result = abilityRepository.findByAbilityId(ability.getId());
    assertThat(result.getMasspecialty(), is("Spring"));

  }

  @Test
  public void testCheckSpecialtyWithAbilityRepositoryShouldReturnBoolean() throws Exception {
    Boolean result = abilityRepository.checkSpecialty(applicant.getId(), spring.getId());
    assertThat(result, is(false));

  }

}