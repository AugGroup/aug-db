/**
 *
 * @author Preeyaporn
 * @date 7 ก.ย. 2558
 */
package services;

import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aug.hrdb.entities.MasDivision;
import com.aug.hrdb.services.MasDivisionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-bean-db-test.xml"})
public class MasDivisionServiceTest {

	@Autowired
	private MasDivisionService masDivisionServices;
	
	@Test
	public void createDatamasDivision(){

		MasDivision masDivision = new MasDivision();
		masDivision.setName("PHP");
		masDivision.setCode("004A");
		masDivision.setIsActive(true);
		
		masDivision.setAuditFlag("C");
		masDivision.setCreatedBy(0);
		Calendar cal = Calendar.getInstance();
		masDivision.setCreatedTimeStamp(cal.getTime());
		
		masDivisionServices.create(masDivision);
	}
	
	@Test
	public void updateDatamasDivision(){

		MasDivision masDivision = masDivisionServices.findById(2);
		masDivision.setName("JAVA");
		masDivisionServices.update(masDivision);
		
	}
	
	@Test
	public void deleteDatamasDivision(){

		MasDivision masDivision = masDivisionServices.findById(2);
		masDivisionServices.delete(masDivision);
		
	}
	
	@Test
	public void findbyIdmasDivision(){

		MasDivision  masDivision = masDivisionServices.findById(2);
		Assert.assertEquals("JAVA",masDivision.getName());
		
	}
}
