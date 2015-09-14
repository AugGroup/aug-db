/**
 *
 * @author Pranrajit
 * @date 14 ก.ย. 2558
 */
package services;

import java.util.Calendar;
import java.util.List;




import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.MasLeaveType;
import com.aug.hrdb.services.MasLeaveTypeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class MasLeaveTypeServiceTest {
	@Autowired MasLeaveTypeService masLeaveTypeService;

	
	
	
	@Before
	public void setValue(){
		MasLeaveType masLeaveType=new MasLeaveType();
		masLeaveType.setName("Holiday1");
		masLeaveType.setCode("MD-01");
		masLeaveType.setIsactive(true);
		masLeaveType.setAuditFlag("C");
		masLeaveType.setCreatedBy(1);
		masLeaveType.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masLeaveTypeService.create(masLeaveType);
		
		
		
		MasLeaveType masLeaveType1=new MasLeaveType();
		masLeaveType1.setName("Holiday1");
		masLeaveType1.setCode("MD-01");
		masLeaveType1.setIsactive(true);
		masLeaveType1.setAuditFlag("C");
		masLeaveType1.setCreatedBy(1);
		masLeaveType1.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
		masLeaveTypeService.create(masLeaveType1);
	}
	
	@Test
	@Rollback(false)
	public void create(){
		MasLeaveType masLeaveType=new MasLeaveType();
		masLeaveType.setName("DR");
		masLeaveType.setCode("DE-02");
		masLeaveType.setIsactive(true);
		masLeaveType.setAuditFlag("C");
		masLeaveType.setCreatedBy(1);
		masLeaveType.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masLeaveTypeService.create(masLeaveType);
		
	}
	
	@Test
	@Rollback(false)
	public void update(){
		MasLeaveType masLeaveType=(MasLeaveType)masLeaveTypeService.find(3);
		masLeaveType.setName("Annual");
		
		masLeaveTypeService.update(masLeaveType);
	}
	
	
	@Test
	@Rollback(false)
	public void delete(){
		MasLeaveType masLeaveType=(MasLeaveType)masLeaveTypeService.find(1);
		masLeaveTypeService.delete(masLeaveType);
	}
	
	
	@Test
	@Rollback(false)
	public void findAll(){
		List<MasLeaveType>masLeaveTypes=masLeaveTypeService.findAll();
		Assert.assertEquals(6,masLeaveTypes.size());
		
	}
	

	@Test
	@Rollback(false)
	public void findById(){
		MasLeaveType masLeaveType=(MasLeaveType)masLeaveTypeService.find(2);
		int id = masLeaveType.getId();
		Assert.assertEquals(2,id);
		
	}
}
