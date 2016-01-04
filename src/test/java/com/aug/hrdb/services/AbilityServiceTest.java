/**
 *
 * @author Pranrajit
 * @date 4 ก.ย. 2558
 */
package com.aug.hrdb.services;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

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

import java.util.Calendar;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-bean-db-test.xml"})
@TransactionConfiguration
@Transactional
public class AbilityServiceTest {
	
	@Autowired
	private AbilityService abilityService;

	@Autowired
	private MasJobLevelService masJobLevelService;

	@Autowired
	private MasTechnologyService masTechnologyService;

	@Autowired
	private MasCoreSkillService masCoreSkillService;

	@Autowired
	private ApplicantService applicantService;

	@Autowired
	private MasSpecialtyService masSpecialtyService;

	private Applicant applicant;

	private Ability ability;

	private MasSpecialty spring, hibernate;

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

		applicant = new Applicant();
		applicant.setAuditFlag("C");
		applicant.setCreatedBy(1);
		applicant.setCreatedTimeStamp(Calendar.getInstance().getTime());
		applicant.setCoreSkill(masCoreSkillService.findById(masCoreSkill.getId()));
		applicant.setJoblevel(masJobLevelService.findById(masJobLevel.getId()));
		applicant.setTechnology(masTechnologyService.findById(masTechnology.getId()));
		applicantService.create(applicant);

		// create speciality
		hibernate = new MasSpecialty();
		hibernate.setAuditFlag("C");
		hibernate.setCreatedBy(1);
		hibernate.setCreatedTimeStamp(Calendar.getInstance().getTime());
		hibernate.setIsActive(true);
		hibernate.setCode("01");
		hibernate.setName("Hibernate");
		masSpecialtyService.create(hibernate);

		spring = new MasSpecialty();
		spring.setAuditFlag("C");
		spring.setCreatedBy(1);
		spring.setCreatedTimeStamp(Calendar.getInstance().getTime());
		spring.setIsActive(true);
		spring.setCode("01");
		spring.setName("Spring");
		masSpecialtyService.create(spring);

		//create ability
		ability = new Ability();
		ability.setAuditFlag("C");
		ability.setCreatedBy(1);
		ability.setCreatedTimeStamp(Calendar.getInstance().getTime());
		ability.setApplicant(applicant);
		ability.setMasspecialty(spring);
		ability.setRank(9);
		abilityService.create(ability);

	}

	@Test
	public void testLoadServiceShouldPass() throws Exception {
		assertNotNull(abilityService);
		assertNotNull(masJobLevelService);
		assertNotNull(masTechnologyService);
		assertNotNull(masCoreSkillService);
		assertNotNull(applicantService);
		assertNotNull(masSpecialtyService);

	}

	@Test
	public void testFindAbilityByAbilityServiceShouldReturnSetupAbility() throws Exception {
		Ability result = abilityService.find(ability.getId());
		assertThat(result.getApplicant(), is(applicant));
		assertThat(result.getMasspecialty(), is(spring));

	}

	@Test
	public void testFindAllAbilityWithAbilityRepositoryShouldReturnListOfAllAbility() throws Exception {
		List<Ability> abilities = abilityService.findAll();
		assertNotNull(abilities);

	}

	@Test
	public void testUpdateAbilityWithAbilityServiceShouldChangeSpringToHibernate() throws Exception {
		Ability update = abilityService.find(ability.getId());
		update.setMasspecialty(hibernate);
		abilityService.update(update);

		Ability result = abilityService.find(update.getId());
		assertThat(result.getMasspecialty(), is(hibernate));

	}

	@Test
	public void testDeleteAbilityWithAbilityServiceShouldNotFindDeletedAbility() throws Exception {
		Ability delete = abilityService.find(ability.getId());
		abilityService.delete(delete);

		Ability result = abilityService.find(delete.getId());
		assertNull(result);
	}

	@Test
	public void testDeleteAbilityByIdWithAbilityServiceShouldNotFindDeletedAbility() throws Exception {
		Ability delete = abilityService.find(ability.getId());
		abilityService.deleteById(delete.getId());

		Ability result = abilityService.find(delete.getId());
		assertNull(result);

	}

	@Test
	public void testSearchAbilityWithAbilityRepositoryShouldReturnListOfThatAbilityDto() throws Exception {
		List<AbilityDto> result = abilityService.searchAbility(applicant.getId());
		assertNotNull(result);
		assertThat(result.get(0).getMasspecialty(), is("Spring"));

	}

	@Test
	public void testFindAbilityByIdWithAbilityRepositoryShouldReturnThatAbilityDto() throws Exception {
		AbilityDto result = abilityService.findByAbilityId(ability.getId());
		assertThat(result.getMasspecialty(), is("Spring"));

	}

	@Test
	public void testCheckSpecialtyWithAbilityRepositoryShouldReturnBoolean() throws Exception {
		Boolean result = abilityService.checkSpecialty(applicant.getId(), spring.getId());
		assertThat(result, is(false));

	}

}
