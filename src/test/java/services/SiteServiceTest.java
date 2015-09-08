package services;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.dto.HealthDto;
import com.aug.hrdb.dto.SiteDto;
import com.aug.hrdb.entities.Site;
import com.aug.hrdb.services.SiteService;

import junit.framework.Assert;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class SiteServiceTest {
	
	
	
	@Autowired
	private SiteService siteService;
	
	

	@Test
	@Rollback(false)
	public void create() {
	
		Calendar calendarStartDate = new GregorianCalendar(2013,10,28);	//GregorianCalendar jan=0,12=Jan
		Calendar calendarEndDate = new GregorianCalendar(2014,11,28);

		
		Site site = new Site();
		site.setProjectName("Augmentis-04");
		site.setStartDate(calendarStartDate.getTime());
		site.setEndDate(calendarEndDate.getTime());
		site.setProjectOwner("Augmentis");
		site.setProjectOwnerContact("PM");
		site.setAuditFlag("C");
		site.setCreatedBy(1);
		site.setCreatedTimeStamp(Calendar.getInstance().getTime());
		siteService.create(site);
		
		
		
		
		Site site2 = new Site();
		site2.setProjectName("Augmentis-05");
		site2.setStartDate(calendarStartDate.getTime());
		site2.setEndDate(calendarEndDate.getTime());
		site2.setProjectOwner("Augmentis");
		site2.setProjectOwnerContact("PM");
		site2.setAuditFlag("C");
		site2.setCreatedBy(1);
		site2.setCreatedTimeStamp(Calendar.getInstance().getTime());
		siteService.create(site2);

		
		Site site3 = new Site();
		site3.setProjectName("Augmentis-06");
		site3.setStartDate(calendarStartDate.getTime());
		site3.setEndDate(calendarEndDate.getTime());
		site3.setProjectOwner("Augmentis");
		site3.setProjectOwnerContact("PM");
		site3.setAuditFlag("C");
		site3.setCreatedBy(1);
		site3.setCreatedTimeStamp(Calendar.getInstance().getTime());
		siteService.create(site3);
	}
	
	
	
	@Test
	@Rollback(false)
	public void update() {
				
				Site site = siteService.find(4);
				site.setProjectName("Migrate HrIsSystemRecurement");
				site.setAuditFlag("U");
				site.setUpdatedBy(4);
				site.setUpdatedTimeStamp(Calendar.getInstance().getTime());
				siteService.update(site);
	}
	
	
	
	@Test
	@Rollback(false)
	public void delete() {
				
				Site site = siteService.find(5);
				siteService.delete(site);
	}

	
	
	
	@Test
	@Rollback(false)
	public void deleteById() {
				
				Site site = siteService.find(6);
				siteService.deleteById(site.getId());;
	}
	
	
	@Test
	public void find() {
	
		Site site = siteService.find(4);
		int id = site.getId().intValue();
		Assert.assertEquals(4, id);
	}
	
	
	
	
	
	@Test
	public void findAll() {
	
		List<Site> siteList = siteService.findAll();
		Assert.assertEquals(2, siteList.size());
		
		for(int i=0;i<siteList.size();i++){		
			System.out.println("id: "+siteList.get(i).getId());
		}
	}

	
	
	
	@Test
	@Rollback(false)
	public void createSetDtoToEnity(){
		
		
		Calendar calendarStartDate = new GregorianCalendar(2013,10,28);	//GregorianCalendar jan=0,12=Jan
		Calendar calendarEndDate = new GregorianCalendar(2014,11,28);

		
		SiteDto siteDto = new SiteDto();
		siteDto.setProjectName("Augmentis-07");
		siteDto.setStartDate(calendarStartDate.getTime());
		siteDto.setEndDate(calendarEndDate.getTime());
		siteDto.setProjectOwner("Augmentis");
		siteDto.setProjectOwnerContact("PM");
		siteDto.setEmployeeId(1);
		siteService.createSetDtoToEnity(siteDto);

	}
	
	
	
	
	@Test
	@Rollback(false)
	public void updateSetDtoToEntity(){
		
		
		Calendar calendarStartDate = new GregorianCalendar(2013,10,28);	//GregorianCalendar jan=0,12=Jan
		Calendar calendarEndDate = new GregorianCalendar(2014,11,28);

		
		SiteDto siteDto = new SiteDto();
		siteDto.setId(7);
		siteDto.setProjectName("Project HrSystem");
		siteDto.setStartDate(calendarStartDate.getTime());
		siteDto.setEndDate(calendarEndDate.getTime());
		siteDto.setProjectOwner("Augmentis");
		siteDto.setProjectOwnerContact("PM");
		siteDto.setEmployeeId(1);
		siteService.updateSetDtoToEntity(siteDto);

	
	}
	
	
	
	@Test
	public void findByIdReturnToDto(){
		
		SiteDto siteDto = new SiteDto();
		siteDto = siteService.findByIdReturnToDto(4);
		
		Assert.assertEquals("Migrate HrIsSystemRecurement", siteDto.getProjectName());
		System.out.println("Project Name: "+siteDto.getProjectName());
		
	}



}
