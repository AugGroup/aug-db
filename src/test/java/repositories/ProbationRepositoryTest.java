package repositories;

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
import com.aug.hrdb.entities.MasJobLevel;
import com.aug.hrdb.entities.MasTechnology;
import com.aug.hrdb.entities.Probation;
import com.aug.hrdb.repositories.ApplicantRepository;
import com.aug.hrdb.repositories.EmployeeRepository;
import com.aug.hrdb.repositories.MasDivisionRepository;
import com.aug.hrdb.repositories.MasJoblevelRepository;
import com.aug.hrdb.repositories.MasTechnologyRepository;
import com.aug.hrdb.repositories.ProbationRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class ProbationRepositoryTest {
	
	@Autowired private ProbationRepository probationRepository;
	@Autowired private EmployeeRepository employeeRepository;
	@Autowired private ApplicantRepository applicantRepository;
	@Autowired private MasJoblevelRepository masJoblevelRepository;
	@Autowired private MasDivisionRepository masDivisionRepository;
	@Autowired private MasTechnologyRepository masTechnologyRepository;
	
	SimpleDateFormat dateFmt = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
	int id;
	
	@Before
	public void setProbation() throws ParseException{
		
		Employee employee = new Employee();
		/*employee.setIdCard("1103600695991");
        employee.setNameThai("จุฑามาศ");
        employee.setNameEng("Jutamas");
        employee.setNicknameThai("ป่าน");
        employee.setNicknameEng("Parn");
        employee.setSurnameThai("มณีอินทร์");
        employee.setSurnameEng("Maneeinr");
        employee.setDateOfBirth(dateFmt.parse("24/01/1992"));
        employee.setEmail("parn@gmail.com");
        employee.setEmergencyContact("Mom");*/
        employee.setEmployeeCode("EMP-19");
        employee.setStatusemp("Employee");
        employee.setTelHome("029314352");
       /* employee.setTelMobile("0817334542");
        employee.setEmergencyContactPhoneNumber("0817750936");*/
        employee.setAuditFlag("C");
        employee.setCreatedBy(1);
        employee.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
        Applicant applicant = new Applicant();
		applicant.setCreatedBy(1);
		applicant.setCreatedTimeStamp(Calendar.getInstance().getTime());
		applicant.setAuditFlag("C");
		applicant.setCardId("115310905001-9");
		
		Applicant app = applicantRepository.find(1);
	    Hibernate.initialize(app);
	    
	    MasJobLevel masJoblevel = new MasJobLevel();
		masJoblevel.setName("CEO");
		masJoblevel.setIsActive(true);
		masJoblevel.setCode("01");
		masJoblevel.setAuditFlag("C");
		masJoblevel.setCreatedBy(1);
		masJoblevel.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masJoblevel.setCode("Division-01");

		masJoblevelRepository.create(masJoblevel);
		masJoblevelRepository.find(1);
		
		applicant.setJoblevel(masJoblevel);
		//employee.setMasJoblevel(masJoblevel);
		
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
		
		masDivisionRepository.create(masDivision);
		masDivisionRepository.find(1);
		employee.setMasDivision(masDivision);
        
		
		employeeRepository.create(employee);
		
		Employee employee1 =  employeeRepository.find(1);
        
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
		probationRepository.create(probation);
		
		id=probation.getId();
	}
	
	@Test
	@Rollback(true)
	public void create() throws ParseException{
		//SimpleDateFormat dateFmt = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
		Employee employee = employeeRepository.find(1);
		
		Probation probation = new Probation();
		probation.setEmployee(employee);
		probation.setAuditFlag("C");
		probation.setCreatedBy(1);
		probation.setCreatedTimeStamp(Calendar.getInstance().getTime());
		probation.setDateFrom(dateFmt.parse("04/01/2015"));
		probation.setDateTo(dateFmt.parse("04/01/2015"));
		probation.setName("Jutamas");
		probation.setReason("Good");
		probation.setStatus("Pass");
		probationRepository.create(probation);
	}
	
	@Test
	@Rollback(true)
	public void findById(){
		//Probation probation = probationRepository.find(id);
		System.out.println("Find by id: "+probationRepository.find(id));
	}
	
	@Test
	@Rollback(true)
	public void update(){
		Probation probation = probationRepository.find(id);
		System.out.println("Old status: "+probation.getStatus());
		probation.setStatus("Not pass");
		probationRepository.update(probation);
		System.out.println("Update: "+probationRepository.find(id));
		System.out.println("New status: "+probation.getStatus());
	}
	
	
	@Test
	@Rollback(true)
	public void findAll(){	
		List<Probation> probations = probationRepository.findAll();
		Assert.assertEquals(3, probations.size());
		System.out.println("Size: "+probations.size());
	}
	
	@Test
	@Rollback(true)
	public void delete(){
		probationRepository.deleteById(id);
		System.out.println("Delete: "+id);
	}
}
