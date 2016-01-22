/**
 * @author natechanok
 * @date Apr 27, 2015
 */
package com.aug.hrdb.repositories.impl;

import java.util.List;

import com.mysql.jdbc.StringUtils;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.aug.hrdb.dto.AddressDto;
import com.aug.hrdb.entities.Address;
import com.aug.hrdb.repositories.AddressRepository;

@SuppressWarnings("unchecked")
@Repository(value = "addressRepository")
public class AddressRepositoryImpl extends GenericRepositoryImpl<Address, Integer> implements AddressRepository {

  public AddressRepositoryImpl() {
    super(Address.class);
  }

  public List<Address> findByCriteria(Address address) {
    Criteria c = getCurrentSession().createCriteria(Address.class);

    if (!StringUtils.isNullOrEmpty(address.getHouseNo())) {
      c.add(Restrictions.like("houseNo", "%" + address.getHouseNo() + "%"));
    }

    return c.list();

  }

  public List<AddressDto> searchAddress(Integer id) {
    Query namedQuery = getCurrentSession().getNamedQuery("searchAddress").setInteger("appId", id);
    return namedQuery.list();

  }

  @Override
  public void saveAddressByNameQuery(AddressDto addressDto) {

    Query query = getCurrentSession().getNamedQuery("insertAddress");
    query.setString("HOUSE_NO", addressDto.getHouseNo());
    query.setString("ROAD", addressDto.getRoad());
    query.setString("DISTRICT", addressDto.getDistrict());
    query.setString("SUB_DISTRICT", addressDto.getSubDistrict());
    query.setInteger("ZIPCODE", addressDto.getZipcode());
    query.setInteger("APPLICANT_ID", addressDto.getApplicantId());
    query.setInteger("ADDRESSTYPE_ID", addressDto.getAddressTypeId());
    query.setInteger("PROVINCE_ID", addressDto.getMasprovinceId());
    query.executeUpdate();

  }

  @Override
  public List<Address> findAddressByApplicantId(Integer id) {
    Criteria c = getCurrentSession().createCriteria(Address.class, "address");
    c.setFetchMode("applicant", FetchMode.JOIN);
    c.createCriteria("applicant", "applicant");
    c.setFetchMode("addressType", FetchMode.JOIN);
    c.createAlias("addressType", "addressType");
    c.setFetchMode("province", FetchMode.JOIN);
    c.createAlias("province", "province");
    c.add(Restrictions.eq("address.applicant.id", id));

    return c.list();

  }

  public void updateAddressByNameQuery(AddressDto addressDto) {

    Query query = getCurrentSession().getNamedQuery("updateAddress");
    query.setString("HOUSE_NO", addressDto.getHouseNo());
    query.setString("ROAD", addressDto.getRoad());
    query.setString("DISTRICT", addressDto.getDistrict());
    query.setString("SUB_DISTRICT", addressDto.getSubDistrict());
    query.setInteger("ZIPCODE", addressDto.getZipcode());
    query.setInteger("APPLICANT_ID", addressDto.getApplicantId());
    query.setInteger("ADDRESSTYPE_ID", addressDto.getAddressTypeId());
    query.setInteger("PROVINCE_ID", addressDto.getMasprovinceId());
    query.executeUpdate();

  }

  @Override
  public void deleteAddressByNameQuery(Integer id) {
    Query query = getCurrentSession().getNamedQuery("deleteAddress");
    query.setInteger("id", id);
    query.executeUpdate();

  }

  @Override
  public List<AddressDto> findAddressById(Integer id) {
    Query query = getCurrentSession().getNamedQuery("searchAddress");
    query.setParameter("appId", id);
    List<AddressDto> result = query.list();
    System.out.println("QUERYADDRESS :: " + result);

    return result;

  }

  @Override
  public AddressDto findByAddressId(Integer id) {
    Query query = getCurrentSession().getNamedQuery("SEARCH_ADDRESS_ID");
    query.setParameter("ID", id);
    List<AddressDto> result = query.list();
    AddressDto app = result.get(0);

    return app;

  }

}
