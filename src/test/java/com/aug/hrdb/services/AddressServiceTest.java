/**
 *
 * @author natechanok
 * @date Sep 4, 2015
 */

package com.aug.hrdb.services;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;

import com.aug.hrdb.dto.AddressDto;
import com.aug.hrdb.entities.*;
import com.aug.hrdb.repositories.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.GreaterOrEqual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.services.AddressService;
import com.aug.hrdb.services.MasAddressTypeService;
import com.aug.hrdb.services.MasProvinceService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-bean-db-test.xml"})
@TransactionConfiguration
@Transactional
public class AddressServiceTest {

	@Autowired
	private AddressService addressService;

	@Autowired
	private MasAddressTypeService masAddressTypeService;

	@Autowired
	private MasProvinceService masProvinceService;

	@Autowired
	private ApplicantService applicantService;

	@Autowired
	private MasJobLevelService masJoblevelService;

	@Autowired
	private MasTechnologyService masTechnologyService;

	@Autowired
	private MasCoreSkillService masCoreSkillService;

	private Address address;

	private AddressDto addressDto;

	private Applicant applicant;

	private MasProvince nonthaburi, bangkok;

	@Before
	public void setUp() throws Exception {
    // create applicant
    MasCoreSkill masCoreSkill = new MasCoreSkill();
    masCoreSkill.setAuditFlag("C");
    masCoreSkill.setCreatedBy(1);
    masCoreSkill.setCreatedTimeStamp(Calendar.getInstance().getTime());
    masCoreSkill.setIsActive(true);
    masCoreSkill.setCode("ITS");
    masCoreSkill.setName("ITS");
    masCoreSkillService.create(masCoreSkill);

    MasJobLevel masJobLevel = new MasJobLevel();
    masJobLevel.setAuditFlag("C");
    masJobLevel.setCreatedBy(1);
    masJobLevel.setCreatedTimeStamp(Calendar.getInstance().getTime());
    masJobLevel.setIsActive(true);
    masJobLevel.setCode("C");
    masJobLevel.setName("Consultant");
    masJoblevelService.create(masJobLevel);

    MasTechnology masTechnology = new MasTechnology();
    masTechnology.setAuditFlag("C");
    masTechnology.setCreatedBy(1);
    masTechnology.setCreatedTimeStamp(Calendar.getInstance().getTime());
    masTechnology.setIsActive(true);
    masTechnology.setCode("1");
    masTechnology.setName("Java");
    masTechnologyService.create(masTechnology);

    applicant = new Applicant();
    applicant.setAuditFlag("C");
    applicant.setCreatedBy(1);
    applicant.setCreatedTimeStamp(Calendar.getInstance().getTime());
    applicant.setCoreSkill(masCoreSkillService.findById(masCoreSkill.getId()));
    applicant.setJoblevel(masJoblevelService.findById(masJobLevel.getId()));
    applicant.setTechnology(masTechnologyService.findById(masTechnology.getId()));
    applicantService.create(applicant);

    // create address type
    MasAddressType masAddressType = new MasAddressType();
    masAddressType.setAuditFlag("C");
    masAddressType.setCreatedBy(1);
    masAddressType.setCreatedTimeStamp(Calendar.getInstance().getTime());
    masAddressType.setIsActive(true);
    masAddressType.setCode("P01");
    masAddressType.setName("Present address");
    masAddressTypeService.create(masAddressType);

    // create province
    nonthaburi = new MasProvince();
    nonthaburi.setAuditFlag("C");
    nonthaburi.setCreatedBy(1);
    nonthaburi.setCreatedTimeStamp(Calendar.getInstance().getTime());
    nonthaburi.setIsActive(true);
    nonthaburi.setCode("NON");
    nonthaburi.setName("Nonthaburi");
    masProvinceService.create(nonthaburi);

    bangkok = new MasProvince();
    bangkok.setAuditFlag("C");
    bangkok.setCreatedBy(1);
    bangkok.setCreatedTimeStamp(Calendar.getInstance().getTime());
    bangkok.setIsActive(true);
    bangkok.setCode("BKK");
    bangkok.setName("Bangkok");
    masProvinceService.create(bangkok);

    // create address
    address = new Address();
    address.setAuditFlag("C");
    address.setCreatedBy(1);
    address.setCreatedTimeStamp(Calendar.getInstance().getTime());
    address.setHouseNo("199/199");
    address.setApplicant(applicant);
    address.setProvince(nonthaburi);
    address.setAddressType(masAddressType);
    addressService.create(address);

    // create address dto
    addressDto = new AddressDto();
    addressDto.setHouseNo("123/123");
    addressDto.setRoad("Silom");
    addressDto.setDistrict("Muang");
    addressDto.setSubDistrict("Yanawa");
    addressDto.setZipcode(11123);
    addressDto.setApplicantId(applicant.getId());
    addressDto.setAddressTypeId(masAddressType.getId());
    addressDto.setMasprovinceId(bangkok.getId());

	}

  @Test
  public void testLoadServicesShouldPass() throws Exception {
    assertNotNull(masJoblevelService);
    assertNotNull(masProvinceService);
    assertNotNull(masAddressTypeService);
    assertNotNull(masCoreSkillService);
    assertNotNull(masTechnologyService);
    assertNotNull(applicantService);
    assertNotNull(addressService);

  }

  @Test
  public void testFindAddressByIdWithAddressServiceShouldReturnSetupAddress() throws Exception {
    Address result = addressService.findById(address.getId());
    assertThat(result.getApplicant(), is(applicant));
    assertThat(result.getProvince(), is(nonthaburi));

  }

  @Test
  public void testFindAllAddressByWithAddressServiceShouldReturnListOfAllAddress() throws Exception {
    List<Address> addresses = addressService.findAll();
    assertNotNull(addresses);

  }

  @Test
  public void testUpdateAddressWithAddressServiceShouldChangeNonthaburiToBangkok() throws Exception {
    Address update = addressService.find(address.getId());
    update.setProvince(bangkok);
    addressService.update(update);

    Address result = addressService.find(update.getId());
    assertThat(result.getProvince(), is(bangkok));

  }

  @Test
  public void testDeleteAddressWithAddressServiceShouldNotFindThatAddress() throws Exception {
    Address delete = addressService.find(address.getId());
    addressService.delete(delete);

    Address result = addressService.find(delete.getId());
    assertNull(result);

  }

  @Test
  public void testDeleteAddressByIdWithAddressServiceShouldNotFindThatAddress() throws Exception {
    Address delete = addressService.find(address.getId());
    addressService.deleteById(delete.getId());

    Address result = addressService.find(delete.getId());
    assertNull(result);

  }

  @Test
  public void testFindAddressByCriteriaWithAddressServiceShouldReturnListOfAddressThatHaveHouseNoSameInput() throws Exception {
    List<Address> addresses = addressService.findByCriteria(address);
    assertNotNull(addresses);

  }

  @Test
  public void testSearchAddressByAddressServiceShouldReturnListOfAddressDto() throws Exception {
    List<AddressDto> addressDtos = addressService.searchAddress(applicant.getId());
    assertNotNull(addressDtos);
    assertThat(addressDtos.size(), is(1));
    assertThat(addressDtos.get(0).getMasprovinceName(), is("Nonthaburi"));

  }

  @Test
  public void testSaveAddressByNameQueryWithAddressServiceShouldPass() throws Exception {
    addressService.saveAddressByNameQuery(addressDto);

    List<AddressDto> result = addressService.searchAddress(addressDto.getApplicantId());
    assertNotNull(result);
    assertThat(result.size(), is(new GreaterOrEqual<>(1)));

  }

}
