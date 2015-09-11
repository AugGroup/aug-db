package repositories;



import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import com.aug.hrdb.dto.EmployeeDto;
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
        employee.setEmployeeCode("EMP-01");
        employee.setStatusemp("Employee");
        employee.setTelHome("089-0851022");
        employee.setTelMobile("089-0851022");
        employee.setEmergencyContactPhoneNumber("089-085-1022");
        
        
        Applicant applicant = applicantRepository.find(1);
        Hibernate.initialize(applicant);
        
        
        employee.setApplicant(applicant);
         
        employee.setAuditFlag("C");
        employee.setCreatedBy(1);
        employee.setCreatedTimeStamp(Calendar.getInstance().getTime());
    }

	 
	 
	@Test
	@Rollback(false)
	public void create() {
		

	    //create masdivision
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
			
	}
	
	
	@Test
	@Rollback(false)
	public void update() {
	
		Employee employee1 = new Employee();
		employee1 = employeeRepository.find(1);
		employee1.setUpdatedBy(1);
		employee1.setUpdatedTimeStamp(Calendar.getInstance().getTime());
		employee1.setAuditFlag("U");
		employee1.setNameThai("เทส");
		employeeRepository.update(employee1);

	}
	
	
	
	@Test
	@Rollback(false)
	public void saveByNameQueryNullIsMangerAndAimID() {
		
		    
		    MasEmployment masEmployment  = new MasEmployment();
		    masEmployment.setIsActive(true);
		    masEmployment.setAuditFlag("C");
		    masEmployment.setCreatedBy(1);
		    masEmployment.setCreatedTimeStamp(Calendar.getInstance().getTime());
		    masEmployment.setCode("EMPLOYMENT-01");
		    masEmployment.setName("TEST-EMP");
		    masEmploymentRepository.create(masEmployment);
		    
		    MasTechnology masTechnology= new MasTechnology();
		    masTechnology.setIsActive(true);
		    masTechnology.setAuditFlag("C");
		    masTechnology.setCreatedBy(1);
		    masTechnology.setCreatedTimeStamp(Calendar.getInstance().getTime());
		    masTechnology.setName("TECH-TESTEMP");
		    masTechnology.setCode("TECHNOLOGY-01");
		    masTechnologyRepository.create(masTechnology);
		    
		    
		    MasCoreSkill masCoreSkill= new MasCoreSkill();
		    masCoreSkill.setIsActive(true);
		    masCoreSkill.setAuditFlag("C");
		    masCoreSkill.setCreatedBy(1);
		    masCoreSkill.setCreatedTimeStamp(Calendar.getInstance().getTime());
		    masCoreSkill.setName("TECH-TESTEMP");
		    masCoreSkill.setCode("TECHNOLOGY-01");
		    masCoreSkillRepository.create(masCoreSkill);
		    
		    
		    MasStaffType masStaffType = new MasStaffType();
		    masStaffType.setIsActive(true);
		    masStaffType.setAuditFlag("C");
		    masStaffType.setCreatedBy(1);
		    masStaffType.setCreatedTimeStamp(Calendar.getInstance().getTime());
		    masStaffType.setName("MASSTAFFTYPE-TESTEMP");
		    masStaffType.setCode("STAFFTYPE-01");
		    masStaffTypeRepository.create(masStaffType);
	
		    
		    MasLocation masLocation = new MasLocation();
		    masLocation.setIsActive(true);
		    masLocation.setAuditFlag("C");
		    masLocation.setCreatedBy(1);
		    masLocation.setCreatedTimeStamp(Calendar.getInstance().getTime());
		    masLocation.setName("MASSTAFFTYPE-TESTEMP");
		    masLocation.setCode("STAFFTYPE-01");
		    masLocationRepository.create(masLocation);
		    
		    
	        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
	        Date date = null;
	        try {
			    date = dateformat.parse("17/07/1989");
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}


		    
		    Official official = new Official();
		    official.setAuditFlag("C");
		    official.setCreatedBy(1);
		    official.setCreatedTimeStamp(Calendar.getInstance().getTime());
		    official.setOfficialDate(date);
	        officialRepository.create(official);
		    
		    
		    
		 	EmployeeDto employeeDto = new EmployeeDto();
		 	employeeDto.setIdCard("115310905001-9");
		 	employeeDto.setNameThai("อภิวาท์");
		 	employeeDto.setNameEng("apiva");
		 	employeeDto.setNicknameThai("va");
		 	employeeDto.setNicknameEng("va");
		 	employeeDto.setSurnameThai("กิมเกถนอม");
		 	employeeDto.setSurnameEng("kimkatanom");
		 	employeeDto.setAge(25);
		 	employeeDto.setHeight(165);
		 	employeeDto.setWeigth(55);
	        
	        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	    	String dateInString = "31-08-1982";
	    	Date date1 = null;
			try {
				date1 = sdf.parse(dateInString);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	        
			employeeDto.setDateOfBirth(date1);
			employeeDto.setEmail("test@gmail.com");
			employeeDto.setEmergencyContact("mom");
			employeeDto.setEmployeeCode("EMP-02");
			employeeDto.setStatusemp("Employee");
			employeeDto.setTelHome("089-0851022");
			employeeDto.setTelMobile("089-0851022");
			employeeDto.setEmergencyContactPhoneNumber("089-085-1022");
	        
	        
	        Applicant applicant = applicantRepository.find(1);
	        Hibernate.initialize(applicant);
	        
	        employeeDto.setApplicateId(applicant.getId());
	         
	        MasDivision masDivision = masDivisionRepository.find(1);
	        
	        employeeDto.setMasDivision(masDivision.getId());
	        
	        MasJoblevel masJoblevel = masJoblevelRepository.find(1);
	        employeeDto.setMasJoblevel(masJoblevel.getId());
	        
	        MasEmployment masEmployment2  = masEmploymentRepository.find(1);
	        
	        employeeDto.setMasEmployment(masEmployment.getId());
	        
	        MasTechnology masTechnology2 = masTechnologyRepository.find(1);
	        employeeDto.setTechnology(masTechnology2.getId());
	        
	        
	        MasCoreSkill masCoreSkill2 = masCoreSkillRepository.find(1);
	        employeeDto.setMasCoreSkill(masCoreSkill2.getId());
	        
	        MasStaffType masStaffType2 = masStaffTypeRepository.find(1);
	        employeeDto.setMasStaffType(masStaffType.getId());
	        
	        MasLocation masLocation2 = masLocationRepository.find(1);
	        employeeDto.setMasLocationId(masLocation2.getId());
	        
	        Official official2 = officialRepository.find(1);
	        employeeDto.setOfficialId(official2.getId());
	      
	        employeeRepository.saveByNameQuery(employeeDto);

	}
	
	
	
	
	@Test
	@Rollback(false)
	public void saveByNameQueryNullIsMangerAndNotNullAimID() {
		
		    
		 	EmployeeDto employeeDto = new EmployeeDto();
		 	employeeDto.setIdCard("115310905001-9");
		 	employeeDto.setNameThai("อภิวาท์");
		 	employeeDto.setNameEng("apiva");
		 	employeeDto.setNicknameThai("va");
		 	employeeDto.setNicknameEng("va");
		 	employeeDto.setSurnameThai("กิมเกถนอม");
		 	employeeDto.setSurnameEng("kimkatanom");
		 	employeeDto.setAge(25);
		 	employeeDto.setHeight(165);
		 	employeeDto.setWeigth(55);
	        
	        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	    	String dateInString = "31-08-1982";
	    	Date date1 = null;
			try {
				date1 = sdf.parse(dateInString);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	        
			employeeDto.setDateOfBirth(date1);
			employeeDto.setEmail("test@gmail.com");
			employeeDto.setEmergencyContact("mom");
			employeeDto.setEmployeeCode("EMP-03");
			employeeDto.setStatusemp("Employee");
			employeeDto.setTelHome("089-0851022");
			employeeDto.setTelMobile("089-0851022");
			employeeDto.setEmergencyContactPhoneNumber("089-085-1022");
			employeeDto.setAimempid(1);
	        
	        
	        Applicant applicant = applicantRepository.find(1);
	        Hibernate.initialize(applicant);
	        
	        employeeDto.setApplicateId(applicant.getId());
	         
	        MasDivision masDivision = masDivisionRepository.find(1);	        
	        employeeDto.setMasDivision(masDivision.getId());
	        
	        MasJoblevel masJoblevel = masJoblevelRepository.find(1);
	        employeeDto.setMasJoblevel(masJoblevel.getId());
	        
	        MasEmployment masEmployment2  = masEmploymentRepository.find(1);	        
	        employeeDto.setMasEmployment(masEmployment2.getId());
	        
	        MasTechnology masTechnology2 = masTechnologyRepository.find(1);
	        employeeDto.setTechnology(masTechnology2.getId());
	        
	        
	        MasCoreSkill masCoreSkill2 = masCoreSkillRepository.find(1);
	        employeeDto.setMasCoreSkill(masCoreSkill2.getId());
	        
	        MasStaffType masStaffType2 = masStaffTypeRepository.find(1);
	        employeeDto.setMasStaffType(masStaffType2.getId());
	        
	        MasLocation masLocation2 = masLocationRepository.find(1);
	        employeeDto.setMasLocationId(masLocation2.getId());
	        
	        Official official2 = officialRepository.find(1);
	        employeeDto.setOfficialId(official2.getId());
	      
	        employeeRepository.saveByNameQuery(employeeDto);

	}
	
	
	
	
	
	
	@Test
	@Rollback(false)
	public void saveByNameQueryNotNullIsMangerAndNullAimID() {
		
		    
		 	EmployeeDto employeeDto = new EmployeeDto();
		 	employeeDto.setIdCard("115310905001-9");
		 	employeeDto.setNameThai("อภิวาท์");
		 	employeeDto.setNameEng("apiva");
		 	employeeDto.setNicknameThai("va");
		 	employeeDto.setNicknameEng("va");
		 	employeeDto.setSurnameThai("กิมเกถนอม");
		 	employeeDto.setSurnameEng("kimkatanom");
		 	employeeDto.setAge(25);
		 	employeeDto.setHeight(165);
		 	employeeDto.setWeigth(55);
	        
	        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	    	String dateInString = "31-08-1982";
	    	Date date1 = null;
			try {
				date1 = sdf.parse(dateInString);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	        
			employeeDto.setDateOfBirth(date1);
			employeeDto.setEmail("test@gmail.com");
			employeeDto.setEmergencyContact("mom");
			employeeDto.setEmployeeCode("EMP-04");
			employeeDto.setStatusemp("Employee");
			employeeDto.setTelHome("089-0851022");
			employeeDto.setTelMobile("089-0851022");
			employeeDto.setEmergencyContactPhoneNumber("089-085-1022");
			employeeDto.setIsManager(1);
	        
	        
	        Applicant applicant = applicantRepository.find(1);
	        Hibernate.initialize(applicant);
	        
	        employeeDto.setApplicateId(applicant.getId());
	         
	        MasDivision masDivision = masDivisionRepository.find(1);	        
	        employeeDto.setMasDivision(masDivision.getId());
	        
	        MasJoblevel masJoblevel = masJoblevelRepository.find(1);
	        employeeDto.setMasJoblevel(masJoblevel.getId());
	        
	        MasEmployment masEmployment2  = masEmploymentRepository.find(1);	        
	        employeeDto.setMasEmployment(masEmployment2.getId());
	        
	        MasTechnology masTechnology2 = masTechnologyRepository.find(1);
	        employeeDto.setTechnology(masTechnology2.getId());
	        
	        
	        MasCoreSkill masCoreSkill2 = masCoreSkillRepository.find(1);
	        employeeDto.setMasCoreSkill(masCoreSkill2.getId());
	        
	        MasStaffType masStaffType2 = masStaffTypeRepository.find(1);
	        employeeDto.setMasStaffType(masStaffType2.getId());
	        
	        MasLocation masLocation2 = masLocationRepository.find(1);
	        employeeDto.setMasLocationId(masLocation2.getId());
	        
	        Official official2 = officialRepository.find(1);
	        employeeDto.setOfficialId(official2.getId());
	      
	        employeeRepository.saveByNameQuery(employeeDto);

	}


	
	
	
	
	@Test
	@Rollback(false)
	public void saveByNameQueryNotNullIsMangerAndNotNullAimID() {
		
		   
		    Official official = new Official();
		    official.setAuditFlag("C");
		    official.setCreatedBy(1);
		    official.setCreatedTimeStamp(Calendar.getInstance().getTime());
		    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	    	String dateInString = "31-08-1982";
	    	Date date1 = null;
			try {
				date1 = sdf.parse(dateInString);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			official.setOfficialDate(date1);
			officialRepository.create(official);
		
		 	EmployeeDto employeeDto = new EmployeeDto();
		 	employeeDto.setIdCard("115310905001-9");
		 	employeeDto.setNameThai("อภิวาท์");
		 	employeeDto.setNameEng("apiva");
		 	employeeDto.setNicknameThai("va");
		 	employeeDto.setNicknameEng("va");
		 	employeeDto.setSurnameThai("กิมเกถนอม");
		 	employeeDto.setSurnameEng("kimkatanom");
		 	employeeDto.setAge(25);
		 	employeeDto.setHeight(165);
		 	employeeDto.setWeigth(55);
	        
	        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
	    	String dateInString1 = "31-08-1982";
	    	Date date2 = null;
			try {
				date2 = sdf.parse(dateInString);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	        
			employeeDto.setDateOfBirth(date2);
			employeeDto.setEmail("test@gmail.com");
			employeeDto.setEmergencyContact("mom");
			employeeDto.setEmployeeCode("EMP-06");
			employeeDto.setStatusemp("Employee");
			employeeDto.setTelHome("089-0851022");
			employeeDto.setTelMobile("089-0851022");
			employeeDto.setEmergencyContactPhoneNumber("089-085-1022");
			employeeDto.setIsManager(1);
			employeeDto.setAimempid(1);
	        
	        
	        Applicant applicant1 = applicantRepository.find(4);
	        Hibernate.initialize(applicant1);
	        
	        employeeDto.setApplicateId(applicant1.getId());
	         
	        MasDivision masDivision = masDivisionRepository.find(1);	        
	        employeeDto.setMasDivision(masDivision.getId());
	        
	        MasJoblevel masJoblevel = masJoblevelRepository.find(1);
	        employeeDto.setMasJoblevel(masJoblevel.getId());
	        
	        MasEmployment masEmployment2  = masEmploymentRepository.find(1);	        
	        employeeDto.setMasEmployment(masEmployment2.getId());
	        
	        MasTechnology masTechnology2 = masTechnologyRepository.find(1);
	        employeeDto.setTechnology(masTechnology2.getId());
	        
	        
	        MasCoreSkill masCoreSkill2 = masCoreSkillRepository.find(1);
	        employeeDto.setMasCoreSkill(masCoreSkill2.getId());
	        
	        MasStaffType masStaffType2 = masStaffTypeRepository.find(1);
	        employeeDto.setMasStaffType(masStaffType2.getId());
	        
	        MasLocation masLocation2 = masLocationRepository.find(1);
	        employeeDto.setMasLocationId(masLocation2.getId());
	        
	        Official official2 = officialRepository.find(3);
	        employeeDto.setOfficialId(official2.getId());
	      
	        employeeRepository.saveByNameQuery(employeeDto);

	}


	
	
	@Test
	public void searhEmpIdtoAddress() {
		
		//search last id of EMPLOYEE
		Employee employee = employeeRepository.searhEmpIdtoAddress();
		Assert.assertEquals(10, employee.getId().intValue());
	
	}
	
	
	
	@Test
	@Ignore
	public void reportEmployee() {
		
		//search last id of EMPLOYEE
		List<ReportEmployeeDto> reportEmployeeDto = employeeRepository.reportEmployee("apiva01");
		Assert.assertNull(reportEmployeeDto);
	
	}
	
	
	




}
