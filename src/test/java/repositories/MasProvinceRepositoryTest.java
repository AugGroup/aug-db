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

import com.aug.hrdb.entities.MasProvince;
import com.aug.hrdb.repositories.MasProvinceRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class MasProvinceRepositoryTest {
	@Autowired MasProvinceRepository masProvinceRepository;
	
	@Test
	@Rollback(false)
	public void createMasProvince(){
		MasProvince masProvince = new MasProvince();
		masProvince.setName("Bangkok");
		masProvince.setCode("PRO-01");
		masProvince.setIsActive(true);
		masProvinceRepository.getCurrentSession().save(masProvince);
		
		MasProvince masProvince1 = new MasProvince();
		masProvince1.setName("trad");
		masProvince1.setCode("PRO-02");
		masProvince1.setIsActive(true);
		masProvinceRepository.getCurrentSession().save(masProvince);
	}
	
/*	@Test
	@Rollback(false)
	public void updateMasProvince(){
		
		MasProvince masProvince=(MasProvince)masProvinceRepository.getCurrentSession().get(MasProvince.class,5);
		//System.out.println("id: "+masProvince.getId());
		masProvince.setName("changmai");
		masProvinceRepository.getCurrentSession().update(masProvince);
		
		
	}
	
	@Test
	@Rollback(false)
	public void deleteMasProvince(){
		
		MasProvince masProvince = (MasProvince) masProvinceRepository.getCurrentSession().get(MasProvince.class,5);
		masProvinceRepository.getCurrentSession().delete(masProvince);
	}*/

}
