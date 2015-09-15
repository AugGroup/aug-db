/**
 *
 * @author natechanok
 * @date Sep 4, 2015
 */

package repositories;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.hibernate.Hibernate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.Address;
import com.aug.hrdb.entities.Applicant;
import com.aug.hrdb.entities.Employee;
import com.aug.hrdb.entities.MasAddressType;
import com.aug.hrdb.entities.MasDivision;
import com.aug.hrdb.entities.MasJoblevel;
import com.aug.hrdb.entities.MasProvince;
import com.aug.hrdb.repositories.AddressRepository;
import com.aug.hrdb.repositories.ApplicantRepository;
import com.aug.hrdb.repositories.EmployeeRepository;
import com.aug.hrdb.repositories.MasAddressTypeRepository;
import com.aug.hrdb.repositories.MasDivisionRepository;
import com.aug.hrdb.repositories.MasJoblevelRepository;
import com.aug.hrdb.repositories.MasProvinceRepository;
import com.jayway.jsonpath.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class AddressRepositoryTest {
	
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private MasAddressTypeRepository addressTypeRepository;
	@Autowired
	private MasProvinceRepository provinceRepository;
	@Autowired
	private ApplicantRepository applicantRepository;
	@Autowired
	private MasDivisionRepository divisionRepository;
	@Autowired
	private MasJoblevelRepository joblevelRepository;
	
	
	@Test
	@Rollback(false)
	public void create() {
		
		
		Employee employee = employeeRepository.find(1);
		MasAddressType addressType = addressTypeRepository.find(1);
		MasProvince province = provinceRepository.find(1);
		Applicant applicant = applicantRepository.find(1);
		
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
        employee.setAuditFlag("C");
        employee.setCreatedBy(1);
        employee.setCreatedTimeStamp(Calendar.getInstance().getTime());
        
        
        Applicant applicant = new Applicant();
		applicant.setCreatedBy(1);
		applicant.setCreatedTimeStamp(Calendar.getInstance().getTime());
		applicant.setAuditFlag("C");
		applicant.setCardId("115310905001-9");
		applicant.setAuditFlag("1");
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
		
		divisionRepository.create(masDivision);
		divisionRepository.find(1);
		employee.setMasDivision(masDivision);
		

		MasJoblevel masJoblevel = new MasJoblevel();
		masJoblevel.setName("CEO");
		masJoblevel.setIsActive(true);
		masJoblevel.setCode("01");
		masJoblevel.setAuditFlag("C");
		masJoblevel.setCreatedBy(1);
		masJoblevel.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masJoblevel.setCode("Division-01");

		joblevelRepository.create(masJoblevel);
		joblevelRepository.find(1);
		
		employee.setMasJoblevel(masJoblevel);
		
		
		employeeRepository.create(employee);
		
		
		Address address = new Address();
		address.setHouseNo("2566nnn");
		address.setRoad("Sukhumvit");
		address.setDistrict("Mung");
		address.setSubDistrict("AmphurMung");
		address.setZipcode(10252);
		address.setAddressType(addressType);
		address.setProvince(province);
		address.setAuditFlag("C");
		address.setCreatedBy(1);
		address.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
		
		addressRepository.create(address);
		
		
	}
	
	@Test
	@Rollback(false)
	public void updateDataAddress() {
		
		Address address = addressRepository.find(1);
		address.setHouseNo("bss528");
		addressRepository.update(address);
	}
	
	@Test
	@Rollback(false)
	public void deleteDataAddress() {
		
		Address address = (Address) addressRepository.getCurrentSession().get(Address.class, 1);
		addressRepository.delete(address);
		
	}
	
	@Test
	@Rollback(false)
	public void findAllDataAddress(){
		
		
		List<Address> addressesList = addressRepository.findAll();
		Assert.assertEquals(3, addressesList.size());
	}
	
	@Test
	public void findByIdAddressType(){
		
		Address address = (Address) addressRepository.getCurrentSession().get(Address.class, 9);		
		int id = address.getId();
		Assert.assertEquals(9, id);
		
	}
	

}
