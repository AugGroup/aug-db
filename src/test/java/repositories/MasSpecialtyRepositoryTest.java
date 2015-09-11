package repositories;

import java.util.List;
import org.hibernate.Criteria;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.MasSpecialty;
import com.aug.hrdb.repositories.MasSpecialtyRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class MasSpecialtyRepositoryTest {
	
	@Autowired
	private MasSpecialtyRepository masSpecialtyRepository;
	
	
//	@Test
//	@Rollback(false)
//	public void createMasSpecialty(){
//		MasSpecialty masSpecialty=new MasSpecialty();
//   //	masSpecialty.setEmployee(null);
//		masSpecialty.setName("Java");
//		masSpecialty.setCode("01");
//		masSpecialty.setIsActive(true);
//		masSpecialtyRepository.getCurrentSession().save(masSpecialty);
//	}
	
	
//	@Test
//	@Rollback(false)
//	public void updateMasSpecialty(){
//		
//		MasSpecialty masSpecialty = (MasSpecialty)masSpecialtyRepository.find(1);
//		masSpecialty.setName(".net");
//		masSpecialty.setCode("02");
//		masSpecialty.setIsActive(true);
//		masSpecialtyRepository.update(masSpecialty);
//	}
//	
	
//	@Test
//	@Rollback(false)
//	public void deleteMasSpecialty(){
//		
//		MasSpecialty masSpecialty = (MasSpecialty) masSpecialtyRepository.getCurrentSession().get(MasSpecialty.class,1);
//		masSpecialtyRepository.getCurrentSession().delete(masSpecialty);
//	}
//	
	
//	@Test
//	public void listMasSpecialty(){
//		
//		Criteria c = masSpecialtyRepository.getCurrentSession().createCriteria(MasSpecialty.class);
//		List<MasSpecialty> MasSpecialtyList = c.list();
//		Assert.assertEquals(2, MasSpecialtyList.size());
//		
//	}

	
//	@Test
//	public void findByIdMasSpecialty(){
//		
//		MasSpecialty masSpecialty = (MasSpecialty) masSpecialtyRepository.getCurrentSession().get(MasSpecialty.class, 1);		
//		int id = masSpecialty.getId();
//		Assert.assertEquals(1, id);
//		
//	}

}
