/**
 *
 * @author Preeyaporn
 * @date 7 ก.ย. 2558
 */
package com.aug.hrdb.repositories;

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
public class AllowanceRepositoryTest {

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
	private AllowanceRepository allowanceRepository;

	@Autowired
	private  MasAllowanceRepository masAllowanceRepository;

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

		// create allowance
		MasAllowance masAllowance = new MasAllowance();
		masAllowance.setAuditFlag("C");
		masAllowance.setCreatedBy(1);
		masAllowance.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masAllowance.setIsactive(true);
		masAllowance.setAllowance_type("TypeA");
		masAllowance.setCode("A1");
		masAllowance.setAmount_allowance(5000.00);
		masAllowanceRepository.create(masAllowance);

		allowance = new Allowance();
		allowance.setAuditFlag("C");
		allowance.setCreatedBy(1);
		allowance.setCreatedTimeStamp(Calendar.getInstance().getTime());
		allowance.setAmount(masAllowance.getAmount_allowance());
		allowance.setEmployee(employee);
		allowance.setMasAllowance(masAllowance);
		allowanceRepository.create(allowance);

	}

	@Test
	public void testLoadRepositoriesShouldPass() throws Exception {
		assertNotNull(allowanceRepository);
		assertNotNull(masAllowanceRepository);
		assertNotNull(masCoreSkillRepository);
		assertNotNull(masJobLevelRepository);
		assertNotNull(masDivisionRepository);
		assertNotNull(masTechnologyRepository);
		assertNotNull(employeeRepository);
		assertNotNull(applicantRepository);

	}

	@Test
	public void testFindWithAllowanceRepositoryShouldReturnAllowanceThatSetup() throws Exception {
		Allowance result = allowanceRepository.find(allowance.getId());
		assertNotNull(result);
		assertThat(result.getEmployee().getEmployeeCode(), is("TEST0001"));
		assertThat(result.getMasAllowance().getCode(), is("A1"));

	}

	@Test
	public void testFindAllWithAllowanceRepositoryShouldReturnListOfAllowance() throws Exception {
		List<Allowance> result = allowanceRepository.findAll();
		assertNotNull(result);
		assertThat(result.size(), is(new GreaterOrEqual<>(1)));

	}

	@Test
	public void testUpdateWithAllowanceRepositoryShouldReturnAllowanceThatUpdate() throws Exception {
		Allowance update = allowanceRepository.find(allowance.getId());
		assertThat(update.getAmount(), is(5000.00));

		update.setAmount(10000.00);
		allowanceRepository.update(update);

		Allowance result = allowanceRepository.find(update.getId());
		assertNotNull(result);
		assertThat(result.getAmount(), is(10000.00));

	}

	@Test
	public void testDeleteWithAllowanceRepositoryShouldNotFindThatAllowance() throws Exception {
		Allowance delete = allowanceRepository.find(allowance.getId());
		allowanceRepository.delete(delete);

		Allowance result = allowanceRepository.find(delete.getId());
		assertNull(result);

	}

	@Test
	public void testDeleteByIdWithAllowanceRepositoryShouldNotFindThatAllowance() throws Exception {
		Allowance delete = allowanceRepository.find(allowance.getId());
		allowanceRepository.deleteById(delete.getId());

		Allowance result = allowanceRepository.find(delete.getId());
		assertNull(result);

	}

	@Test
	public void testSearchAllowanceWithAllowanceRepositoryShouldReturnListOfAllowance() throws Exception {
		List<AllowanceDto> result = allowanceRepository.searchAllowances(allowance.getEmployee().getId());
		assertNotNull(result);
		assertThat(result.size(), is(new GreaterOrEqual<>(1)));
		assertThat(result.get(0).getMasAllowance(), is(allowance.getMasAllowance().getAllowance_type()));

	}

}
