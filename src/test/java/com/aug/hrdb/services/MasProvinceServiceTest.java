/**
 *
 * @author natechanok
 * @date Sep 11, 2015
 */

package com.aug.hrdb.services;

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

import com.aug.hrdb.entities.MasProvince;
import com.aug.hrdb.repositories.MasProvinceRepository;
import com.aug.hrdb.services.MasProvinceService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class MasProvinceServiceTest {

	
		@Autowired private MasProvinceService masProvinceService;
		
		
		
		int id;
		
		@Before
		public void setProvince(){
			MasProvince masProvince = new MasProvince();
			masProvince.setName("Bangkok");
			masProvince.setCode("PRO-01");
			masProvince.setIsActive(true);
			masProvince.setAuditFlag("C");
			masProvince.setCreatedBy(1);
			masProvince.setCreatedTimeStamp(Calendar.getInstance().getTime());
			masProvinceService.create(masProvince);
			
			id = masProvince.getId();
			
		}
		
		
		@Test
		@Rollback(true)
		public void createMasProvince(){
			
			MasProvince masProvince = new MasProvince();
			masProvince.setName("Bangkok");
			masProvince.setCode("PRO-01");
			masProvince.setIsActive(true);
			masProvince.setAuditFlag("C");
			masProvince.setCreatedBy(1);
			masProvince.setCreatedTimeStamp(Calendar.getInstance().getTime());
			
			masProvinceService.create(masProvince);
			
			
			
			MasProvince masProvince1 = new MasProvince();
			masProvince1.setName("trad");
			masProvince1.setCode("PRO-02");
			masProvince1.setIsActive(true);
			masProvince1.setAuditFlag("C");
			masProvince1.setCreatedBy(1);
			masProvince1.setCreatedTimeStamp(Calendar.getInstance().getTime());
			
			
			masProvinceService.create(masProvince1);
		}
		
		@Test
		@Rollback(true)
		public void updateMasProvince(){
			
			MasProvince masProvince=(MasProvince) masProvinceService.find(id);
			//System.out.println("id: "+masProvince.getId());
			masProvince.setName("changmai");
			masProvinceService.update(masProvince);
			
			
		}
		
		@Test
		@Rollback(true)
		public void deleteMasProvince(){
			
			MasProvince masProvince = (MasProvince) masProvinceService.find(id);
			masProvinceService.delete(masProvince);
		}

		@Test
		@Rollback(true)
		public void findAllProvince(){

			List<MasProvince> province = masProvinceService.findAll();
			
		}
		
		
		
		@Test
		public void findbyIdProvince(){

			MasProvince masProvince =(MasProvince) masProvinceService.find(1);
			int id = masProvince.getId();
			Assert.assertEquals(1,id);
			
			
			
		}

}
