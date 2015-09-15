package repositories;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
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
import com.aug.hrdb.entities.Login;
import com.aug.hrdb.entities.MasDivision;
import com.aug.hrdb.entities.MasJoblevel;
import com.aug.hrdb.entities.Reward;
import com.aug.hrdb.repositories.ApplicantRepository;
import com.aug.hrdb.repositories.EmployeeRepository;
import com.aug.hrdb.repositories.LoginRepository;
import com.aug.hrdb.repositories.MasDivisionRepository;
import com.aug.hrdb.repositories.MasJoblevelRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class LoginRepositoryTest {
	
	@Autowired
	private LoginRepository loginRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private MasJoblevelRepository masJoblevelRepository;
	@Autowired
	private ApplicantRepository applicantRepository;
	@Autowired
	private MasDivisionRepository masDivisionRepository;
	private Employee employee1;
	private Employee employee;
	private int id;
	
	
	
	@Before
	public void setLogin() {
		employee = new Employee();
        employee.setIdCard("115310905001-9");
        employee.setNameThai("ธัญลักษณ์์");
        employee.setNameEng("thanyalak");
        employee.setNicknameThai("กิ๊ก");
        employee.setNicknameEng("kik");
        employee.setSurnameThai("พิมสวรรค์");
        employee.setSurnameEng("Pimsawan");
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    	String dateInString = "31-08-1982";
    	Date date = null;
		try {
			date = sdf.parse(dateInString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        
		employee.setDateOfBirth(date);
        employee.setEmail("test@gmail.com");
        employee.setEmergencyContact("mom");
        employee.setEmployeeCode("EMP-09");
        employee.setStatusemp("Employee");
        employee.setTelHome("089-0851022");
        employee.setTelMobile("089-0851022");
        employee.setEmergencyContactPhoneNumber("089-085-1022");
        employee.setAuditFlag("C");
        employee.setCreatedBy(1);
        employee.setCreatedTimeStamp(Calendar.getInstance().getTime());
        
        Applicant applicant = new Applicant();
		applicant.setCreatedBy(1);
		applicant.setCreatedTimeStamp(Calendar.getInstance().getTime());
		applicant.setAuditFlag("C");
		applicant.setCardId("115310905001-9");
//		applicant.setAuditFlag("1");
		applicantRepository.create(applicant);
		
        Applicant applicant1 = applicantRepository.find(1);
        Hibernate.initialize(applicant1);
        
        
        employee.setApplicant(applicant1);
         

	
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
		

		MasJoblevel masJoblevel = new MasJoblevel();
		masJoblevel.setName("CEO");
		masJoblevel.setIsActive(true);
		masJoblevel.setCode("01");
		masJoblevel.setAuditFlag("C");
		masJoblevel.setCreatedBy(1);
		masJoblevel.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masJoblevel.setCode("Division-01");

		masJoblevelRepository.create(masJoblevel);
		masJoblevelRepository.find(1);
		
		employee.setMasJoblevel(masJoblevel);
		
		
		employeeRepository.create(employee);
		
		
	    employee1 =  employeeRepository.find(1);
	    Login login=new Login();
	    login.setEmployee(employee1);     	
	    login.setUsername("Kik");
		login.setPassword("admin");	
		Calendar cal = Calendar.getInstance();
		login.setAuditFlag("C");
		login.setCreatedBy(0);
		login.setCreatedTimeStamp(cal.getTime());
		loginRepository.create(login);
		id = login.getId();
		
	}
	
	
	
	@Test
	@Rollback(true)
	public void createLogin(){
		
		Employee employee1 =  employeeRepository.find(1);
		Login login =new Login();	
		employee1.setId(9);
		login.setEmployee(employee1);		
		login.setUsername("Kik");
		login.setPassword("admin");	
		Calendar cal = Calendar.getInstance();
		login.setAuditFlag("C");
		login.setCreatedBy(0);
		login.setCreatedTimeStamp(cal.getTime());
		loginRepository.getCurrentSession().save(login);
	}
	
	
	@Test
	@Rollback(true)
	public void updateLogin(){
		
		
		Login login = (Login)loginRepository.find(id);
		login.setUsername("Kik");
		login.setPassword("admin");
		loginRepository.update(login);
	}


	@Test
	@Rollback(true)
	public void deleteLogin(){
		
		Login login = (Login) loginRepository.getCurrentSession().get(Login.class,id);
		loginRepository.getCurrentSession().delete(login);
	}
	
	
	
}
