/**
 *
 * @author natechanok
 * @date Sep 4, 2015
 */

package com.aug.hrdb.repositories;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.hibernate.Hibernate;
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
import com.aug.hrdb.repositories.AddressRepository;
import com.aug.hrdb.repositories.MasAddressTypeRepository;
import com.aug.hrdb.repositories.MasProvinceRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class AddressRepositoryTest {
	
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private MasAddressTypeRepository addressTypeRepository;
	@Autowired
	private MasProvinceRepository provinceRepository;
	
	MasAddressType addressType;
	MasProvince province;
	//MasProvince province = provinceRepository.find(1);
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
		addressTypeRepository.create(addressType);
		idMasAddressType = addressType.getId();
		MasAddressType masAddressType = addressTypeRepository.find(idMasAddressType);
		
		
		province = new MasProvince();
		province.setName("Bangkok");
		province.setCode("B001");
		province.setIsActive(true);
		province.setCreatedBy(1);
		province.setCreatedTimeStamp(Calendar.getInstance().getTime());
		province.setAuditFlag("C");
		provinceRepository.create(province);
		idMasProvice = province.getId();
		MasProvince masProvince = provinceRepository.find(idMasProvice);
		
		

		Address address = new Address();
		address.setHouseNo("2566nnn18");
		address.setRoad("Sukhumvit");
		address.setDistrict("Mung");
		address.setSubDistrict("AmphurMung");
		address.setZipcode(10252);
		address.setAddressType(masAddressType);
		address.setProvince(masProvince);
		address.setAuditFlag("C");
		address.setCreatedBy(1);
		address.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
		
		addressRepository.create(address);
		
		Address address1 = new Address();
		address1.setHouseNo("2566nnn15");
		address1.setRoad("Sukhumvit");
		address1.setDistrict("Mung");
		address1.setSubDistrict("AmphurMung");
		address1.setZipcode(10252);
		address1.setAddressType(masAddressType);
		address1.setProvince(masProvince);
		address1.setAuditFlag("C");
		address1.setCreatedBy(1);
		address1.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
		
		addressRepository.create(address);
		id = address.getId();
		
	}
	
	@Test
	@Rollback(true)
	public void create() {
		
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
	@Rollback(true)
	public void updateDataAddress() {
		
		Address address = addressRepository.find(id);
		address.setRoad("Vipawadee");
		addressRepository.update(address);
	}
	
	@Test
	@Rollback(true)
	public void deleteDataAddress() {
		
		Address address = (Address) addressRepository.getCurrentSession().get(Address.class, id);
		addressRepository.delete(address);
		
	}
	
	@Test
	@Rollback(true)
	public void findAllDataAddress(){
		
		
		List<Address> addressesList = addressRepository.findAll();
	}
	
	@Test
	@Rollback(true)
	public void findByIdAddressType(){
		
		Address address =  addressRepository.find(id);		
		Assert.assertEquals("2566nnn18", address.getHouseNo());
		
	}
	

}
