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

import com.aug.hrdb.entities.MasAddressType;
import com.aug.hrdb.repositories.MasAddressTypeRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class MasAddressTypeRepositoryTest {
	
	@Autowired
	private MasAddressTypeRepository masAddressTypeRepository;
	
	@Test
	@Rollback(false)
	public void createMasAddressType() {
		
		MasAddressType masAddressType = new MasAddressType();
		masAddressType.setName("Present Address");
		masAddressType.setCode("B02");
		masAddressType.setIsactive("1");
		
		masAddressTypeRepository.getCurrentSession().save(masAddressType);
		
		
	}
	
	@Test
	@Rollback(false)
	public void updateAddressType() {
		
		MasAddressType masAddressType = (MasAddressType) masAddressTypeRepository.getCurrentSession().get(MasAddressType.class, 1);
		masAddressType.setName("MMMMM");
		masAddressTypeRepository.update(masAddressType);
		
	}
	
	@Test
	@Rollback(false)
	public void deleteAddressType() {
		
		MasAddressType masAddressType = (MasAddressType) masAddressTypeRepository.getCurrentSession().get(MasAddressType.class, 1);
		masAddressTypeRepository.delete(masAddressType);
		
	}
	
	@Test
	public void findByIdAddressType(){
		
		MasAddressType masAddressType = (MasAddressType) masAddressTypeRepository.getCurrentSession().get(MasAddressType.class, 1);		
		int id = masAddressType.getId();
		Assert.assertEquals(1, id);
		
	}
	
	@Test
	@Rollback(false)
	public void findAllMasAddressType(){
		
		
		List<MasAddressType> masaddressesTypeList = masAddressTypeRepository.findAll();
		Assert.assertEquals(1, masaddressesTypeList.size());
	}
	

}
