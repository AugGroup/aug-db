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
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.MasJobLevel;
import com.aug.hrdb.repositories.MasJoblevelRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class MasJoblevelRepositoryTest {

	@Autowired MasJoblevelRepository masJoblevelRepository;
	
	int id;
	@Before
	public void setJob(){
		MasJobLevel masJoblevel = new MasJobLevel();
		masJoblevel.setName("PHP");
		masJoblevel.setCode("004A");
		masJoblevel.setIsActive(true);
		
		masJoblevel.setAuditFlag("C");
		masJoblevel.setCreatedBy(0);
		Calendar cal = Calendar.getInstance();
		masJoblevel.setCreatedTimeStamp(cal.getTime());
		
		masJoblevelRepository.create(masJoblevel);
		
		id = masJoblevel.getId();
	}
	
	
	
	@Test
	@Rollback(true)
	public void create() {

		MasJobLevel masJoblevel = new MasJobLevel();
		masJoblevel.setName("CEO");
		masJoblevel.setIsActive(true);
		masJoblevel.setCode("01");
		
		masJoblevel.setAuditFlag("C");
		masJoblevel.setCreatedBy(1);
		masJoblevel.setCreatedTimeStamp(Calendar.getInstance().getTime());

		masJoblevelRepository.getCurrentSession().save(masJoblevel);

	}

	@Test
	@Rollback(true)
	public void update() {

		MasJobLevel masJoblevel = (MasJobLevel) masJoblevelRepository.getCurrentSession().get(
				MasJobLevel.class, id);
		masJoblevel.setName("IT");

		masJoblevelRepository.getCurrentSession().update(masJoblevel);
	}

	@Test
	@Rollback(true)
	public void Delete() {

		MasJobLevel masJoblevel = (MasJobLevel) masJoblevelRepository.getCurrentSession().get(
				MasJobLevel.class, id);

		masJoblevelRepository.delete(masJoblevel);
	}

	
	@Test
	@Rollback(true)
	public void list() {

		Criteria c = masJoblevelRepository.getCurrentSession().createCriteria(
				MasJobLevel.class);
		List<MasJobLevel> masJoblevels = c.list();
		
	}
}
