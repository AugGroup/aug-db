/**
 *
 * @author Preeyaporn
 * @date 7 ก.ย. 2558
 */
package services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.Employee;
import com.aug.hrdb.entities.History;
import com.aug.hrdb.services.HistoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class HistoryServiceTest {

	@Autowired
	private HistoryService historyService;
	
	@Test
	public void create() throws ParseException{

		SimpleDateFormat dateFmt = new SimpleDateFormat("dd-MM-yyyy",
				Locale.ENGLISH);
		
		History history = new History();
		history.setPosition("Java");
		history.setSalary(30000d);
		history.setDateOfAdjustment(dateFmt.parse("04-01-2015"));
		
		history.setAuditFlag("C");
		history.setCreatedBy(0);
		Calendar cal = Calendar.getInstance();
		history.setCreatedTimeStamp(cal.getTime());
		
		Employee employee = new Employee();
		employee.setId(1);
		history.setEmployee(employee);
		
		historyService.create(history);
	}
	
	@Test
	public void update(){

		History history = historyService.findById(2);
		history.setPosition(".Net");
		historyService.update(history);
		
	}
	
	@Test
	public void delete(){

		History history = historyService.findById(2);
		historyService.delete(history);
		
	}
	
	
	@Test
	public void findAll(){

		List<History> history = historyService.findAll();
		Assert.assertEquals(2, history.size());
	}
	
}
