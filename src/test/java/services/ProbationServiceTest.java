package services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aug.hrdb.entities.Probation;
import com.aug.hrdb.services.ProbationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
public class ProbationServiceTest {

	@Autowired private ProbationService probationService;
	
	@Test
	@Ignore
	@Rollback(false)
	public void create() throws ParseException{
		SimpleDateFormat dateFmt = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
		Probation probation = new Probation();
		
		probation.setId(1);
		probation.setDateFrom(dateFmt.parse("04/01/2015"));
		probation.setDateTo(dateFmt.parse("04/01/2015"));
		probation.setName("Jutamas");
		probation.setReason("Good");
		probation.setStatus("Pass");

		probationService.create(probation);
	}
	
	@Test
	@Rollback(false)
	public void findById(){
		Probation probation = probationService.find(1);
	}
	
	@Test
	@Rollback(false)
	public void delete(){
		Probation probation = probationService.find(1);
		probationService.delete(probation);
	}
	
	
	@Test
	public void findAll(){	
		List<Probation> probations = probationService.findAll();
		Assert.assertEquals(1, probations.size());
	}
	
}
