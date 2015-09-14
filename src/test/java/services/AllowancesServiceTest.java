/**
 *
 * @author Preeyaporn
 * @date 7 ก.ย. 2558
 */
package services;

import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.Allowances;
import com.aug.hrdb.entities.Employee;
import com.aug.hrdb.entities.MasAllowances;
import com.aug.hrdb.services.AllowancesService;
import com.aug.hrdb.services.MasAllowancesService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class AllowancesServiceTest {

	@Autowired
	private AllowancesService allowancesService;
	
	@Autowired
	private MasAllowancesService masAllowancesService;
	
	@Test
	public void create() throws ParseException{

		Allowances allowances = new Allowances();
		
		allowances.setAmount(6000d);
		
		allowances.setAuditFlag("C");
		allowances.setCreatedBy(0);
		Calendar cal = Calendar.getInstance();
		allowances.setCreatedTimeStamp(cal.getTime());
		
		MasAllowances masAllowances = new MasAllowances();
		masAllowances = masAllowancesService.find(1);
		allowances.setMasallowances(masAllowances);
		
		Employee employee = new Employee();
		employee.setId(1);
		allowances.setEmployee(employee);
		
		allowancesService.create(allowances);
	}
	
	@Test
	public void update(){

		Allowances allowances = allowancesService.findById(2);
		allowances.setAmount(600077d);
		allowancesService.update(allowances);
		
	}
	
	@Test
	public void delete(){

		Allowances allowances = allowancesService.findById(2);
		allowancesService.delete(allowances);
		
	}
	
	@Test
	public void findAllData(){

		List<Allowances> allowances = allowancesService.findAll();
		Assert.assertEquals(2, allowances.size());
	}
	
	@Test
	public void findDatabyId(){

		Allowances allowances =(Allowances) allowancesService.findById(2);
		int id = allowances.getId();
		Assert.assertEquals(2,id);
		
	}
	
	@Test
	public void deleteDatabyId(){
		allowancesService.deleteById(2);
	}
	
	
}
