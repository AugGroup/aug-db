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

import com.aug.hrdb.entities.MasAddressType;
import com.aug.hrdb.services.MasAddressTypeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class MasAddressTypeServiceTest {
	
	@Autowired
	private MasAddressTypeService masAddressTypeService;
	
	int id;
	
	@Before
	public void setUp() {
		
		MasAddressType masAddressType = new MasAddressType();
		masAddressType.setName("Present Address");
		masAddressType.setCode("B02");
		masAddressType.setIsActive(true);
		masAddressType.setAuditFlag("C");
		masAddressType.setCreatedBy(1);
		masAddressType.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
		masAddressTypeService.create(masAddressType);
		
		id = masAddressType.getId();
	}
	
	@Test
	@Rollback(true)
	public void createAddressType() {
		
		MasAddressType masAddressType = new MasAddressType();
		masAddressType.setName("Present Address");
		masAddressType.setCode("B02");
		masAddressType.setIsActive(true);
		masAddressType.setAuditFlag("C");
		masAddressType.setCreatedBy(1);
		masAddressType.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
		masAddressTypeService.create(masAddressType);
	}
	
	@Test
	@Rollback(true)
	public void updateAddressType() {
		
		MasAddressType masAddressType = (MasAddressType) masAddressTypeService.findById(id);
		masAddressType.setName("MMMMM");
		masAddressTypeService.update(masAddressType);
		
	}
	
	@Test
	@Rollback(true)
	public void deleteAddressType() {
		
		MasAddressType masAddressType = (MasAddressType) masAddressTypeService.findById(id);
		masAddressTypeService.delete(masAddressType);
		
	}
	
	@Test
	@Rollback(true)
	public void findAllAddressType(){

		List<MasAddressType> masAddressType = masAddressTypeService.findAll();
	}
	
	
	
	@Test
	@Rollback(true)
	public void findbyIdAddressType(){

		MasAddressType masAddressType =(MasAddressType) masAddressTypeService.findById(id);
		Assert.assertEquals(id,id);
		
		
		
	}

}
