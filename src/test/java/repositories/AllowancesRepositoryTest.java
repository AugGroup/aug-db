/**
 *
 * @author Preeyaporn
 * @date 7 ก.ย. 2558
 */
package repositories;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import org.hibernate.Criteria;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.Allowances;
import com.aug.hrdb.entities.MasAllowances;
import com.aug.hrdb.repositories.AllowancesRepository;
import com.aug.hrdb.repositories.MasAllowancesRepository;
import com.aug.hrdb.services.MasAllowancesService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class AllowancesRepositoryTest {

	@Autowired
	private AllowancesRepository allowancesRepository;

	@Autowired
	private MasAllowancesRepository  masAllowancesRepository;
	
	@Test
	public void create() throws ParseException {

		Allowances allowances = new Allowances();
		
		allowances.setAmount(6000d);
		
		MasAllowances masallowances = masAllowancesRepository.find(1);
		allowances.setMasallowances(masallowances);
		
		allowancesRepository.getCurrentSession().save(allowances);

	}

//	@Test
//	public void update() {
//
//		Allowances allowances = (Allowances) allowancesRepository.getCurrentSession().get(
//				Allowances.class, 1);
//		allowances.setAmount(6000d);
//
//		allowancesRepository.getCurrentSession().update(allowances);
//	}
//
//	@Test
//	public void Delete() {
//
//		Allowances allowances = (Allowances) allowancesRepository.getCurrentSession().get(
//				Allowances.class, 1);
//
//		allowancesRepository.getCurrentSession().delete(allowances);
//	}
//
//	@SuppressWarnings("unchecked")
//	@Test
//	public void list() {
//
//		Criteria c = allowancesRepository.getCurrentSession().createCriteria(
//				Allowances.class);
//		List<Allowances> allowances = c.list();
//		Assert.assertEquals(0, allowances.size());
//
//	}
}
