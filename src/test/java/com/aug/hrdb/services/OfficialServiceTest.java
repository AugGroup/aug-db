/**
 *
 * @author natechanok
 * @date Sep 4, 2015
 */
package com.aug.hrdb.services;

import java.util.Calendar;
import java.util.Date;
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

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-bean-db-test.xml"})
@TransactionConfiguration
@Transactional
public class OfficialServiceTest {

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
	private OfficialService officialService;

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
		applicant.setEmployedPosition("Java Consultant");
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
		officialService.create(official);

		// update official for applicant
		applicant.setOfficial(official);
		applicantService.update(applicant);

	}

	@Test
	public void testLoadServicesShouldPass() throws Exception {
		assertNotNull(masCoreSkillService);
		assertNotNull(masJobLevelService);
		assertNotNull(masDivisionService);
		assertNotNull(masTechnologyService);
		assertNotNull(employeeService);
		assertNotNull(applicantService);
		assertNotNull(officialService);

	}

	@Test
	public void testFindWithOfficialServiceShouldReturnOfficialThatSetup() throws Exception {
		Official result = officialService.findById(official.getId());
		assertNotNull(result);
		assertThat(result.getApplicant().getFirstNameEN(), is("Anat"));
		assertThat(result.getStartWorkDate(), is(start));
		assertThat(result.getProbationDate(), is(probation));

	}

	@Test
	public void testFindAllWithOfficialServiceShouldReturnListOfAllOfficial() throws Exception {
		List<Official> result = officialService.findAll();
		assertNotNull(result);
		assertThat(result.size(), is(new GreaterOrEqual<>(1)));

	}

	@Test
	public void testUpdateWithOfficialServiceShouldReturnOfficialThatUpdate() throws Exception {
		Official update = officialService.findById(official.getId());
		assertThat(update.getStartWorkDate(), is(start));
		assertThat(update.getProbationDate(), is(probation));

		Date updateDate = Calendar.getInstance().getTime();
		update.setProbationDate(updateDate);
		officialService.update(update);

		Official result = officialService.findById(update.getId());
		assertThat(result.getProbationDate(), is(updateDate));

	}

	@Test
	public void testDeleteWithOfficialServiceShouldNotFindThatOfficial() throws Exception {
		Official delete = officialService.findById(official.getId());
		officialService.delete(delete);

		Official result = officialService.findById(delete.getId());
		assertNull(result);

	}

	@Test
	public void testDeleteByIdWithOfficialServiceShouldNotFindThatOfficial() throws Exception {
		Official delete = officialService.findById(official.getId());
		officialService.deleteById(delete.getId());

		Official result = officialService.findById(delete.getId());
		assertNull(result);

	}

	@Test
	public void testFindByCriteriaWithOfficialServiceShouldReturnListOfOfficialOfThatEmployedPosition() throws Exception {
		List<Official> result = officialService.findByCriteria(official.getApplicant());
		assertNotNull(result);
		assertThat(result.get(0).getApplicant().getEmployedPosition(), is("Java Consultant"));

	}

	@Test
	public void testSearchEmpIdToOfficialWithOfficialServiceShouldReturnLastOfficial() throws Exception {
		Official result = officialService.searchEmpIdToOfficial();
		assertNotNull(result);
		assertThat(result.getStartWorkDate(), is(start));
		assertThat(result.getProbationDate(), is(probation));

	}

	//  wait clear
//  @Test
//  public void testSaveOfficialByNameQueryWithOfficialServiceShouldPass() throws Exception {
//
//  }

//  wait clear
//  @Test
//  public void testUpdateOfficialByNameQueryWithOfficialServiceShouldPass() throws Exception {
//
//  }

}