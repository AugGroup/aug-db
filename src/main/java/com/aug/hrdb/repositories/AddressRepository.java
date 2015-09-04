/**
 *
 * @author natechanok
 * @date Apr 27, 2015
 */

package com.aug.hrdb.repositories;

import java.util.List;

import com.aug.hrdb.dto.AddressDto;
import com.aug.hrdb.entities.Address;





public interface AddressRepository extends GenericRepository<Address, Integer>{
	
	public List<Address> findByCriteria(Address address);

	public Address deleteById(Integer id);
	
	public List<AddressDto> searchAddress(Integer id);
	public void saveAddressByNameQuery(AddressDto addressDto);
	public List<Address> findAddressByEmployeeId(Integer id);
	public void updateAddressByNameQuery(AddressDto addressDto);
	public void deleteAddressByNameQuery(Integer id);
	public List<Address> findAll();

}
