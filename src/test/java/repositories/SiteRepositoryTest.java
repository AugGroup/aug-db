package repositories;

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

import com.aug.hrdb.entities.Health;
import com.aug.hrdb.entities.Site;
import com.aug.hrdb.repositories.SiteRepository;

import junit.framework.Assert;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class SiteRepositoryTest {
	
	@Autowired
	private SiteRepository siteRepository;
	
	

	@Test
	@Rollback(false)
	public void create() {
	
		Calendar calendarStartDate = new GregorianCalendar(2013,10,28);	//GregorianCalendar jan=0,12=Jan
		Calendar calendarEndDate = new GregorianCalendar(2014,11,28);

		
		Site site = new Site();
		site.setProjectName("Augmentis-01");
		site.setStartDate(calendarStartDate.getTime());
		site.setEndDate(calendarEndDate.getTime());
		site.setProjectOwner("Augmentis");
		site.setProjectOwnerContact("PM");
		site.setAuditFlag("C");
		site.setCreatedBy(1);
		site.setCreatedTimeStamp(Calendar.getInstance().getTime());
		siteRepository.create(site);
		
		
		
		
		Site site2 = new Site();
		site2.setProjectName("Augmentis-02");
		site2.setStartDate(calendarStartDate.getTime());
		site2.setEndDate(calendarEndDate.getTime());
		site2.setProjectOwner("Augmentis");
		site2.setProjectOwnerContact("PM");
		site2.setAuditFlag("C");
		site2.setCreatedBy(1);
		site2.setCreatedTimeStamp(Calendar.getInstance().getTime());
		siteRepository.create(site2);

		
		Site site3 = new Site();
		site3.setProjectName("Augmentis-03");
		site3.setStartDate(calendarStartDate.getTime());
		site3.setEndDate(calendarEndDate.getTime());
		site3.setProjectOwner("Augmentis");
		site3.setProjectOwnerContact("PM");
		site3.setAuditFlag("C");
		site3.setCreatedBy(1);
		site3.setCreatedTimeStamp(Calendar.getInstance().getTime());
		siteRepository.create(site3);
	}
	
	
	
	@Test
	@Rollback(false)
	public void update() {
				
				Site site = siteRepository.find(1);
				site.setProjectName("AugHrSystem");
				site.setAuditFlag("U");
				site.setUpdatedBy(1);
				site.setUpdatedTimeStamp(Calendar.getInstance().getTime());
				siteRepository.update(site);
	}
	
	
	
	@Test
	@Rollback(false)
	public void delete() {
				
				Site site = siteRepository.find(2);
				siteRepository.delete(site);
	}

	
	
	
	@Test
	@Rollback(false)
	public void deleteById() {
				
				Site site = siteRepository.find(3);
				siteRepository.deleteById(site.getId());;
	}
	
	
	
	@Test
	public void find() {
	
		Site site = siteRepository.find(1);
		int id = site.getId().intValue();
		Assert.assertEquals(1, id);
	}
	
	
	
	
	
	@Test
	public void findAll() {
	
		List<Site> siteList = siteRepository.findAll();
		Assert.assertEquals(1, siteList.size());
		
		for(int i=0;i<siteList.size();i++){		
			System.out.println("id: "+siteList.get(i).getId());
		}
	}
	

}
