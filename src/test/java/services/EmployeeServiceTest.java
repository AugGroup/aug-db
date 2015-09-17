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

import com.aug.hrdb.dto.AddressDto;
import com.aug.hrdb.dto.EmployeeDto;
import com.aug.hrdb.entities.Address;
import com.aug.hrdb.entities.Applicant;
import com.aug.hrdb.entities.Employee;
import com.aug.hrdb.entities.MasAddressType;
import com.aug.hrdb.entities.MasDivision;
import com.aug.hrdb.entities.MasJoblevel;
import com.aug.hrdb.entities.MasLocation;
import com.aug.hrdb.entities.MasProvince;
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
import com.aug.hrdb.services.AddressService;
import com.aug.hrdb.services.ApplicantService;
import com.aug.hrdb.services.EmployeeService;
import com.aug.hrdb.services.MasAddressTypeService;
import com.aug.hrdb.services.MasCoreSkillService;
import com.aug.hrdb.services.MasDivisionService;
import com.aug.hrdb.services.MasEmploymentService;
import com.aug.hrdb.services.MasJoblevelService;
import com.aug.hrdb.services.MasLocationService;
import com.aug.hrdb.services.MasProvinceService;
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
	@Autowired
	private AddressService addressService;
	@Autowired
	private MasAddressTypeService addressTypeService;
	@Autowired
	private MasProvinceService provinceService;
	
	
	
	private Employee employee;
	private Integer id;
	private Integer idApplicant;
    private Integer idMasJoblevel;
	private Integer idMasDivision;
	private Integer idMasLocation;
	private Integer idOfficial;
	private Integer idAddress1;
	private Integer idMasAddressType;
	private Integer idMasProvice;
	private Integer masTechId;
	
	
	MasAddressType addressType;
	MasProvince province;
	
	
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
        masTechId = masTechnology.getId();
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
    
       
        
        
		addressType = new MasAddressType();
		addressType.setName("Permanent");
		addressType.setIsActive(true);
		addressType.setCreatedBy(1);
		addressType.setCreatedTimeStamp(Calendar.getInstance().getTime());
		addressType.setAuditFlag("C");
		addressType.setCode("MAS-ADDTYPE01");
		addressTypeService.create(addressType);
		idMasAddressType = addressType.getId();
		MasAddressType masAddressType = addressTypeService.findById(idMasAddressType);
		
		
		province = new MasProvince();
		province.setName("Bangkok");
		province.setCode("B001");
		province.setIsActive(true);
		province.setCreatedBy(1);
		province.setCreatedTimeStamp(Calendar.getInstance().getTime());
		province.setAuditFlag("C");
		provinceService.create(province);
		idMasProvice = province.getId();
		MasProvince masProvince = provinceService.find(idMasProvice);
		
		

		Address address = new Address();
		address.setHouseNo("18559");
		address.setRoad("Sukhumvit");
		address.setDistrict("Mung");
		address.setSubDistrict("AmphurMung");
		address.setZipcode(10252);
		address.setAddressType(masAddressType);
		address.setProvince(masProvince);
		address.setAuditFlag("C");
		address.setCreatedBy(1);
		address.setCreatedTimeStamp(Calendar.getInstance().getTime());
		address.setApplicant(applicant1);

		
		addressService.create(address);
		idAddress1 = address.getId();
		
		
		
		
		addressType = new MasAddressType();
		addressType.setName("Present");
		addressType.setIsActive(true);
		addressType.setCreatedBy(1);
		addressType.setCreatedTimeStamp(Calendar.getInstance().getTime());
		addressType.setAuditFlag("C");
		addressType.setCode("MAS-ADDTYPE03");
		addressTypeService.create(addressType);
		int idMasAddressType1 = addressType.getId();
		MasAddressType masAddressType1 = addressTypeService.findById(idMasAddressType1);
		
		
		province = new MasProvince();
		province.setName("Pathumtani");
		province.setCode("B002");
		province.setIsActive(true);
		province.setCreatedBy(1);
		province.setCreatedTimeStamp(Calendar.getInstance().getTime());
		province.setAuditFlag("C");
		provinceService.create(province);
		int idMasProvice1 = province.getId();
		MasProvince masProvince1 = provinceService.find(idMasProvice1);
		
		

		Address address1 = new Address();
		address1.setHouseNo("1855");
		address1.setRoad("Sukhumvit");
		address1.setDistrict("Mung");
		address1.setSubDistrict("AmphurMung");
		address1.setZipcode(10252);
		address1.setAddressType(masAddressType1);
		address1.setProvince(masProvince1);
		address1.setAuditFlag("C");
		address1.setCreatedBy(1);
		address1.setCreatedTimeStamp(Calendar.getInstance().getTime());
		address1.setApplicant(applicant1);
		
		
		addressService.create(address1);
		
		
		
		
		

	
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
	    
	    
	    employee.setApplicant(applicant1);
        
        
		
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
	
	
	
	
	@Test 
	public void findByCriteria(){
		
		Employee employee = employeeService.findById(id);
		List<Employee> empList = employeeService.findByCriteria(employee);
		Assert.assertEquals(true, empList.contains(employee));		

		
		
	}
	
	
	@Test
	public void searhEmpIdtoAddress() {
		
		//search last id of EMPLOYEE
		Employee employee = employeeService.searhEmpIdtoAddress();
		Assert.assertEquals(id.intValue(), employee.getId().intValue());
	
	}
	
	
	
	@Test
	public void findEmployeeByEmployeeIdWithSetToDto(){
		
		EmployeeDto employeeDto = employeeService.findEmployeeByEmployeeIdWithSetToDto(id);
		List<AddressDto> addressDto =  addressService.findAddressByApplicantId(idApplicant);
		
		
		System.out.println("id address dto1 "+addressDto.get(0).getId());
		System.out.println("id address dto2 "+employeeDto.getAddressList().get(0).getId());

		Assert.assertEquals(addressDto.get(0).getId(), employeeDto.getAddressList().get(0).getId());
		
	    
		
	}
	
	
	
	
	@Test
	@Rollback(true)
	public void createEmployeeAndReturnId(){
		
		 MasJoblevel masJobLevel = masJoblevelService.find(idMasJoblevel);
		 MasTechnology masTechnology = masTechnologyService.find(masTechId);
		 MasProvince masProvince = provinceService.find(idMasProvice);
		
		
		 Applicant applicant = new Applicant();
		 applicant.setCreatedBy(1);
		 applicant.setCreatedTimeStamp(Calendar.getInstance().getTime());
		 applicant.setAuditFlag("C");
		 applicant.setCardId("115310905001-9");
		 applicant.setAuditFlag("1");
		 applicant.setJoblevel(masJobLevel);
		 applicant.setTechnology(masTechnology);
		 applicantService.create(applicant);
		 int idApplicant2 = applicant.getId();
		 System.out.println("id applicant: "+idApplicant2);
	     Applicant applicant1 = applicantService.findById(idApplicant2);
		
		
		EmployeeDto employeeDto = new EmployeeDto();
		
		employeeDto.setNameThai("อภิวาท์");
		employeeDto.setNameEng("apiva");
		employeeDto.setSurnameEng("viva");
		employeeDto.setSurnameThai("กิมเกถนอม");
		employeeDto.setNicknameEng("va");
		employeeDto.setNicknameThai("วา");
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	    	String dateInString = "31-08-2014";
	    	Date date = null;
			try {
				date = sdf.parse(dateInString);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		
		employeeDto.setStartWorkDate(date);
		
		SimpleDateFormat sdfEnd = new SimpleDateFormat("dd-MM-yyyy");
    	String dateInStringEnd = "31-12-2016";
    	Date dateEnd = null;
		try {
			dateEnd = sdfEnd.parse(dateInStringEnd);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		employeeDto.setEndWorkDate(dateEnd);
		employeeDto.setPositionAppliedFor("Programmer");
		employeeDto.setOfficialDate(date);
		
		
		employee.setEmployeeCode("EMP-19");
		employeeDto.setIdCard("115310905001-9");
		employeeDto.setAge(25);
		employeeDto.setEmail("test@gmail.com");
		employeeDto.setEmergencyContact("mom");
		employeeDto.setEmergencyContactPhoneNumber("089-085-1022");
		
		SimpleDateFormat sdfDOB= new SimpleDateFormat("dd-MM-yyyy");
    	String dateInStringDOB = "12-01-1991";
    	Date dateDOB = null;
    	
		try {
			dateDOB = sdfDOB.parse(dateInStringDOB);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		employeeDto.setDateOfBirth(dateDOB);
		employeeDto.setStatusemp("Employee");
		employeeDto.setApplicateId(applicant1.getId());
		
		List<AddressDto> addressDtoList = new ArrayList<AddressDto>();
		
		AddressDto addressDto = new AddressDto();
		
		addressDto.setId(0);
		addressDto.setAddressTypeId(idMasAddressType);
		addressDto.setApplicantId(applicant1.getId());
		addressDto.setMasprovinceId(idMasProvice);
		addressDto.setMasprovinceName(masProvince.getName());
		addressDto.setHouseNo("1/11");
		addressDto.setDistrict("nongsamwong");
		addressDto.setSubDistrict("nongsua");
		addressDto.setRoad("sathon");
		addressDto.setStatus("add");
		
		addressDtoList.add(addressDto);
		
		
		employeeDto.setIsManager(1);
		employeeDto.setAimempid(id);
		
		
		employeeDto.setMasJoblevel(idMasJoblevel);
		employeeDto.setMasDivision(idMasDivision);
		
		employeeDto.setTelHome("0890851022");
		employeeDto.setTelMobile("0890851022");
		employeeDto.setAddressList(addressDtoList);
		
		Employee emp = employeeService.createEmployeeAndReturnId(employeeDto, "EMP-1119");
		Employee emp2 = employeeService.findById(emp.getId());
	
			
		Assert.assertEquals("EMP-1119", emp2.getEmployeeCode());
		
		List<AddressDto> addressDtoList1 = addressService.findAddressByApplicantId(applicant1.getId());
		System.out.println("address list size: "+addressDtoList1.size());
		
	
		
		Assert.assertEquals("1/11", addressDtoList1.get(0).getHouseNo());

	}
	
	
	@Test
	@Rollback(true)
	public void deleteEmployeeByHibernate (){
		
		Employee employee = employeeService.findById(id);
		employeeService.deleteEmployeeByHibernate(employee);
		Employee employee2 = employeeService.findById(id);
		Assert.assertNull(employee2);
		
	}
	
	
	
	
	@Test
	@Rollback(true)
	public void updateEmployeeAndReturnId(){
		
		
		/*********************************************** create employee  **********************************************************/
		
		 MasJoblevel masJobLevel = masJoblevelService.find(idMasJoblevel);
		 MasTechnology masTechnology = masTechnologyService.find(masTechId);
		 MasProvince masProvince = provinceService.find(idMasProvice);
		
		
		 Applicant applicant = new Applicant();
		 applicant.setCreatedBy(1);
		 applicant.setCreatedTimeStamp(Calendar.getInstance().getTime());
		 applicant.setAuditFlag("C");
		 applicant.setCardId("115310905001-9");
		 applicant.setAuditFlag("1");
		 applicant.setJoblevel(masJobLevel);
		 applicant.setTechnology(masTechnology);
		 applicantService.create(applicant);
		 int idApplicant2 = applicant.getId();
		 System.out.println("id applicant: "+idApplicant2);
	     Applicant applicant1 = applicantService.findById(idApplicant2);
		
		
		EmployeeDto employeeDto = new EmployeeDto();
		
		employeeDto.setNameThai("อภิวาท์");
		employeeDto.setNameEng("apiva");
		employeeDto.setSurnameEng("viva");
		employeeDto.setSurnameThai("กิมเกถนอม");
		employeeDto.setNicknameEng("va");
		employeeDto.setNicknameThai("วา");
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	    	String dateInString = "31-08-2014";
	    	Date date = null;
			try {
				date = sdf.parse(dateInString);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		
		employeeDto.setStartWorkDate(date);
		
		SimpleDateFormat sdfEnd = new SimpleDateFormat("dd-MM-yyyy");
    	String dateInStringEnd = "31-12-2016";
    	Date dateEnd = null;
		try {
			dateEnd = sdfEnd.parse(dateInStringEnd);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		employeeDto.setEndWorkDate(dateEnd);
		employeeDto.setPositionAppliedFor("Programmer");
		employeeDto.setOfficialDate(date);
		
		
		employee.setEmployeeCode("EMP-19");
		employeeDto.setIdCard("115310905001-9");
		employeeDto.setAge(25);
		employeeDto.setEmail("test@gmail.com");
		employeeDto.setEmergencyContact("mom");
		employeeDto.setEmergencyContactPhoneNumber("089-085-1022");
		
		SimpleDateFormat sdfDOB= new SimpleDateFormat("dd-MM-yyyy");
    	String dateInStringDOB = "12-01-1991";
    	Date dateDOB = null;
    	
		try {
			dateDOB = sdfDOB.parse(dateInStringDOB);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		employeeDto.setDateOfBirth(dateDOB);
		employeeDto.setStatusemp("Employee");
		employeeDto.setApplicateId(applicant1.getId());
		
		List<AddressDto> addressDtoList = new ArrayList<AddressDto>();
		
		AddressDto addressDto = new AddressDto();
		
		addressDto.setId(0);
		addressDto.setAddressTypeId(idMasAddressType);
		addressDto.setApplicantId(applicant1.getId());
		addressDto.setMasprovinceId(idMasProvice);
		addressDto.setMasprovinceName(masProvince.getName());
		addressDto.setHouseNo("1/11");
		addressDto.setDistrict("nongsamwong");
		addressDto.setSubDistrict("nongsua");
		addressDto.setRoad("sathon");
		addressDto.setStatus("add");
		
		addressDtoList.add(addressDto);
		
		
		employeeDto.setIsManager(1);
		employeeDto.setAimempid(id);
		
		
		employeeDto.setMasJoblevel(idMasJoblevel);
		employeeDto.setMasDivision(idMasDivision);
		
		employeeDto.setTelHome("0890851022");
		employeeDto.setTelMobile("0890851022");
		employeeDto.setAddressList(addressDtoList);
		
		Employee emp = employeeService.createEmployeeAndReturnId(employeeDto, "EMP-1119");
		
		
	/*******************************************************************************************************************************/	
		
		
		EmployeeDto emp2 = employeeService.findEmployeeByEmployeeIdWithSetToDto(emp.getId());	
		List<AddressDto> addressDtoList1 = addressService.findAddressByApplicantId(emp2.getApplicateId());
		emp2.setNameEng("test");
		
		
		List<AddressDto> addressDto1 = new  ArrayList<AddressDto>();
		AddressDto addressDto2 = new AddressDto();
		
		addressDto2.setId(0);
		addressDto2.setAddressTypeId(idMasAddressType);
		addressDto2.setApplicantId(applicant1.getId());
		addressDto2.setMasprovinceId(idMasProvice);
		addressDto2.setMasprovinceName(masProvince.getName());
		addressDto2.setHouseNo("1/19");
		addressDto2.setDistrict("nongsamwong");
		addressDto2.setSubDistrict("nongsua");
		addressDto2.setRoad("sathon");
		addressDto2.setStatus("add");
		
		addressDto1.add(addressDto2);
		
		AddressDto addressDto3 = new AddressDto();
		addressDto3.setId(addressDtoList1.get(0).getId());
		addressDto3.setAddressTypeId(addressDtoList1.get(0).getAddressTypeId());
		addressDto3.setApplicantId(addressDtoList1.get(0).getApplicantId());
		addressDto3.setMasprovinceId(addressDtoList1.get(0).getMasprovinceId());
		addressDto3.setMasprovinceName(addressDtoList1.get(0).getMasprovinceName());
		addressDto3.setHouseNo("1/6");
		addressDto3.setDistrict(addressDtoList1.get(0).getDistrict());
		addressDto3.setSubDistrict(addressDtoList1.get(0).getSubDistrict());
		addressDto3.setRoad(addressDtoList1.get(0).getRoad());
		addressDto3.setStatus("edit");
		
		
		addressDto1.add(addressDto3);
		
		System.out.println("size: "+addressDto1.size());
		
		emp2.setAddressList(addressDto1);
		
		employeeService.updateEmployeeAndReturnId(emp2, emp2.getEmployeeCode());
		
		
		Employee empFindData = employeeService.findById(emp.getId());
		Address addUpdate = addressService.find(addressDtoList1.get(0).getId());
		List<AddressDto> addressListDto3 = addressService.findAddressByApplicantId(addressDtoList1.get(0).getApplicantId());
		
		Assert.assertEquals("test", empFindData.getNameEng());
		Assert.assertEquals("1/6", addUpdate.getHouseNo());
		Assert.assertEquals(2, addressListDto3.size());
		
	}
	
	
	@Test
	@Rollback(true)
	public void findEmployeeCode(){
		
		/*********************************************** create employee  **********************************************************/
		
		 MasJoblevel masJobLevel = masJoblevelService.find(idMasJoblevel);
		 MasTechnology masTechnology = masTechnologyService.find(masTechId);
		 MasProvince masProvince = provinceService.find(idMasProvice);
		 MasLocation masLocation = masLocationService.find(idMasLocation);
		
		
		 Applicant applicant = new Applicant();
		 applicant.setCreatedBy(1);
		 applicant.setCreatedTimeStamp(Calendar.getInstance().getTime());
		 applicant.setAuditFlag("C");
		 applicant.setCardId("115310905001-9");
		 applicant.setAuditFlag("1");
		 applicant.setJoblevel(masJobLevel);
		 applicant.setTechnology(masTechnology);
		 applicantService.create(applicant);
		 int idApplicant2 = applicant.getId();
		 System.out.println("id applicant: "+idApplicant2);
	     Applicant applicant1 = applicantService.findById(idApplicant2);
		
		
		EmployeeDto employeeDto = new EmployeeDto();
		
		employeeDto.setNameThai("อภิวาท์");
		employeeDto.setNameEng("apiva");
		employeeDto.setSurnameEng("viva");
		employeeDto.setSurnameThai("กิมเกถนอม");
		employeeDto.setNicknameEng("va");
		employeeDto.setNicknameThai("วา");
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	    	String dateInString = "31-08-2014";
	    	Date date = null;
			try {
				date = sdf.parse(dateInString);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		
		employeeDto.setStartWorkDate(date);
		
		SimpleDateFormat sdfEnd = new SimpleDateFormat("dd-MM-yyyy");
   	    String dateInStringEnd = "31-12-2016";
   	    Date dateEnd = null;
		try {
			dateEnd = sdfEnd.parse(dateInStringEnd);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		employeeDto.setEndWorkDate(dateEnd);
		employeeDto.setPositionAppliedFor("Programmer");
		employeeDto.setOfficialDate(date);
		
		
		employee.setEmployeeCode("EMP-19");
		employeeDto.setIdCard("115310905001-9");
		employeeDto.setAge(25);
		employeeDto.setEmail("test@gmail.com");
		employeeDto.setEmergencyContact("mom");
		employeeDto.setEmergencyContactPhoneNumber("089-085-1022");
		
		SimpleDateFormat sdfDOB= new SimpleDateFormat("dd-MM-yyyy");
   	    String dateInStringDOB = "12-01-1991";
     	Date dateDOB = null;
   	
		try {
			dateDOB = sdfDOB.parse(dateInStringDOB);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		employeeDto.setDateOfBirth(dateDOB);
		employeeDto.setStatusemp("Employee");
		employeeDto.setApplicateId(applicant1.getId());
		
		List<AddressDto> addressDtoList = new ArrayList<AddressDto>();
		
		AddressDto addressDto = new AddressDto();
		
		addressDto.setId(0);
		addressDto.setAddressTypeId(idMasAddressType);
		addressDto.setApplicantId(applicant1.getId());
		addressDto.setMasprovinceId(idMasProvice);
		addressDto.setMasprovinceName(masProvince.getName());
		addressDto.setHouseNo("1/11");
		addressDto.setDistrict("nongsamwong");
		addressDto.setSubDistrict("nongsua");
		addressDto.setRoad("sathon");
		addressDto.setStatus("add");
		
		addressDtoList.add(addressDto);
		
		
		employeeDto.setIsManager(1);
		employeeDto.setAimempid(id);
		
		
		employeeDto.setMasJoblevel(idMasJoblevel);
		employeeDto.setMasDivision(idMasDivision);
		
		employeeDto.setTelHome("0890851022");
		employeeDto.setTelMobile("0890851022");
		employeeDto.setAddressList(addressDtoList);
		
		Employee emp = employeeService.createEmployeeAndReturnId(employeeDto, "JP10020");
		
		
	/*******************************************************************************************************************************/	
		
		
		
		Employee employee = employeeService.findEmployeeCode(idMasLocation);		
		Assert.assertEquals("JP10020", employee.getEmployeeCode());
		
		
	}
	
	
	
	@Test
	public void generateEmployeeCode(){
		
		
		EmployeeDto employeeDto = employeeService.findEmployeeByEmployeeIdWithSetToDto(id);		
		String employeeCode = employeeService.generateEmployeeCode(employeeDto);
		System.out.println("emp code: "+employeeCode);
		Assert.assertEquals("JP10020", employeeCode);
		
		
	}
	
	
	
	

	@Test
	public void findOfficial(){
		
		Employee employee = employeeService.findOfficial(id);		
		Assert.assertEquals(idOfficial, employee.getOfficial().getId());
		
	}
	
	
	@Test
	@Rollback(true)
	public void findAimRelateWithEmployee() {
		
		
		/*********************************************** create employee  **********************************************************/
		
		 MasJoblevel masJobLevel = masJoblevelService.find(idMasJoblevel);
		 MasTechnology masTechnology = masTechnologyService.find(masTechId);
		 MasProvince masProvince = provinceService.find(idMasProvice);
		 MasLocation masLocation = masLocationService.find(idMasLocation);
		
		
		 Applicant applicant = new Applicant();
		 applicant.setCreatedBy(1);
		 applicant.setCreatedTimeStamp(Calendar.getInstance().getTime());
		 applicant.setAuditFlag("C");
		 applicant.setCardId("115310905001-9");
		 applicant.setAuditFlag("1");
		 applicant.setJoblevel(masJobLevel);
		 applicant.setTechnology(masTechnology);
		 applicantService.create(applicant);
		 int idApplicant2 = applicant.getId();
		 System.out.println("id applicant: "+idApplicant2);
	     Applicant applicant1 = applicantService.findById(idApplicant2);
		
		
		EmployeeDto employeeDto = new EmployeeDto();
		
		employeeDto.setNameThai("อภิวาท์");
		employeeDto.setNameEng("apiva");
		employeeDto.setSurnameEng("viva");
		employeeDto.setSurnameThai("กิมเกถนอม");
		employeeDto.setNicknameEng("va");
		employeeDto.setNicknameThai("วา");
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	    	String dateInString = "31-08-2014";
	    	Date date = null;
			try {
				date = sdf.parse(dateInString);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		
		employeeDto.setStartWorkDate(date);
		
		SimpleDateFormat sdfEnd = new SimpleDateFormat("dd-MM-yyyy");
  	    String dateInStringEnd = "31-12-2016";
  	    Date dateEnd = null;
		try {
			dateEnd = sdfEnd.parse(dateInStringEnd);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		employeeDto.setEndWorkDate(dateEnd);
		employeeDto.setPositionAppliedFor("Programmer");
		employeeDto.setOfficialDate(date);
		
		
		employee.setEmployeeCode("EMP-19");
		employeeDto.setIdCard("115310905001-9");
		employeeDto.setAge(25);
		employeeDto.setEmail("test@gmail.com");
		employeeDto.setEmergencyContact("mom");
		employeeDto.setEmergencyContactPhoneNumber("089-085-1022");
		
		SimpleDateFormat sdfDOB= new SimpleDateFormat("dd-MM-yyyy");
  	    String dateInStringDOB = "12-01-1991";
    	Date dateDOB = null;
  	
		try {
			dateDOB = sdfDOB.parse(dateInStringDOB);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		employeeDto.setDateOfBirth(dateDOB);
		employeeDto.setStatusemp("Employee");
		employeeDto.setApplicateId(applicant1.getId());
		
		List<AddressDto> addressDtoList = new ArrayList<AddressDto>();
		
		AddressDto addressDto = new AddressDto();
		
		addressDto.setId(0);
		addressDto.setAddressTypeId(idMasAddressType);
		addressDto.setApplicantId(applicant1.getId());
		addressDto.setMasprovinceId(idMasProvice);
		addressDto.setMasprovinceName(masProvince.getName());
		addressDto.setHouseNo("1/11");
		addressDto.setDistrict("nongsamwong");
		addressDto.setSubDistrict("nongsua");
		addressDto.setRoad("sathon");
		addressDto.setStatus("add");
		
		addressDtoList.add(addressDto);
		
		
		employeeDto.setIsManager(1);
		employeeDto.setAimempid(id);
		
		
		employeeDto.setMasJoblevel(idMasJoblevel);
		employeeDto.setMasDivision(idMasDivision);
		
		employeeDto.setTelHome("0890851022");
		employeeDto.setTelMobile("0890851022");
		employeeDto.setAddressList(addressDtoList);
		employeeDto.setAimempid(id);
		employeeDto.setIsManager(1);
		
		Employee emp = employeeService.createEmployeeAndReturnId(employeeDto, "JP10020");
		
		
		
	 /***********************************************************************************************************************************/
		
		
		
		List<Employee> employeeList = employeeService.findAimRelateWithEmployee(emp.getAimempid().getId());
		Assert.assertEquals(1, employeeList.size());
		
		
	}

}
