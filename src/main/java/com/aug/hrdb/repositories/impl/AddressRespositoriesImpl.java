/**
 *
 * @author natechanok
 * @date Apr 27, 2015
 */

package com.aug.hrdb.repositories.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.aug.hrdb.entities.Address;
import com.aug.hrdb.repositories.AddressRespositories;



@Repository
public class AddressRespositoriesImpl extends GenericDaoImpl<Address, Integer> implements AddressRespositories{

	public AddressRespositoriesImpl() {
		super(Address.class);
	
	}

	@SuppressWarnings("unchecked")
	public List<Address> findByCriteria(Address address) {

		Criteria c = getCurrentSession().createCriteria(Address.class);
		if (!StringUtils.isNullOrEmpty(address.getHouseNo())) {
			c.add(Restrictions.like("name", "%" + address.getHouseNo() + "%"));
		}
		return c.list();
	}

	
	public Address deleteById(Integer id) {
		
		Address address =(Address)getCurrentSession().load(Address.class, id);
		getCurrentSession().delete(address);
		return address;
	}
	
	@SuppressWarnings("unchecked")
	public List<AddressRespositories> searchAddress(Integer id) {
		Query namedQuery = getCurrentSession().getNamedQuery("searchAddress").setInteger("empId" ,id);
	    return  namedQuery.list();
	}
	

	@Override
	public void saveAddressByNameQuery(AddressRespositories addressResp) {
		
		Query query = getCurrentSession().getNamedQuery("insertAddress");
		query.setString("HOUSE_NO", addressResp.getAddress1());
		query.setString("ROAD", addressResp.getAddress2());
		query.setInteger("DISTRICT", addressResp.getZipcode());
		query.setString("SUB_DISTRICT", addressResp.getAddress2());
		query.setInteger("ZIPCODE", addressResp.getZipcode());
		query.setInteger("EMPLOYEE_ID", addressResp.getEmployeeId());
		query.setInteger("ADDRESSTYPE_ID", addressResp.getAddressTypeId());
		query.setInteger("PROVINCE_ID", addressResp.getMasprovinceId());
		
		query.executeUpdate();
		
	}

	@Override
	public List<Address> findAddressByEmployeeId(Integer id) {
		Criteria c = getCurrentSession().createCriteria(Address.class,"address");
		c.setFetchMode("employee", FetchMode.JOIN);
		c.createCriteria("employee", "employee");
		c.setFetchMode("addressType",FetchMode.JOIN);
		c.createAlias("addressType", "addressType");
		c.setFetchMode("province",FetchMode.JOIN);
		c.createAlias("province","province");
		c.add(Restrictions.eq("address.employee.id", id));
		return c.list();
	}
	
	public void updateAddressByNameQuery(AddressDto addressDto){
		
		Query query = getCurrentSession().getNamedQuery("updateAddress");
		
		
		query.setString("HOUSE_NO", addressResp.getAddress1());
		query.setString("ROAD", addressResp.getAddress2());
		query.setString("DISTRICT", addressResp.getZipcode());
		query.setString("SUB_DISTRICT", addressResp.getAddress2());
		query.setInteger("ZIPCODE", addressResp.getZipcode());
		query.setInteger("EMPLOYEE_ID", addressResp.getEmployeeId());
		query.setInteger("ADDRESSTYPE_ID", addressResp.getAddressTypeId());
		query.setInteger("PROVINCE_ID", addressResp.getMasprovinceId());
		
		
		query.executeUpdate();
	}

	@Override
	public void deleteAddressByNameQuery(Integer id) {
		// TODO Auto-generated method stub
		Query query = getCurrentSession().getNamedQuery("deleteAddress");
		query.setInteger("id",id);
		query.executeUpdate();
	}
		

}
