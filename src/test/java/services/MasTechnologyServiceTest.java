package services;

import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.MasTechnology;
import com.aug.hrdb.services.MasTechnologyService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-bean-db-test.xml"})
@Transactional
public class MasTechnologyServiceTest {
	
	@Autowired
	private MasTechnologyService masTechService;
	
	@Test
	public void createDataMasTechnology(){

		MasTechnology masTech = new MasTechnology();
		masTech.setName("PHP");
		masTech.setCode("004A");
		masTech.setIsActive(true);
		
		masTech.setAuditFlag("C");
		masTech.setCreatedBy(0);
		Calendar cal = Calendar.getInstance();
		masTech.setCreatedTimeStamp(cal.getTime());
		
		masTechService.create(masTech);
	}
	
	@Test
	public void updateDataMasTechnology(){

		MasTechnology masTech = masTechService.find(2);
		masTech.setName("JAVA");
		masTechService.update(masTech);
		
	}
	
	@Test
	public void deleteDataMasTechnology(){

		MasTechnology masTech = masTechService.find(2);
		masTechService.delete(masTech);
		
	}
	
	@Test
	public void findDatabyIdMasTechnology(){

		MasTechnology  masTech = masTechService.find(2);
		Assert.assertEquals("JAVA",masTech.getName());
		
		
	}
	
	@Test
	public void findAllDataMasTechnology(){

		List<MasTechnology> masTech = masTechService.findAll();
		Assert.assertEquals(15, masTech.size());
	}

}
