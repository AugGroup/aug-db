/**
 *
 * @author Preeyaporn
 * @date 7 ก.ย. 2558
 */
package repositories;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

import com.aug.hrdb.entities.Employee;
import com.aug.hrdb.entities.History;
import com.aug.hrdb.repositories.HistoryRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class HistoryRepositoryTest {
	
	@Autowired
	private HistoryRepository historyRepository;

	@Test
	public void create() throws ParseException {

		SimpleDateFormat dateFmt = new SimpleDateFormat("dd-MM-yyyy",
				Locale.ENGLISH);
		
		History history = new History();
		
		history.setPosition("Java");
		history.setSalary(30000d);
		history.setDateOfAdjustment(dateFmt.parse("04-01-2015"));
		
		history.setAuditFlag("C");
		history.setCreatedBy(1);
		history.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
		Employee employee = new Employee();
		employee.setId(1);
		history.setEmployee(employee);
		
		historyRepository.getCurrentSession().save(history);

	}

//	@Test
//	public void update() {
//
//		History history = (History) historyRepository.getCurrentSession().get(
//				History.class, 1);
//		history.setPosition(".Net");
//
//		historyRepository.getCurrentSession().update(history);
//	}
//
//	@Test
//	public void Delete() {
//
//		History history = (History) historyRepository.getCurrentSession().get(
//				History.class, 1);
//
//		historyRepository.getCurrentSession().delete(history);
//	}
//
//	@SuppressWarnings("unchecked")
//	@Test
//	public void list() {
//
//		Criteria c = historyRepository.getCurrentSession().createCriteria(
//				History.class);
//		List<History> histories = c.list();
//		Assert.assertEquals(2, histories.size());
//
//	}
}
