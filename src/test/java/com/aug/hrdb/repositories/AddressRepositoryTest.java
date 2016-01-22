/**
 * @author natechanok
 * @date Sep 4, 2015
 */

package com.aug.hrdb.repositories;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.GreaterOrEqual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.dto.AddressDto;
import com.aug.hrdb.entities.Address;
import com.aug.hrdb.entities.Applicant;
import com.aug.hrdb.entities.MasAddressType;
import com.aug.hrdb.entities.MasCoreSkill;
import com.aug.hrdb.entities.MasJobLevel;
import com.aug.hrdb.entities.MasProvince;
import com.aug.hrdb.entities.MasTechnology;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-bean-db-test.xml"})
@TransactionConfiguration
@Transactional
public class AddressRepositoryTest {

  @Autowired
  private AddressRepository addressRepository;

  @Autowired
  private MasAddressTypeRepository masAddressTypeRepository;

  @Autowired
  private MasProvinceRepository masProvinceRepository;

  @Autowired
  private ApplicantRepository applicantRepository;

  @Autowired
  private MasJobLevelRepository masJoblevelRepository;

  @Autowired
  private MasTechnologyRepository masTechnologyRepository;

  @Autowired
  private MasCoreSkillRepository masCoreSkillRepository;

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
    masCoreSkillRepository.create(masCoreSkill);

    MasJobLevel masJobLevel = new MasJobLevel();
    masJobLevel.setAuditFlag("C");
    masJobLevel.setCreatedBy(1);
    masJobLevel.setCreatedTimeStamp(Calendar.getInstance().getTime());
    masJobLevel.setIsActive(true);
    masJobLevel.setCode("C");
    masJobLevel.setName("Consultant");
    masJoblevelRepository.create(masJobLevel);

    MasTechnology masTechnology = new MasTechnology();
    masTechnology.setAuditFlag("C");
    masTechnology.setCreatedBy(1);
    masTechnology.setCreatedTimeStamp(Calendar.getInstance().getTime());
    masTechnology.setIsActive(true);
    masTechnology.setCode("1");
    masTechnology.setName("Java");
    masTechnologyRepository.create(masTechnology);

    applicant = new Applicant();
    applicant.setAuditFlag("C");
    applicant.setCreatedBy(1);
    applicant.setCreatedTimeStamp(Calendar.getInstance().getTime());
    applicant.setCoreSkill(masCoreSkillRepository.find(masCoreSkill.getId()));
    applicant.setJoblevel(masJoblevelRepository.find(masJobLevel.getId()));
    applicant.setTechnology(masTechnologyRepository.find(masTechnology.getId()));
    applicantRepository.create(applicant);

    // create address type
    MasAddressType masAddressType = new MasAddressType();
    masAddressType.setAuditFlag("C");
    masAddressType.setCreatedBy(1);
    masAddressType.setCreatedTimeStamp(Calendar.getInstance().getTime());
    masAddressType.setIsActive(true);
    masAddressType.setCode("P01");
    masAddressType.setName("Present address");
    masAddressTypeRepository.create(masAddressType);

    // create province
    nonthaburi = new MasProvince();
    nonthaburi.setAuditFlag("C");
    nonthaburi.setCreatedBy(1);
    nonthaburi.setCreatedTimeStamp(Calendar.getInstance().getTime());
    nonthaburi.setIsActive(true);
    nonthaburi.setCode("NON");
    nonthaburi.setName("Nonthaburi");
    masProvinceRepository.create(nonthaburi);

    bangkok = new MasProvince();
    bangkok.setAuditFlag("C");
    bangkok.setCreatedBy(1);
    bangkok.setCreatedTimeStamp(Calendar.getInstance().getTime());
    bangkok.setIsActive(true);
    bangkok.setCode("BKK");
    bangkok.setName("Bangkok");
    masProvinceRepository.create(bangkok);

    // create address
    address = new Address();
    address.setAuditFlag("C");
    address.setCreatedBy(1);
    address.setCreatedTimeStamp(Calendar.getInstance().getTime());
    address.setHouseNo("199/199");
    address.setApplicant(applicant);
    address.setProvince(nonthaburi);
    address.setAddressType(masAddressType);
    addressRepository.create(address);

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
  public void testLoadRepositoryShouldPass() throws Exception {
    assertNotNull(addressRepository);
    assertNotNull(masAddressTypeRepository);
    assertNotNull(masProvinceRepository);
    assertNotNull(applicantRepository);
    assertNotNull(masJoblevelRepository);
    assertNotNull(masTechnologyRepository);
    assertNotNull(masCoreSkillRepository);

  }

  @Test
  public void testFindAddressByIdWithAddressRepositoryShouldReturnSetupAddress() throws Exception {
    Address result = addressRepository.find(address.getId());
    assertThat(result.getApplicant(), is(applicant));
    assertThat(result.getProvince(), is(nonthaburi));

  }

  @Test
  public void testFindAllAddressByWithAddressRepositoryShouldReturnListOfAllAddress() throws Exception {
    List<Address> addresses = addressRepository.findAll();
    assertNotNull(addresses);

  }

  @Test
  public void testUpdateAddressWithAddressRepositoryShouldChangeNonthaburiToBangkok() throws Exception {
    Address update = addressRepository.find(address.getId());
    update.setProvince(bangkok);
    addressRepository.update(update);

    Address result = addressRepository.find(update.getId());
    assertThat(result.getProvince(), is(bangkok));

  }

  @Test
  public void testDeleteAddressWithAddressRepositoryShouldNotFindThatAddress() throws Exception {
    Address delete = addressRepository.find(address.getId());
    addressRepository.delete(delete);

    Address result = addressRepository.find(delete.getId());
    assertNull(result);

  }

  @Test
  public void testDeleteAddressByIdWithAddressRepositoryShouldNotFindThatAddress() throws Exception {
    Address delete = addressRepository.find(address.getId());
    addressRepository.deleteById(delete.getId());

    Address result = addressRepository.find(delete.getId());
    assertNull(result);

  }

  @Test
  public void testFindAddressByCriteriaWithAddressRepositoryShouldReturnListOfAddressThatHaveHouseNoSameInput() throws Exception {
    List<Address> addresses = addressRepository.findByCriteria(address);
    assertNotNull(addresses);

  }

  @Test
  public void testSearchAddressByAddressRepositoryShouldReturnListOfAddressDto() throws Exception {
    List<AddressDto> addressDtos = addressRepository.searchAddress(applicant.getId());
    assertNotNull(addressDtos);
    assertThat(addressDtos.size(), is(1));
    assertThat(addressDtos.get(0).getMasprovinceName(), is("Nonthaburi"));

  }

  @Test
  public void testSaveAddressByNameQueryWithAddressRepositoryShouldPass() throws Exception {
    addressRepository.saveAddressByNameQuery(addressDto);

    List<AddressDto> result = addressRepository.searchAddress(addressDto.getApplicantId());
    assertNotNull(result);
    assertThat(result.size(), is(new GreaterOrEqual<>(1)));

  }
}
