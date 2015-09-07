package repositories;

import java.util.List;

import org.hibernate.Criteria;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
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
	@Rollback(false)
	public void createMasTechnology(){
		
		
		MasTechnology masTech = new MasTechnology();
		masTech.setName("java");
		masTech.setCode("001A");
		masTech.setIsActive(true);
		masTechnologyRepository.getCurrentSession().save(masTech);
		
		
		
		MasTechnology masTech1 = new MasTechnology();
		masTech1.setName(".NET");
		masTech1.setCode("002A");
		masTech1.setIsActive(true);
		masTechnologyRepository.getCurrentSession().save(masTech1);
		
	}
	
	
//	@Test
//	@Rollback(false)
//	public void updateMasTechnology(){
//		
//		MasTechnology masTech = (MasTechnology) masTechnologyRepository.getCurrentSession().get(MasTechnology.class, 1);
//		masTech.setName("SAP");
//		masTechnologyRepository.getCurrentSession().update(masTech);
//		
//	}
//	
//	
//	@Test
//	@Rollback(false)
//	public void deleteMasTechnology(){
//		
//		MasTechnology masTech = (MasTechnology) masTechnologyRepository.getCurrentSession().get(MasTechnology.class, 3);
//		masTechnologyRepository.getCurrentSession().delete(masTech);;
//		
//	}
//	
//	
//	@SuppressWarnings("unchecked")
//	@Test
//	public void listMasTechnology(){
//		
//		Criteria c = masTechnologyRepository.getCurrentSession().createCriteria(MasTechnology.class);
//		List<MasTechnology> masTechnologyList = c.list();
//		Assert.assertEquals(2, masTechnologyList.size());
//		
//	}
//	
//	
//	@Test
//	public void findByIdMasTechnology(){
//		
//		MasTechnology masTechnology = (MasTechnology) masTechnologyRepository.getCurrentSession().get(MasTechnology.class, 1);		
//		int id = masTechnology.getId();
//		Assert.assertEquals(3, id);
//		
//	}
	

}
