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
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.Employee;
import com.aug.hrdb.entities.Probation;
import com.aug.hrdb.services.EmployeeService;
import com.aug.hrdb.services.ProbationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class ProbationServiceTest {

	@Autowired private ProbationService probationService;
	@Autowired private EmployeeService employeeService;
	
	@Test
	@Rollback(true)
	public void create() throws ParseException{
		SimpleDateFormat dateFmt = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
		Probation probation = new Probation();
		//probation.setId(1);
		probation.setAuditFlag("C");
		probation.setCreatedBy(1);
		probation.setCreatedTimeStamp(Calendar.getInstance().getTime());
		probation.setDateFrom(dateFmt.parse("04/01/2015"));
		probation.setDateTo(dateFmt.parse("04/01/2015"));
		probation.setReason("Good");
		probation.setStatus("Pass");
		probation.setEmployee(employeeService.findById(1));
		probationService.create(probation);
	}
	
	@Test
//	@Rollback(false)
	public void update(){
		Probation probation = probationService.find(1);
		probation.setStatus("Not Pass");
		probationService.update(probation);
	}
	
	
	@Test
//	@Rollback(false)
	public void findById(){
		Probation probation = probationService.find(1);
		int id = probation.getId();
		Assert.assertEquals(1,id);
	}
	
	@Test
//	@Rollback(false)
	public void delete(){
		Probation probation = probationService.find(1);
		probationService.delete(probation);
	}
	
	@Test
	public void findAll(){	
		List<Probation> probations = probationService.findAll();
		Assert.assertEquals(2, probations.size());
	}
	
	
	
}
