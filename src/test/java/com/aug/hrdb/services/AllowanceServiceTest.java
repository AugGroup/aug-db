/**
 *
 * @author Preeyaporn
 * @date 7 ก.ย. 2558
 */
package com.aug.hrdb.services;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;

import com.aug.hrdb.dto.AllowanceDto;
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
public class AllowanceServiceTest {

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
	private AllowanceService allowanceService;

	@Autowired
	private  MasAllowanceService masAllowanceService;

	private Allowance allowance;

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

		// create allowance
		MasAllowance masAllowance = new MasAllowance();
		masAllowance.setAuditFlag("C");
		masAllowance.setCreatedBy(1);
		masAllowance.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masAllowance.setIsactive(true);
		masAllowance.setAllowance_type("TypeA");
		masAllowance.setCode("A1");
		masAllowance.setAmount_allowance(5000.00);
		masAllowanceService.create(masAllowance);

		allowance = new Allowance();
		allowance.setAuditFlag("C");
		allowance.setCreatedBy(1);
		allowance.setCreatedTimeStamp(Calendar.getInstance().getTime());
		allowance.setAmount(masAllowance.getAmount_allowance());
		allowance.setEmployee(employee);
		allowance.setMasAllowance(masAllowance);
		allowanceService.create(allowance);

	}

	@Test
	public void testLoadRepositoriesShouldPass() throws Exception {
		assertNotNull(allowanceService);
		assertNotNull(masAllowanceService);
		assertNotNull(masCoreSkillService);
		assertNotNull(masJobLevelService);
		assertNotNull(masDivisionService);
		assertNotNull(masTechnologyService);
		assertNotNull(employeeService);
		assertNotNull(applicantService);

	}

	@Test
	public void testFindWithAllowanceServiceShouldReturnAllowanceThatSetup() throws Exception {
		Allowance result = allowanceService.findById(allowance.getId());
		assertNotNull(result);
		assertThat(result.getEmployee().getEmployeeCode(), is("TEST0001"));
		assertThat(result.getMasAllowance().getCode(), is("A1"));

	}

	@Test
	public void testFindAllWithAllowanceServiceShouldReturnListOfAllowance() throws Exception {
		List<Allowance> result = allowanceService.findAll();
		assertNotNull(result);
		assertThat(result.size(), is(new GreaterOrEqual<>(1)));

	}

	@Test
	public void testUpdateWithAllowanceServiceShouldReturnAllowanceThatUpdate() throws Exception {
		Allowance update = allowanceService.findById(allowance.getId());
		assertThat(update.getAmount(), is(5000.00));

		update.setAmount(10000.00);
		allowanceService.update(update);

		Allowance result = allowanceService.findById(update.getId());
		assertNotNull(result);
		assertThat(result.getAmount(), is(10000.00));

	}

	@Test
	public void testDeleteWithAllowanceServiceShouldNotFindThatAllowance() throws Exception {
		Allowance delete = allowanceService.findById(allowance.getId());
		allowanceService.delete(delete);

		Allowance result = allowanceService.findById(delete.getId());
		assertNull(result);

	}

	@Test
	public void testDeleteByIdWithAllowanceServiceShouldNotFindThatAllowance() throws Exception {
		Allowance delete = allowanceService.findById(allowance.getId());
		allowanceService.deleteById(delete.getId());

		Allowance result = allowanceService.findById(delete.getId());
		assertNull(result);

	}

	@Test
	public void testSearchAllowanceWithAllowanceServiceShouldReturnListOfAllowance() throws Exception {
		List<AllowanceDto> result = allowanceService.searchAllowances(allowance.getEmployee().getId());
		assertNotNull(result);
		assertThat(result.size(), is(new GreaterOrEqual<>(1)));
		assertThat(result.get(0).getMasAllowance(), is(allowance.getMasAllowance().getAllowance_type()));

	}

}
