/**
 *
 * @author Pranrajit
 * @date 4 ก.ย. 2558
 */
package repositories;

import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.MasDegreetype;
import com.aug.hrdb.repositories.MasDegreetypeRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class MasDegreeTypeRepositoryTest {

	@Autowired MasDegreetypeRepository masDegreetypeRepository;
	
	
	@Before
	public void setValue(){
		MasDegreetype masDegreetype=new MasDegreetype();
		masDegreetype.setName("DR");
		masDegreetype.setCode("DE-02");
		masDegreetype.setIsactive(true);
		masDegreetype.setAuditFlag("C");
		masDegreetype.setCreatedBy(1);
		masDegreetype.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masDegreetypeRepository.create(masDegreetype);
		
		
		MasDegreetype masDegreetype1=new MasDegreetype();
		masDegreetype1.setName("DR");
		masDegreetype1.setCode("DE-02");
		masDegreetype1.setIsactive(true);
		masDegreetype1.setAuditFlag("C");
		masDegreetype1.setCreatedBy(1);
		masDegreetype1.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masDegreetypeRepository.create(masDegreetype1);
		
	}
	

	
	
	
	@Test
	@Rollback(false)
	public void createMasDegreeType(){
		MasDegreetype masDegreetype=new MasDegreetype();
		masDegreetype.setName("DR");
		masDegreetype.setCode("DE-02");
		masDegreetype.setIsactive(true);
		masDegreetype.setAuditFlag("C");
		masDegreetype.setCreatedBy(1);
		masDegreetype.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masDegreetypeRepository.create(masDegreetype);
	}

	@Test
	@Rollback(false)
	public void updateMasDegreeType(){
		MasDegreetype masDegreetype=(MasDegreetype)masDegreetypeRepository.getCurrentSession().get(MasDegreetype.class,2);
		masDegreetype.setName("DR");
		masDegreetype.setCode("DE-01");
		masDegreetype.setIsactive(true);
		masDegreetypeRepository.update(masDegreetype);
	}
	

	@Test
	@Rollback(false)
	public void deleteMasDegreeType(){
		MasDegreetype masDegreetype=(MasDegreetype)masDegreetypeRepository.getCurrentSession().get(MasDegreetype.class,1);
		masDegreetypeRepository.getCurrentSession().delete(masDegreetype);
		
	}
	
}
