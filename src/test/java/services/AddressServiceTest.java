/**
 *
 * @author natechanok
 * @date Sep 4, 2015
 */

package services;

import java.util.Calendar;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.Address;
import com.aug.hrdb.entities.MasAddressType;
import com.aug.hrdb.entities.MasProvince;
import com.aug.hrdb.services.AddressService;
import com.aug.hrdb.services.MasAddressTypeService;
import com.aug.hrdb.services.MasProvinceService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class AddressServiceTest {
	
	@Autowired
	private AddressService addressService;
	@Autowired
	private MasAddressTypeService addressTypeService;
	@Autowired
	private MasProvinceService provinceService;
	
	MasAddressType addressType;
	MasProvince province;
	
	int idMasAddressType;
	int idMasProvice;
	int id;
	
	@Before
	public void setUp() {
		
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
		address.setHouseNo("1855");
		address.setRoad("Sukhumvit");
		address.setDistrict("Mung");
		address.setSubDistrict("AmphurMung");
		address.setZipcode(10252);
		address.setAddressType(masAddressType);
		address.setProvince(masProvince);
		address.setAuditFlag("C");
		address.setCreatedBy(1);
		address.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
		
		addressService.create(address);
		
		Address address1 = new Address();
		address1.setHouseNo("89555hh");
		address1.setRoad("Sukhumvit");
		address1.setDistrict("Mung");
		address1.setSubDistrict("AmphurMung");
		address1.setZipcode(10252);
		address1.setAddressType(masAddressType);
		address1.setProvince(masProvince);
		address1.setAuditFlag("C");
		address1.setCreatedBy(1);
		address1.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
		
		addressService.create(address);
		id = address.getId();
		
	}
	
	
	@Test
	@Rollback(true)
	public void create() {
		
		Address address = new Address();
		address.setHouseNo("19M");
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
	
	@Test
	@Rollback(true)
	public void updateDataAddress(){
		
		Address address = (Address)addressService.find(id);
		address.setHouseNo("35699nnn");
		addressService.update(address);
		
	}
	

	@Test
	@Rollback(true)
	public void deleteDataAddress(){
		
		Address address = (Address)addressService.find(id);
		addressService.delete(address);
	}
	
	@Test
	@Rollback(true)
	public void findAllAddress(){

		List<Address> addresses = addressService.findAll();
		
	}
	
	
	
	@Test
	@Rollback(true)
	public void findbyIdAddress(){

		Address address =(Address) addressService.findById(id);
		Assert.assertEquals("1855", address.getHouseNo());
		
	}
}
