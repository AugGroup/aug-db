/**
 *
 * @author natechanok
 * @date Apr 27, 2015
 */

package com.aug.hrdb.services;

import java.util.List;

import com.aug.hrdb.dto.AddressDto;
import com.aug.hrdb.entities.Address;




public interface AddressService {
	
	public void create(Address address);
	public void update(Address address);
	public void delete(Address address);
	public Address findById(Integer Id);
	public List<Address> findAll();
	public List<Address> findByCriteria(Address address);
	public Address deleteById(Integer id);
	public Address find(Integer Id);
	public void saveAddressByNameQuery(AddressDto addressDto);
	public List<AddressDto> findAddressByEmployeeId(Integer id);
	public List<AddressDto> searchAddress(Integer id);
	public void deleteAddressByNameQuery(Integer id);



	

}
