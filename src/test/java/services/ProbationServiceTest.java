package services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import org.hibernate.Hibernate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.Applicant;
import com.aug.hrdb.entities.Employee;
import com.aug.hrdb.entities.MasDivision;
import com.aug.hrdb.entities.MasJoblevel;
import com.aug.hrdb.entities.MasTechnology;
import com.aug.hrdb.entities.Probation;
import com.aug.hrdb.repositories.MasTechnologyRepository;
import com.aug.hrdb.services.ApplicantService;
import com.aug.hrdb.services.EmployeeService;
import com.aug.hrdb.services.MasDivisionService;
import com.aug.hrdb.services.MasJoblevelService;
import com.aug.hrdb.services.MasSpecialtyService;
import com.aug.hrdb.services.ProbationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class ProbationServiceTest {

	@Autowired private ProbationService probationService;
	@Autowired private EmployeeService employeeService;
	@Autowired private MasSpecialtyService masSpecialtyService;	
	@Autowired private MasJoblevelService masJoblevelService;
	@Autowired private ApplicantService applicantService;
	@Autowired private MasDivisionService masDivisionService;
	@Autowired private MasTechnologyRepository masTechnologyRepository;
	
	SimpleDateFormat dateFmt = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
	int id;
	
	@Before
	public void setProbation() throws ParseException{
		
		Employee employee = new Employee();
		employee.setIdCard("1103600695991");
        employee.setNameThai("จุฑามาศ");
        employee.setNameEng("Jutamas");
        employee.setNicknameThai("ป่าน");
        employee.setNicknameEng("Parn");
        employee.setSurnameThai("มณีอินทร์");
        employee.setSurnameEng("Maneeinr");
        employee.setDateOfBirth(dateFmt.parse("24/01/1992"));
        employee.setEmail("parn@gmail.com");
        employee.setEmergencyContact("Mom");
        employee.setEmployeeCode("EMP-19");
        employee.setStatusemp("Employee");
        employee.setTelHome("029314352");
        employee.setTelMobile("0817334542");
        employee.setEmergencyContactPhoneNumber("0817750936");
        employee.setAuditFlag("C");
        employee.setCreatedBy(1);
        employee.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
        Applicant applicant = new Applicant();
		applicant.setCreatedBy(1);
		applicant.setCreatedTimeStamp(Calendar.getInstance().getTime());
		applicant.setAuditFlag("C");
		applicant.setCardId("115310905001-9");
		
		Applicant app = applicantService.findById(1);
	    Hibernate.initialize(app);
	    
		MasJoblevel masJoblevel = new MasJoblevel();
		masJoblevel.setName("CEO");
		masJoblevel.setIsActive(true);
		masJoblevel.setCode("01");
		masJoblevel.setAuditFlag("C");
		masJoblevel.setCreatedBy(1);
		masJoblevel.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masJoblevel.setCode("Division-01");

		masJoblevelService.create(masJoblevel);
		masJoblevelService.find(1);
		
		employee.setMasJoblevel(masJoblevel);
	    
	    MasTechnology masTech = new MasTechnology();
		masTech.setName("Java");
		masTech.setCode("001A");
		masTech.setIsActive(true);
		masTech.setAuditFlag("C");
		masTech.setCreatedBy(0);
		Calendar cal = Calendar.getInstance();
		masTech.setCreatedTimeStamp(cal.getTime());
		masTechnologyRepository.create(masTech);
		applicant.setTechnology(masTech);
	    
	    employee.setApplicant(app);
		
        MasDivision masDivision = new MasDivision();
		masDivision.setName("CEO");
		masDivision.setIsActive(true);
		masDivision.setCode("01");
		masDivision.setAuditFlag("C");
		masDivision.setCreatedBy(1);
		masDivision.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masDivision.setCode("Division-01");		
		masDivisionService.create(masDivision);
		masDivisionService.findById(1);
		employee.setMasDivision(masDivision);
        
		employeeService.create(employee);
		
		Employee employee1 =  employeeService.findById(1);
        
		Probation probation = new Probation();
		probation.setAuditFlag("C");
		probation.setCreatedBy(1);
		probation.setCreatedTimeStamp(Calendar.getInstance().getTime());
		probation.setDateFrom(dateFmt.parse("04/01/2015"));
		probation.setDateTo(dateFmt.parse("04/01/2015"));
		probation.setName("Jutamas");
		probation.setReason("Good");
		probation.setStatus("Pass");
		probation.setEmployee(employee1);
		probationService.create(probation);
		
		id=probation.getId();
	}
	
	@Test
	@Rollback(true)
	public void create() throws ParseException{
		//SimpleDateFormat dateFmt = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
		Probation probation = new Probation();
		probation.setAuditFlag("C");
		probation.setCreatedBy(1);
		probation.setCreatedTimeStamp(Calendar.getInstance().getTime());
		probation.setDateFrom(dateFmt.parse("04/01/2015"));
		probation.setDateTo(dateFmt.parse("04/01/2015"));
		probation.setReason("Good");
		probation.setStatus("Pass");
		probation.setEmployee(employeeService.findById(1));
		probationService.create(probation);
	}
	
	@Test
	@Rollback(true)
	public void update(){
		Probation probation = probationService.find(id);
		probation.setStatus("Not Pass");
		probationService.update(probation);
	}
	
	
	@Test
	@Rollback(true)
	public void findById(){
		Probation probation = probationService.find(id);
		int idPro = probation.getId();
		Assert.assertEquals(id,idPro);
	}
	
	@Test
	@Rollback(true)
	public void delete(){
		Probation probation = probationService.find(id);
		probationService.delete(probation);
	}
	
	@Test
	public void findAll(){	
		List<Probation> probations = probationService.findAll();
		Assert.assertEquals(3, probations.size());
	}
	
	
	
}
