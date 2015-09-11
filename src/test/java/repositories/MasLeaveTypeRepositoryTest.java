/**
 *
 * @author Pranrajit
 * @date 11 ก.ย. 2558
 */
package repositories;

import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.MasLeaveType;
import com.aug.hrdb.repositories.MasLeaveTypeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class MasLeaveTypeRepositoryTest {

	@Autowired private MasLeaveTypeRepository masLeaveTypeRepository;
	
	@Test
	@Rollback(false)
	public void createMasLeaveType(){
		MasLeaveType masLeaveType=new MasLeaveType();
		masLeaveType.setName("Holiday");
		masLeaveType.setCode("MD-01");
		masLeaveType.setIsactive(true);
		masLeaveType.setAuditFlag("C");
		masLeaveType.setCreatedBy(1);
		masLeaveType.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
		masLeaveTypeRepository.getCurrentSession().save(masLeaveType);
	}
	
	
	/*@Test
	@Rollback(false)
	public void updateMasLeaveType(){ 
		
		MasLeaveType masLeaveType=(MasLeaveType)masLeaveTypeRepository.getCurrentSession().get(MasLeaveType.class, 1);
		masLeaveType.setName("Annual");
		
		masLeaveTypeRepository.getCurrentSession().update(masLeaveType);
	}
	*/
/*	@Test
	@Rollback(false)
	public void deletemasLeaveType(){ 
		MasLeaveType masLeaveType=(MasLeaveType)masLeaveTypeRepository.getCurrentSession().get(MasLeaveType.class,1);
		masLeaveTypeRepository.getCurrentSession().delete(masLeaveType);
		
	}*/
}