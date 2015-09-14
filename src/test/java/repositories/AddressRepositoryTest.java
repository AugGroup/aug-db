/**
 *
 * @author natechanok
 * @date Sep 4, 2015
 */

package repositories;

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
import com.aug.hrdb.repositories.AddressRepository;
import com.aug.hrdb.repositories.ApplicantRepository;
import com.aug.hrdb.repositories.EmployeeRepository;
import com.aug.hrdb.repositories.MasAddressTypeRepository;
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
	
	@Test
	@Rollback(false)
	public void create() {
		
		
		Employee employee = employeeRepository.find(1);
		MasAddressType addressType = addressTypeRepository.find(1);
		MasProvince province = provinceRepository.find(1);
		Applicant applicant = applicantRepository.find(1);
		
		
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
	
	/*@Test
	@Rollback(false)
	public void updateDataAddress() {
		
		Address address = addressRepository.find(1);
		address.setHouseNo("bss528");
		addressRepository.update(address);
	}*/
	
	/*@Test
	@Rollback(false)
	public void deleteDataAddress() {
		
		Address address = (Address) addressRepository.getCurrentSession().get(Address.class, 1);
		addressRepository.delete(address);
		
	}*/
	
	/*@Test
	@Rollback(false)
	public void findAllDataAddress(){
		
		
		List<Address> addressesList = addressRepository.findAll();
		Assert.assertEquals(3, addressesList.size());
	}*/
	
	@Test
	public void findByIdAddressType(){
		
		Address address = (Address) addressRepository.getCurrentSession().get(Address.class, 9);		
		int id = address.getId();
		Assert.assertEquals(9, id);
		
	}
	

}
