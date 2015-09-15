/**
 *

 * @author Pranrajit
 * @date 4 ก.ย. 2558
 */
package repositories;

import java.util.Calendar;

import org.junit.Before;
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

	
	@Before
	public void setValue(){
		MasLocation masLocation = new MasLocation();
		masLocation.setName("thailand");
		masLocation.setCode("LO-01");
		masLocation.setIsActive(true);
		masLocation.setAuditFlag("C");
		masLocation.setCreatedBy(1);
		masLocation.setCreatedTimeStamp(Calendar.getInstance().getTime());	
	    masLocationRepository.create(masLocation);
	    
	    
	    MasLocation masLocation1 = new MasLocation();
		masLocation1.setName("thailand");
		masLocation1.setCode("LO-01");
		masLocation1.setIsActive(true);
		masLocation1.setAuditFlag("C");
		masLocation1.setCreatedBy(1);
		masLocation1.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
	    masLocationRepository.create(masLocation1);
		
	}
	
	@Test
	@Rollback(true)
	public void createMasLocation(){
		MasLocation masLocation = new MasLocation();
		masLocation.setName("thailand");
		masLocation.setCode("LO-01");
		masLocation.setIsActive(true);
		masLocation.setAuditFlag("C");
		masLocation.setCreatedBy(1);
		masLocation.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
	    masLocationRepository.create(masLocation);
		
	}
	
	@Test
	@Rollback(true)
	public void updateMasLocation(){ 
	MasLocation masLocation=(MasLocation)masLocationRepository.getCurrentSession().get(MasLocation.class,1);
	masLocation.setName("singpore");
	masLocationRepository.update(masLocation);
	}
	
	@Test
	@Rollback(true)
	public void deleteMasLocation(){ 
		MasLocation masLocation=(MasLocation)masLocationRepository.getCurrentSession().get(MasLocation.class,1);
		masLocationRepository.delete(masLocation);
	}
	
}
