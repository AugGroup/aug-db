/**
 *
 * @author natechanok
 * @date Sep 4, 2015
 */

package repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.MasEmployment;
import com.aug.hrdb.repositories.MasEmploymentRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class MasEmploymentRepositoryTest {
	
	@Autowired
	private MasEmploymentRepository masEmploymentRepository;
	
	@Test
	@Rollback(false)
	public void create() {
		
		MasEmployment masEmployment = new MasEmployment();
		masEmployment.setName("AAAA");
		masEmployment.setCode("B05");
		masEmployment.setIsActive(true);
		
		masEmploymentRepository.getCurrentSession().save(masEmployment);
		
	}
	
	@Test
	@Rollback(false)
	public void updateMasEmployment(){
		
		MasEmployment masEmployment = (MasEmployment) masEmploymentRepository.getCurrentSession().get(MasEmployment.class, 3);
			masEmployment.setName("Office");
			masEmploymentRepository.getCurrentSession().update(masEmployment);
	}
	
	@Test
	@Rollback(false)
	public void deleteMasEmployment(){
		MasEmployment masEmployment = (MasEmployment) masEmploymentRepository.getCurrentSession().get(MasEmployment.class, 1);
		masEmploymentRepository.getCurrentSession().delete(masEmployment);;
	}

	/*@Test
	public void listMasEmployment(){
		Criteria cri= masEmploymentDao.getCurrentSession().createCriteria(MasEmployment.class);
		List<MasEmployment> masEmploymentList = cri.list();
		Assert.assertEquals(1, masEmploymentList.size());
	}
	
	@Test
	public void findByIdMasEmployment(){
		
		MasEmployment masEmployment = (MasEmployment) masEmploymentDao.getCurrentSession().get(MasEmployment.class, 1);		
		int id = masEmployment.getId();
		Assert.assertEquals(1, id);
		
	}*/
}
