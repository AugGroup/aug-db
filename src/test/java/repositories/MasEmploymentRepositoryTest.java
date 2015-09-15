/**
 *
 * @author natechanok
 * @date Sep 4, 2015
 */

package repositories;

import java.util.Calendar;
import java.util.List;

import junit.framework.Assert;

import org.hibernate.Criteria;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.MasEmployment;
import com.aug.hrdb.repositories.MasEmploymentRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class MasEmploymentRepositoryTest {
	
	@Autowired
	private MasEmploymentRepository masEmploymentRepository;
	
	int id;
	
	@Before
	public void setUp(){
		MasEmployment masEmployment = new MasEmployment();
		masEmployment.setName("BBBBBvv");
		masEmployment.setCode("B05");
		masEmployment.setIsActive(true);
		masEmployment.setAuditFlag("C");
		masEmployment.setCreatedBy(1);
		masEmployment.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
		masEmploymentRepository.create(masEmployment);
		
		id=masEmployment.getId();
		
	}
	
	
	@Test
	@Rollback(true)
	public void create() {
		
		MasEmployment masEmployment = new MasEmployment();
		masEmployment.setName("BBBBB");
		masEmployment.setCode("B05");
		masEmployment.setIsActive(true);
		masEmployment.setAuditFlag("C");
		masEmployment.setCreatedBy(1);
		masEmployment.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
		masEmploymentRepository.getCurrentSession().save(masEmployment);
		
	}
	
	@Test
	@Rollback(true)
	public void updateMasEmployment(){
	
		
		
		MasEmployment masEmployment = masEmploymentRepository.find(id);
			masEmployment.setName("Office");
			masEmploymentRepository.getCurrentSession().update(masEmployment);
	}
	
	@Test
	@Rollback(true)
	public void deleteMasEmployment(){
		MasEmployment masEmployment = (MasEmployment) masEmploymentRepository.getCurrentSession().get(MasEmployment.class,id);
		masEmploymentRepository.getCurrentSession().delete(masEmployment);
	}

	@Test
	@Rollback(true)
	public void listMasEmployment(){
		Criteria cri= masEmploymentRepository.getCurrentSession().createCriteria(MasEmployment.class);
		List<MasEmployment> masEmploymentList = cri.list();
	}
	
	@Test
	@Rollback(true)
	public void findByIdMasEmployment(){
		
		MasEmployment masEmployment = (MasEmployment) masEmploymentRepository.getCurrentSession().get(MasEmployment.class, 1);		
		Assert.assertEquals("Permanent", masEmployment.getName());
		
	}
}
