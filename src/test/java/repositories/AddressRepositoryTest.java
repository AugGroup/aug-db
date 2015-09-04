/**
 *
 * @author natechanok
 * @date Sep 4, 2015
 */

package repositories;

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
import com.aug.hrdb.entities.MasAddressType;
import com.aug.hrdb.repositories.AddressRepository;
import com.jayway.jsonpath.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class AddressRepositoryTest {
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Test
	@Rollback(false)
	public void create() {
		
		Address address = new Address();
		address.setHouseNo("23addd");
		address.setRoad("Sukhumvit");
		address.setDistrict("Mung");
		address.setSubDistrict("AmphurMung");
		address.setZipcode(10252);
		
		addressRepository.create(address);
	}
	
	@Test
	@Rollback(false)
	public void updateDataAddress() {
		
		Address address = (Address) addressRepository.getCurrentSession().get(Address.class, 6);
		address.setHouseNo("102BBB");
		addressRepository.update(address);
	}
	
	@Test
	@Rollback(false)
	public void deleteDataAddress() {
		
		Address address = (Address) addressRepository.getCurrentSession().get(Address.class, 6);
		addressRepository.delete(address);
		
	}
	
	@Test
	@Rollback(false)
	public void findAllDataAddress(){
		
		
		List<Address> addressesList = addressRepository.findAll();
		Assert.assertEquals(1, addressesList.size());
	}
	
	@Test
	public void findByIdAddressType(){
		
		Address address = (Address) addressRepository.getCurrentSession().get(Address.class, 1);		
		int id = address.getId();
		Assert.assertEquals(1, id);
		
	}
	

}
