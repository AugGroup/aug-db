/**
 *
 * @author natechanok
 * @date Sep 4, 2015
 */

package services;

import java.util.Calendar;
import java.util.List;

import junit.framework.Assert;

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
import com.aug.hrdb.entities.MasProvince;
import com.aug.hrdb.entities.Official;
import com.aug.hrdb.services.AddressService;
import com.aug.hrdb.services.ApplicantService;
import com.aug.hrdb.services.EmployeeService;
import com.aug.hrdb.services.MasAddressTypeService;
import com.aug.hrdb.services.MasProvinceService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class AddressServiceTest {
	
	@Autowired
	private AddressService addressService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private MasAddressTypeService addressTypeService;
	@Autowired
	private MasProvinceService provinceService;
	@Autowired ApplicantService applicantService;
	
	
	@Test
	@Rollback(false)
	public void create() {
		
		Employee employee = employeeService.findById(1);
		MasAddressType addressType = addressTypeService.findById(1);
		MasProvince province = provinceService.find(1);
		Applicant applicant = applicantService.findById(1);
		
		
		Address address = new Address();
		address.setHouseNo("158MMMM");
		address.setRoad("PPP");
		address.setDistrict("aaaa");
		address.setSubDistrict("bbbbb");
		address.setZipcode(2588);
		address.setAddressType(addressType);
		address.setProvince(province);
		address.setAuditFlag("C");
		address.setCreatedBy(1);
		address.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
		addressService.create(address);
	}
	
	/*@Test
	@Rollback(false)
	public void updateDataAddress(){
		
		Address address = (Address)addressService.find(13);
		address.setHouseNo("35699nnn");
		addressService.update(address);
		
	}*/
	

/*	@Test
	@Rollback(false)
	public void deleteDataAddress(){
		
		Address address = (Address)addressService.find(13);
		addressService.delete(address);
	}*/
	
	/*@Test
	@Rollback(false)
	public void findAllAddress(){

		List<Address> addresses = addressService.findAll();
		Assert.assertEquals(3, addresses.size());
	}*/
	
	
	
	@Test
	public void findbyIdAddress(){

		Address address =(Address) addressService.findById(14);
		int id = address.getId();
		Assert.assertEquals(14,id);
		
		
		
	}
}
