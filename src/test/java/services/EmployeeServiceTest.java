package services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
import com.aug.hrdb.entities.MasLocation;
import com.aug.hrdb.entities.MasTechnology;
import com.aug.hrdb.entities.Official;
import com.aug.hrdb.repositories.ApplicantRepository;
import com.aug.hrdb.repositories.EmployeeRepository;
import com.aug.hrdb.repositories.MasCoreSkillRepository;
import com.aug.hrdb.repositories.MasDivisionRepository;
import com.aug.hrdb.repositories.MasEmploymentRepository;
import com.aug.hrdb.repositories.MasJoblevelRepository;
import com.aug.hrdb.repositories.MasLocationRepository;
import com.aug.hrdb.repositories.MasStaffTypeRepository;
import com.aug.hrdb.repositories.MasTechnologyRepository;
import com.aug.hrdb.repositories.OfficialRepository;
import com.aug.hrdb.services.ApplicantService;
import com.aug.hrdb.services.EmployeeService;
import com.aug.hrdb.services.MasCoreSkillService;
import com.aug.hrdb.services.MasDivisionService;
import com.aug.hrdb.services.MasEmploymentService;
import com.aug.hrdb.services.MasJoblevelService;
import com.aug.hrdb.services.MasLocationService;
import com.aug.hrdb.services.MasStaffTypeService;
import com.aug.hrdb.services.MasTechnologyService;
import com.aug.hrdb.services.OfficialService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class EmployeeServiceTest {
	
	
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private ApplicantService applicantService;
	@Autowired
	private MasDivisionService masDivisionService;
	@Autowired
	private MasJoblevelService masJoblevelService;
	@Autowired
	private MasEmploymentService masEmploymentService;
	@Autowired
	private MasTechnologyService masTechnologyService;
	@Autowired
	private MasCoreSkillService masCoreSkillService;
	@Autowired
	private MasStaffTypeService masStaffTypeService;
	@Autowired
	private MasLocationService masLocationService;
	@Autowired
	private OfficialService officialService;
	
	
	
	private Employee employee;
	private Integer id;
	private Integer idApplicant;
    private Integer idMasJoblevel;
	private Integer idMasDivision;
	private Integer idMasLocation;
	private Integer idOfficial;
	
	
	
	@Before
    public void setUp() {
		
		
        employee = new Employee();
        employee.setIdCard("115310905001-9");
        employee.setNameThai("อภิวาท์");
        employee.setNameEng("apiva");
        employee.setNicknameThai("va");
        employee.setNicknameEng("va");
        employee.setSurnameThai("กิมเกถนอม");
        employee.setSurnameEng("kimkatanom");
        employee.setAge(25);
        employee.setHeight(165);
        employee.setWeigth(55);
        
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
        employee.setEmployeeCode("JP10019");
        employee.setStatusemp("Employee");
        employee.setTelHome("089-0851022");
        employee.setTelMobile("089-0851022");
        employee.setEmergencyContactPhoneNumber("089-085-1022");
        employee.setAuditFlag("C");
        employee.setCreatedBy(1);
        employee.setCreatedTimeStamp(Calendar.getInstance().getTime());
        employee.setStatusemp("Employee");
        employee.setAddress("1/1");
        

		MasJoblevel masJoblevel = new MasJoblevel();
		masJoblevel.setName("CEO");
		masJoblevel.setIsActive(true);
		masJoblevel.setCode("01");
		masJoblevel.setAuditFlag("C");
		masJoblevel.setCreatedBy(1);
		masJoblevel.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masJoblevel.setCode("Division-01");

		masJoblevelService.create(masJoblevel);
		idMasJoblevel = masJoblevel.getId();
		MasJoblevel masJobLevel1 = masJoblevelService.find(idMasJoblevel);
		
        
        MasTechnology masTechnology = new MasTechnology();
        masTechnology.setCode("MasTech-01");
        masTechnology.setCreatedBy(1);
        masTechnology.setCreatedTimeStamp(Calendar.getInstance().getTime());
        masTechnology.setAuditFlag("C");
        masTechnology.setIsActive(true);
        masTechnology.setName("MASTECH-01");
        masTechnologyService.create(masTechnology);
        int masTechId = masTechnology.getId();
        MasTechnology masTechnology2 = masTechnologyService.find(masTechId);
        
        
        Applicant applicant = new Applicant();
		applicant.setCreatedBy(1);
		applicant.setCreatedTimeStamp(Calendar.getInstance().getTime());
		applicant.setAuditFlag("C");
		applicant.setCardId("115310905001-9");
		applicant.setAuditFlag("1");
		applicant.setJoblevel(masJobLevel1);
		applicant.setTechnology(masTechnology2);
		applicantService.create(applicant);
		idApplicant = applicant.getId();
        Applicant applicant1 = applicantService.findById(idApplicant);
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
		
		masDivisionService.create(masDivision);
		idMasDivision = masDivision.getId();
		MasDivision masDivision1 = masDivisionService.findById(idMasDivision);
		employee.setMasDivision(masDivision1);
		

		employee.setMasJoblevel(masJobLevel1);
		
		
		

	    
	    MasLocation masLocation = new MasLocation();
	    masLocation.setIsActive(true);
	    masLocation.setAuditFlag("C");
	    masLocation.setCreatedBy(1);
	    masLocation.setCreatedTimeStamp(Calendar.getInstance().getTime());
	    masLocation.setName("MASLOCATION-TESTEMP");
	    masLocation.setCode("JP");
	    masLocationService.create(masLocation);
	    idMasLocation = masLocation.getId();	
	    MasLocation masLocation2 = masLocationService.find(idMasLocation);
	    
	    employee.setMasLocation(masLocation2);
	    
	    Official official = new Official();
	    official.setCreatedBy(1);
	    official.setCreatedTimeStamp(Calendar.getInstance().getTime());
	    official.setAuditFlag("C");
	    official.setOfficialDate(date);
	    officialService.create(official);
	    idOfficial = official.getId();
	    Official official2 = officialService.findById(idOfficial);
	    
	    employee.setOfficial(official2);
	 
		
		employeeService.create(employee);
		id=employee.getId();
		System.out.println("id: "+id);
    }


	
	
	 
	 
	@Test
	@Rollback(true)
	public void create() {
		
		
		Employee emp =  employeeService.findById(id);
		Assert.assertEquals("JP10019", emp.getEmployeeCode());
		
			
	}
	
	
	

	@Test
	@Rollback(true)
	public void update() {
	    
		System.out.println("id#: "+id);	 
		Employee employee1 = new Employee();
		employee1 = employeeService.findById(id);
		employee1.setUpdatedBy(1);
		employee1.setUpdatedTimeStamp(Calendar.getInstance().getTime());
		employee1.setAuditFlag("U");
		employee1.setEmployeeCode("JP10011");
		employeeService.update(employee1);
		
		Employee employee2 = new Employee();
		employee2 = employeeService.findById(id);
		
		Assert.assertEquals("JP10011", employee2.getEmployeeCode());
		
		

	}
	
	
	
	@Test
	@Rollback(true)
	public void delete() {

		Employee employee = employeeService.findById(id);
		employeeService.delete(employee);
		Employee employee2 = employeeService.findById(id);	
		Assert.assertNull(employee2);
		
		

	}
	
	
	
	
	@Test
	public void findById() {

		Employee employee = employeeService.findById(id);
		Assert.assertEquals("JP10019", employee.getEmployeeCode());
		
	}
	
	
	
	
	@Test
	public void findAll() {

		Employee employee = employeeService.findById(id);
		List<Employee> employeeList = employeeService.findAll();
		Assert.assertEquals(true, employeeList.contains(employee));		
		
	}
	
	
	
	
	@Test
	@Rollback(true)
	public void deleteById() {

		Employee employee = employeeService.findById(id);
		employeeService.deleteById(id);
		Employee emp = employeeService.findById(id);
		Assert.assertNull(emp);
		
		
	}
	
	
	

}
