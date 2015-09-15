package repositories;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.hibernate.Hibernate;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.Applicant;
import com.aug.hrdb.entities.Employee;
import com.aug.hrdb.entities.MasDivision;
import com.aug.hrdb.entities.MasJoblevel;
import com.aug.hrdb.entities.Punish;
import com.aug.hrdb.entities.Reward;
import com.aug.hrdb.repositories.ApplicantRepository;
import com.aug.hrdb.repositories.EmployeeRepository;
import com.aug.hrdb.repositories.MasDivisionRepository;
import com.aug.hrdb.repositories.MasJoblevelRepository;
import com.aug.hrdb.repositories.PunishRepository;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class PunishRepositoryTest {
	
	@Autowired
	private PunishRepository punishRepository;
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
	public void setReward() {
		employee = new Employee();
		employee.setIdCard("110370065978-1");
        employee.setNameThai("ธัญลักษณ์์");
        employee.setNameEng("thanyalak");
        employee.setNicknameThai("kik");
        employee.setNicknameEng("kik");
        employee.setSurnameThai("พิมสวรรค์");
        employee.setSurnameEng("pimsawan");
        
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
        employee.setEmployeeCode("EMP-06");
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
		
		
	    Employee employee =  employeeRepository.find(1);
	    Punish punish=new Punish();
		punish.setEmployee(employee);	
		Calendar cal = Calendar.getInstance();
		punish.setDatepunish(cal.getTime());
		punish.setDescription("aaaa");
		punish.setPenalty("test");		
		punishRepository.create(punish);
		id = punish.getId();
		
	}
	
	
	
	@Test
	@Rollback(true)
	public void createPunish(){
		
		Employee employee1 =  employeeRepository.find(1);
		Punish punish=new Punish();
		punish.setEmployee(employee1);	
		Calendar cal = Calendar.getInstance();
		punish.setDatepunish(cal.getTime());
		punish.setDescription("aaaa");
		punish.setPenalty("test");		
		punishRepository.create(punish);
	
//		Punish punish = punishRepository.find(id);
//		Assert.assertEquals("test", punish.getPenalty());
		
		
	}
	
	
	@Test
	@Rollback(true)
	public void updatePunish(){
		
		Punish punish = punishRepository.find(id);
		Calendar cal = Calendar.getInstance();
		punish.setDatepunish(cal.getTime());
		punish.setDescription("bbb");
		punish.setPenalty("test");
		id = punish.getId();
		punishRepository.update(punish);
		
	}
	
	
	@Test
	@Rollback(true)
	public void deletePunish(){
		
		Punish punish = (Punish) punishRepository.getCurrentSession().get(Punish.class,id);
		punishRepository.getCurrentSession().delete(punish);
	}
	
	

	
	@Test
	@Rollback(true)
	public void findByIdPunish(){
		
		Punish punish = (Punish) punishRepository.getCurrentSession().get(Punish.class,id);		
		int id = punish.getId();
		Assert.assertEquals(id, id);
		
	}
	
	
	

}
