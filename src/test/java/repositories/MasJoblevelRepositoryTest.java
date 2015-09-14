/**
 *
 * @author Preeyaporn
 * @date 7 ก.ย. 2558
 */
package repositories;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Criteria;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.MasJoblevel;
import com.aug.hrdb.repositories.MasJoblevelRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class MasJoblevelRepositoryTest {

	@Autowired MasJoblevelRepository masJoblevelRepository;
	
	@Test
	public void create() {

		MasJoblevel masJoblevel = new MasJoblevel();
		masJoblevel.setName("CEO");
		masJoblevel.setIsActive(true);
		masJoblevel.setCode("01");
		
		masJoblevel.setAuditFlag("C");
		masJoblevel.setCreatedBy(1);
		masJoblevel.setCreatedTimeStamp(Calendar.getInstance().getTime());

		masJoblevelRepository.getCurrentSession().save(masJoblevel);

	}

//	@Test
//	public void update() {
//
//		MasJoblevel masJoblevel = (MasJoblevel) masJoblevelRepository.getCurrentSession().get(
//				MasJoblevel.class, 1);
//		masJoblevel.setName("IT");
//
//		masJoblevelRepository.getCurrentSession().update(masJoblevel);
//	}
//
//	@Test
//	public void Delete() {
//
//		MasJoblevel masJoblevel = (MasJoblevel) masJoblevelRepository.getCurrentSession().get(
//				MasJoblevel.class, 1);
//
//		masJoblevelRepository.getCurrentSession().delete(masJoblevel);
//	}
//
//	@SuppressWarnings("unchecked")
//	@Test
//	public void list() {
//
//		Criteria c = masJoblevelRepository.getCurrentSession().createCriteria(
//				MasJoblevel.class);
//		List<MasJoblevel> masJoblevels = c.list();
//		Assert.assertEquals(14, masJoblevels.size());
//
//	}
}
