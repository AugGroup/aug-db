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

import com.aug.hrdb.entities.MasAllowances;
import com.aug.hrdb.repositories.MasAllowancesRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class MasAllowancesRepositoryTest {

	@Autowired
	private MasAllowancesRepository masAllowancesRepository;

	
	
	int id;
	
	@Before
	public void setAllowan(){
MasAllowances masAllowances = new MasAllowances();
		
		masAllowances.setAllowances_type("Mother");
		masAllowances.setAmount_allowances(40000d);
		masAllowances.setCode("004A");
		masAllowances.setIsactive(true);
		
		masAllowances.setAuditFlag("C");
		masAllowances.setCreatedBy(1);
		masAllowances.setCreatedTimeStamp(Calendar.getInstance().getTime());

		masAllowancesRepository.create(masAllowances);
		id = masAllowances.getId();
		
	}
	
	
	@Test
	@Rollback(true)
	public void create() {

		MasAllowances masAllowances = new MasAllowances();
		
		masAllowances.setAllowances_type("Mother");
		masAllowances.setAmount_allowances(40000d);
		masAllowances.setCode("004A");
		masAllowances.setIsactive(true);
		
		masAllowances.setAuditFlag("C");
		masAllowances.setCreatedBy(1);
		masAllowances.setCreatedTimeStamp(Calendar.getInstance().getTime());

		masAllowancesRepository.create(masAllowances);
		
	}

	@Test
	@Rollback(true)
	public void update() {

		MasAllowances masAllowances = (MasAllowances) masAllowancesRepository.getCurrentSession().get(
				MasAllowances.class, id);
		masAllowances.setAllowances_type("Father");

		masAllowancesRepository.update(masAllowances);
	}

	@Test
	@Rollback(true)
	public void Delete() {

		MasAllowances masAllowances = (MasAllowances) masAllowancesRepository.getCurrentSession().get(
				MasAllowances.class, id);

		masAllowancesRepository.delete(masAllowances);
	}

	
	@Test
	
	public void list() {

		Criteria c = masAllowancesRepository.getCurrentSession().createCriteria(
				MasAllowances.class);
		List<MasAllowances> masAllowances = c.list();
		

	}
}
