/**
 *
 * @author Pranrajit
 * @date 14 ก.ย. 2558
 */
package services;

import java.util.Calendar;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Test
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
	
	/*@Test
	public void update(){
		MasLeaveType masLeaveType=(MasLeaveType)masLeaveTypeService.find(3);
		masLeaveType.setName("Annual");
		
		masLeaveTypeService.update(masLeaveType);
	}
	*/
	
	/*@Test
	public void delete(){
		MasLeaveType masLeaveType=(MasLeaveType)masLeaveTypeService.find(4);
		masLeaveTypeService.delete(masLeaveType);
	}*/
	
	/*@SuppressWarnings("deprecation")
	@Test
	public void findAll(){
		List<MasLeaveType>masLeaveTypes=masLeaveTypeService.findAll();
		Assert.assertEquals(6,masLeaveTypes.size());
		
	}*/
	
	/*@SuppressWarnings("deprecation")
	@Test
	public void findById(){
		MasLeaveType masLeaveType=(MasLeaveType)masLeaveTypeService.find(5);
		int id = masLeaveType.getId();
		Assert.assertEquals(5,id);
		
	}*/
}
