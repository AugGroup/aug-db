/**
 *
 * @author Pranrajit
 * @date 4 ก.ย. 2558
 */
package repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.MasLocation;
import com.aug.hrdb.repositories.MasLocationRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class MasLocationRepositoryTest {
	
	@Autowired MasLocationRepository masLocationRepository;

	@Test
	@Rollback(false)
	public void createMasLocation(){
		MasLocation masLocation = new MasLocation();
		masLocation.setName("thailand");
		masLocation.setCode("LO-01");
		masLocation.setIsActive(true);
	    masLocationRepository.getCurrentSession().save(masLocation);
		
	}
	
	/*@Test
	@Rollback(false)
	public void updateMasLocation(){ 
	MasLocation masLocation=(MasLocation)masLocationRepository.getCurrentSession().get(MasLocation.class,1);
	masLocation.setName("singpore");
	masLocationRepository.getCurrentSession().update(masLocation);
	}
	
	@Test
	@Rollback(false)
	public void deleteMasLocation(){ 
		MasLocation masLocation=(MasLocation)masLocationRepository.getCurrentSession().get(MasLocation.class,1);
		masLocationRepository.getCurrentSession().delete(masLocation);
	}*/
	
}
