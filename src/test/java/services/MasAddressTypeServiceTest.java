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

import com.aug.hrdb.entities.MasAddressType;
import com.aug.hrdb.entities.Official;
import com.aug.hrdb.services.MasAddressTypeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class MasAddressTypeServiceTest {
	
	@Autowired
	private MasAddressTypeService masAddressTypeService;
	
	@Test
	@Rollback(false)
	public void createAddressType() {
		
		MasAddressType masAddressType = new MasAddressType();
		masAddressType.setName("Present Address");
		masAddressType.setCode("B02");
		masAddressType.setIsactive("1");
		
		masAddressTypeService.create(masAddressType);
	}
	
	@Test
	@Rollback(false)
	public void updateAddressType() {
		
		MasAddressType masAddressType = (MasAddressType) masAddressTypeService.findById(1);
		masAddressType.setName("MMMMM");
		masAddressTypeService.update(masAddressType);
		
	}
	
	@Test
	@Rollback(false)
	public void deleteAddressType() {
		
		MasAddressType masAddressType = (MasAddressType) masAddressTypeService.findById(1);
		masAddressTypeService.delete(masAddressType);
		
	}
	
	@Test
	@Rollback(false)
	public void findAllAddressType(){

		List<MasAddressType> ability = masAddressTypeService.findAll();
		Assert.assertEquals(2, ability.size());
	}
	
	
	
	@Test
	public void findbyIdAddressType(){

		MasAddressType masAddressType =(MasAddressType) masAddressTypeService.findById(2);
		int id = masAddressType.getId();
		Assert.assertEquals(2,id);
		
		
		
	}

}
