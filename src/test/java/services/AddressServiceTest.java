/**
 *
 * @author natechanok
 * @date Sep 4, 2015
 */

package services;

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
import com.aug.hrdb.entities.Official;
import com.aug.hrdb.services.AddressService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class AddressServiceTest {
	
	@Autowired
	private AddressService addressService;
	
	@Test
	@Rollback(false)
	public void create() {
		
		Address address = new Address();
		address.setHouseNo("158MMMM");
		address.setRoad("PPP");
		address.setDistrict("aaaa");
		address.setSubDistrict("bbbbb");
		address.setZipcode(2588);
		
		addressService.create(address);
	}
	
	@Test
	@Rollback(false)
	public void updateDataAddress(){
		
		Address address = (Address)addressService.find(7);
		address.setHouseNo("35699nnn");
		addressService.update(address);
		
	}
	

	@Test
	@Rollback(false)
	public void deleteDataAddress(){
		
		Address address = (Address)addressService.find(7);
		addressService.delete(address);
	}
	
	@Test
	@Rollback(false)
	public void findAllAddress(){

		List<Address> addresses = addressService.findAll();
		Assert.assertEquals(2, addresses.size());
	}
	
	
	
	@Test
	public void findbyIdAddress(){

		Address address =(Address) addressService.findById(2);
		int id = address.getId();
		Assert.assertEquals(2,id);
		
		
		
	}
}
