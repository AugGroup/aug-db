/**
 *
 * @author Preeyaporn
 * @date 7 ก.ย. 2558
 */
package repositories;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.MasAllowance;
import com.aug.hrdb.repositories.MasAllowanceRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
@TransactionConfiguration
public class MasAllowanceRepositoryTest {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private MasAllowanceRepository masAllowancesRepository;
	
	int id;
	
	MasAllowance masAllowances;
	
	@Before
	public void setAllowan(){
		MasAllowance masAllowances = new MasAllowance();
		
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

		MasAllowance masAllowances = new MasAllowance();
		
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

		MasAllowance masAllowances = (MasAllowance) masAllowancesRepository.getCurrentSession().get(
				MasAllowance.class, id);
		masAllowances.setAllowances_type("Father");

		masAllowancesRepository.update(masAllowances);
	}

	@Test
	@Rollback(true)
	public void Delete() {

		MasAllowance masAllowances = (MasAllowance) masAllowancesRepository.getCurrentSession().get(
				MasAllowance.class, id);

		masAllowancesRepository.delete(masAllowances);
	}

	
	@Test
	
	public void list() {

		Criteria c = masAllowancesRepository.getCurrentSession().createCriteria(
				MasAllowance.class);
		List<MasAllowance> masAllowances = c.list();
		

	}
}
