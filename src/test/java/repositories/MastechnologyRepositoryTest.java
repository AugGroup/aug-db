package repositories;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Criteria;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.MasTechnology;
import com.aug.hrdb.repositories.MasTechnologyRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-bean-db-test.xml"})
@Transactional
public class MastechnologyRepositoryTest {
	
	@Autowired
	private MasTechnologyRepository masTechnologyRepository;
	
	@Test
	public void createMasTechnology(){
		
		
		MasTechnology masTech = new MasTechnology();
		masTech.setName("java");
		masTech.setCode("001A");
		masTech.setIsActive(true);
		masTech.setAuditFlag("C");
		masTech.setCreatedBy(0);
		Calendar cal = Calendar.getInstance();
		masTech.setCreatedTimeStamp(cal.getTime());
		masTechnologyRepository.getCurrentSession().save(masTech);
		
	}
	
	
	@Test
	public void updateMasTechnology(){
		
		MasTechnology masTech = (MasTechnology) masTechnologyRepository.getCurrentSession().get(MasTechnology.class, 1);
		masTech.setName("SAP");
		masTechnologyRepository.getCurrentSession().update(masTech);
		
	}
	
	
	@Test
	public void deleteMasTechnology(){
		
		MasTechnology masTech = (MasTechnology) masTechnologyRepository.getCurrentSession().get(MasTechnology.class, 1);
		masTechnologyRepository.getCurrentSession().delete(masTech);;
		
	}
	
	
	@Test
	public void findByIdMasTechnology(){
		
		MasTechnology masTechnology = (MasTechnology) masTechnologyRepository.getCurrentSession().get(MasTechnology.class, 1);		
		int id = masTechnology.getId();
		Assert.assertEquals(1, id);
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void list() {

		Criteria c = masTechnologyRepository.getCurrentSession().createCriteria(
				MasTechnology.class);
		List<MasTechnology> masTechnologies = c.list();
		Assert.assertEquals(9, masTechnologies.size());

	}
}
