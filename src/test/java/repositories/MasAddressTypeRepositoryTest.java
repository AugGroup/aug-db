/**
 *
 * @author natechanok
 * @date Sep 4, 2015
 */

package repositories;

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
import com.aug.hrdb.repositories.MasAddressTypeRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class MasAddressTypeRepositoryTest {
	
	@Autowired
	private MasAddressTypeRepository masAddressTypeRepository;
	
	@Before
	public void setUp() {
		
		MasAddressType masAddressType = new MasAddressType();
		masAddressType.setName("Present Address");
		masAddressType.setCode("B02");
		masAddressType.setIsActive(true);
		masAddressType.setAuditFlag("C");
		masAddressType.setCreatedBy(1);
		masAddressType.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
		masAddressTypeRepository.create(masAddressType);
	}
	
	@Test
	@Rollback(true)
	public void createMasAddressType() {
		
		MasAddressType masAddressType = new MasAddressType();
		masAddressType.setName("Present Address");
		masAddressType.setCode("B02");
		masAddressType.setIsActive(true);
		masAddressType.setAuditFlag("C");
		masAddressType.setCreatedBy(1);
		masAddressType.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
		masAddressTypeRepository.getCurrentSession().save(masAddressType);
		
		
	}
	
	@Test
	@Rollback(true)
	public void updateAddressType() {
		
		MasAddressType masAddressType = (MasAddressType) masAddressTypeRepository.getCurrentSession().get(MasAddressType.class, 1);
		masAddressType.setName("MMMMM");
		masAddressTypeRepository.update(masAddressType);
		
	}
	
	@Test
	@Rollback(true)
	public void deleteAddressType() {
		
		MasAddressType masAddressType = (MasAddressType) masAddressTypeRepository.getCurrentSession().get(MasAddressType.class, 2);
		masAddressTypeRepository.delete(masAddressType);
		
	}
	
	@Test
	@Rollback(true)
	public void findByIdAddressType(){
		
		MasAddressType masAddressType = (MasAddressType) masAddressTypeRepository.getCurrentSession().get(MasAddressType.class, 1);		
		int id = masAddressType.getId();
		Assert.assertEquals(1, id);
		
	}
	
	@Test
	@Rollback(true)
	public void findAllMasAddressType(){
		
		
		List<MasAddressType> masaddressesTypeList = masAddressTypeRepository.findAll();
		Assert.assertEquals(5, masaddressesTypeList.size());
	}
	

}
