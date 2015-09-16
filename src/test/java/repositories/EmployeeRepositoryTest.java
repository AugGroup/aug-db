package repositories;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.dto.AddressDto;
import com.aug.hrdb.dto.EmployeeCodeDto;
import com.aug.hrdb.dto.EmployeeDto;
import com.aug.hrdb.dto.EmployeeIdDto;
import com.aug.hrdb.dto.ReportEmployeeDto;
import com.aug.hrdb.entities.Applicant;
import com.aug.hrdb.entities.Employee;
import com.aug.hrdb.entities.MasCoreSkill;
import com.aug.hrdb.entities.MasDivision;
import com.aug.hrdb.entities.MasEmployment;
import com.aug.hrdb.entities.MasJoblevel;
import com.aug.hrdb.entities.MasLocation;
import com.aug.hrdb.entities.MasStaffType;
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



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class EmployeeRepositoryTest {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private ApplicantRepository applicantRepository;
	@Autowired
	private MasDivisionRepository masDivisionRepository;
	@Autowired
	private MasJoblevelRepository masJoblevelRepository;
	@Autowired
	private MasEmploymentRepository masEmploymentRepository;
	@Autowired
	private MasTechnologyRepository masTechnologyRepository;
	@Autowired
	private MasCoreSkillRepository masCoreSkillRepository;
	@Autowired
	private MasStaffTypeRepository masStaffTypeRepository;
	@Autowired
	private MasLocationRepository masLocationRepository;
	@Autowired
	private OfficialRepository officialRepository;
	
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
        employee.setEmployeeCode("JP10017");
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

		masJoblevelRepository.create(masJoblevel);
		idMasJoblevel = masJoblevel.getId();
		MasJoblevel masJobLevel1 = masJoblevelRepository.find(idMasJoblevel);
		
        
        MasTechnology masTechnology = new MasTechnology();
        masTechnology.setCode("MasTech-01");
        masTechnology.setCreatedBy(1);
        masTechnology.setCreatedTimeStamp(Calendar.getInstance().getTime());
        masTechnology.setAuditFlag("C");
        masTechnology.setIsActive(true);
        masTechnology.setName("MASTECH-01");
        masTechnologyRepository.create(masTechnology);
        int masTechId = masTechnology.getId();
        MasTechnology masTechnology2 = masTechnologyRepository.find(masTechId);
        
        
        Applicant applicant = new Applicant();
		applicant.setCreatedBy(1);
		applicant.setCreatedTimeStamp(Calendar.getInstance().getTime());
		applicant.setAuditFlag("C");
		applicant.setCardId("115310905001-9");
		applicant.setAuditFlag("1");
		applicant.setJoblevel(masJobLevel1);
		applicant.setTechnology(masTechnology2);
		applicantRepository.create(applicant);
		idApplicant = applicant.getId();
        Applicant applicant1 = applicantRepository.find(idApplicant);
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
		idMasDivision = masDivision.getId();
		MasDivision masDivision1 = masDivisionRepository.find(idMasDivision);
		employee.setMasDivision(masDivision1);
		

		employee.setMasJoblevel(masJobLevel1);
		
		
		

	    
	    MasLocation masLocation = new MasLocation();
	    masLocation.setIsActive(true);
	    masLocation.setAuditFlag("C");
	    masLocation.setCreatedBy(1);
	    masLocation.setCreatedTimeStamp(Calendar.getInstance().getTime());
	    masLocation.setName("MASLOCATION-TESTEMP");
	    masLocation.setCode("JP");
	    masLocationRepository.create(masLocation);
	    idMasLocation = masLocation.getId();	
	    MasLocation masLocation2 = masLocationRepository.find(idMasLocation);
	    
	    employee.setMasLocation(masLocation2);
	    
	    Official official = new Official();
	    official.setCreatedBy(1);
	    official.setCreatedTimeStamp(Calendar.getInstance().getTime());
	    official.setAuditFlag("C");
	    official.setOfficialDate(date);
	    officialRepository.create(official);
	    idOfficial = official.getId();
	    Official official2 = officialRepository.find(idOfficial);
	    
	    employee.setOfficial(official2);
	 
		
		employeeRepository.create(employee);
		id=employee.getId();
		System.out.println("id: "+id);
    }


	
	
	 
	 
	@Test
	@Rollback(true)
	public void create() {
		
		
		Employee emp =  employeeRepository.find(id);
		Assert.assertEquals("อภิวาท์", emp.getNameThai());
		
			
	}
	
	
	
	
	@Test
	@Rollback(true)
	public void update() {
	    
		System.out.println("id#: "+id);	 
		Employee employee1 = new Employee();
		employee1 = employeeRepository.find(id);
		employee1.setUpdatedBy(1);
		employee1.setUpdatedTimeStamp(Calendar.getInstance().getTime());
		employee1.setAuditFlag("U");
		employee1.setNameThai("เทส");
		employeeRepository.update(employee1);
		
		Employee employee2 = new Employee();
		employee2 = employeeRepository.find(id);
		
		Assert.assertEquals("เทส", employee2.getNameThai());
		
		

	}
	
	
	
	
	@Test
	public void searhEmpIdtoAddress() {
		
		//search last id of EMPLOYEE
		Employee employee = employeeRepository.searhEmpIdtoAddress();
		Assert.assertEquals(id.intValue(), employee.getId().intValue());
	
	}
	
	
	
	@Test
	@Ignore
	public void reportEmployee() {
		
		//search last id of EMPLOYEE
		List<ReportEmployeeDto> reportEmployeeDto = employeeRepository.reportEmployee("apiva01");
		Assert.assertNull(reportEmployeeDto);
	
	}
	
	
	@Test
	public void serchRunningNo(){
		
		
		MasLocation masLocation = masLocationRepository.find(idMasLocation);
		EmployeeCodeDto employeeCodeDto = employeeRepository.serchRunningNo(masLocation.getCode());
		Assert.assertEquals(17, employeeCodeDto.getRungingNumber().intValue());
		
	}
	
	
	
	@Test 
	public void findCurrentId(){
		
		EmployeeIdDto employeeIdDto = employeeRepository.findCurrentId();
		Assert.assertEquals(id.intValue(), employeeIdDto.getId().intValue());

		
	}
	
	
	@Test 
	public void findEmployeeAndOfficial(){
		
		Employee employee = employeeRepository.findEmployeeAndOfficial(id);
		Assert.assertEquals(idOfficial, employee.getOfficial().getId());
		
	}
	
	
	
	@Test 
	@Rollback(true)
	public void findAimRelateWithEmployee(){
		
		/****************************Create Employee and Aim**************************/
		
		
		employee = new Employee();
	    employee.setIdCard("115310905001-11");
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
	    employee.setEmployeeCode("JP10018");
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
	
		masJoblevelRepository.create(masJoblevel);
		idMasJoblevel = masJoblevel.getId();
		MasJoblevel masJobLevel1 = masJoblevelRepository.find(idMasJoblevel);
			
	     
	    MasTechnology masTechnology = new MasTechnology();
	    masTechnology.setCode("MasTech-01");
	    masTechnology.setCreatedBy(1);
	    masTechnology.setCreatedTimeStamp(Calendar.getInstance().getTime());
	    masTechnology.setAuditFlag("C");
	    masTechnology.setIsActive(true);
	    masTechnology.setName("MASTECH-01");
	    masTechnologyRepository.create(masTechnology);
	    int masTechId = masTechnology.getId();
	    MasTechnology masTechnology2 = masTechnologyRepository.find(masTechId);
	     
	     
	    Applicant applicant = new Applicant();
		applicant.setCreatedBy(1);
		applicant.setCreatedTimeStamp(Calendar.getInstance().getTime());
		applicant.setAuditFlag("C");
		applicant.setCardId("115310905001-9");
		applicant.setAuditFlag("1");
		applicant.setJoblevel(masJobLevel1);
		applicant.setTechnology(masTechnology2);
		applicantRepository.create(applicant);
		int idApplicant2 = applicant.getId();
	    Applicant applicant1 = applicantRepository.find(idApplicant2);
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
		idMasDivision = masDivision.getId();
		MasDivision masDivision1 = masDivisionRepository.find(idMasDivision);
		employee.setMasDivision(masDivision1);
		

		employee.setMasJoblevel(masJobLevel1);
		
	    
	    MasLocation masLocation = new MasLocation();
	    masLocation.setIsActive(true);
	    masLocation.setAuditFlag("C");
	    masLocation.setCreatedBy(1);
	    masLocation.setCreatedTimeStamp(Calendar.getInstance().getTime());
	    masLocation.setName("MASLOCATION-TESTEMP");
	    masLocation.setCode("JW");
	    masLocationRepository.create(masLocation);
	    idMasLocation = masLocation.getId();	
	    MasLocation masLocation2 = masLocationRepository.find(idMasLocation);
	    
	    employee.setMasLocation(masLocation2);
	    
	    Official official = new Official();
	    official.setCreatedBy(1);
	    official.setCreatedTimeStamp(Calendar.getInstance().getTime());
	    official.setAuditFlag("C");
	    official.setOfficialDate(date);
	    officialRepository.create(official);
	    int idOfficial2 = official.getId();
	    Official official2 = officialRepository.find(idOfficial2);
	    
	    employee.setOfficial(official2);
	    
	    Employee employee2 = employeeRepository.find(id);    
	    employee.setAimempid(employee2);
		
		employeeRepository.create(employee);		
		int idEmployee = employee.getId();
	
		/***************************************************************************/
		
		Employee emp = employeeRepository.find(idEmployee);
		Assert.assertEquals(employee2.getId(), emp.getAimempid().getId());
		
		List<Employee> employeeListAim = employeeRepository.findAimRelateWithEmployee(emp.getAimempid().getId());
		Assert.assertEquals(employee2.getId(), employeeListAim.get(0).getAimempid().getId());
			
	}
	
	
	
	@Test 
	public void findOfficial(){
		
		Employee emp = employeeRepository.findOfficial(id);		
		Assert.assertEquals(idOfficial, emp.getOfficial().getId());
		
	}
	
	@Test 
	public void findEmployeeCode(){
		
		Employee employee = employeeRepository.findEmployeeCode(idMasLocation);
		Assert.assertEquals("JP10017", employee.getEmployeeCode());
		
		
	}


}
