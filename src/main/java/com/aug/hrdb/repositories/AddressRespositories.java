/**
 *
 * @author natechanok
 * @date Apr 27, 2015
 */

package com.aug.hrdb.repositories;

import java.util.List;

import com.aug.hrdb.entities.Address;





public interface AddressRespositories extends GenericDao<Address, Integer>{
	
	public List<Address> findByCriteria(Address address);

	public Address deleteById(Integer id);
	
	public List<AddressRespositories> searchAddress(Integer id);
	public void saveAddressByNameQuery(AddressRespositories addressResp);
	public List<Address> findAddressByEmployeeId(Integer id);
	public void updateAddressByNameQuery(AddressRespositories addressResp);
	public void deleteAddressByNameQuery(Integer id);
	

}
