package repositories;

import java.util.Calendar;
import java.util.List;
import org.hibernate.Criteria;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import com.aug.hrdb.entities.Reference;
import com.aug.hrdb.repositories.ReferenceRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class ReferenceRepositoryTest {
	@Autowired private ReferenceRepository referenceRepository;
	
	@Test
	@Rollback(false)
	public void create(){
		Reference reference = new Reference();
		reference.setAddress("Bangkok");
		reference.setAuditFlag("C");
		reference.setCreatedBy(1);
		reference.setCreatedTimeStamp(Calendar.getInstance().getTime());
		reference.setName("Jutamas");
		reference.setOccupation("Programmer");
		reference.setTel("0817334542");
	}

	@Test
	public void update(){
		Reference reference = (Reference) referenceRepository.getCurrentSession().get(Reference.class,1);
		reference.setOccupation("HR");
		referenceRepository.getCurrentSession().update(reference);
	}
	
	@Test
	public void delete(){
		Reference reference = (Reference) referenceRepository.getCurrentSession().get(Reference.class,1);
		referenceRepository.getCurrentSession().delete(reference);
	}
	
	@Test
	public void findById(){
		Reference reference = (Reference) referenceRepository.getCurrentSession().get(Reference.class,1);
		int id = reference.getId();
		Assert.assertEquals(1, id);
	}
	
	@Test
	public void findAll(){	
		List<Reference> references = referenceRepository.findAll();
		Assert.assertEquals(1, references.size());
	}
}
