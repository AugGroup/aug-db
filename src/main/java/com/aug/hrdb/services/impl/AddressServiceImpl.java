/**
 *
 * @author natechanok
 * @date Apr 28, 2015
 */

package com.aug.hrdb.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.dto.AddressDto;
import com.aug.hrdb.entities.Address;
import com.aug.hrdb.repositories.AddressRespository;
import com.aug.hrdb.services.AddressService;



@Service("addressService")
@Transactional
public class AddressServiceImpl implements AddressService{

	@Autowired
	private AddressRespository addressResp;
	
	@Override
	public void create(Address address) {
		addressResp.create(address);
		
	}

	@Override
	public void update(Address address) {
		addressResp.update(address);
		
	}

	@Override
	public void delete(Address address) {
		addressResp.delete(address);
		
	}


	@Override
	public List<Address> findAll() {
		return addressResp.findAll();
	}

	@Override
	public Address findById(Integer Id) {
		return addressResp.find(Id);
	}

	@Override
	public List<Address> findByCriteria(Address address) {
		return addressResp.findByCriteria(address);
	}

	@Override
	public Address deleteById(Integer id) {
		return addressResp.deleteById(id);
	}

	@Override
	public Address find(Integer Id) {
		return addressResp.find(Id);
	}

	@Override
	public void saveAddressByNameQuery(AddressDto addressDto) {
		
		addressResp.saveAddressByNameQuery(addressDto);
	}

	@Override
	public List<AddressDto> findAddressByEmployeeId(Integer id) {
		
		
		List<Address> addressList = addressResp.findAddressByEmployeeId(id);
		List<AddressDto> addressDtoList = new ArrayList<AddressDto>();
		for(Address address:addressList){
			
		   AddressDto addressDto = new AddressDto();
		   addressDto.setId(address.getId());
		   addressDto.setHouseNo(address.getHouseNo());
		   addressDto.setRoad(address.getRoad());
		   addressDto.setDistrict(address.getDistrict());
		   addressDto.setSubDistrict(address.getSubDistrict());
		   
		   /*addressDto.setAddressTypeId(address.getAddressType().getId());
		   addressDto.setEmployeeId(id);
		   addressDto.setMasaddresstypeName(address.getAddressType().getName());
		   addressDto.setMasprovinceId(address.getProvince().getId());
		   addressDto.setMasprovinceName(address.getProvince().getName());*/
		   addressDto.setZipcode(address.getZipcode());
		   
		   addressDtoList.add(addressDto);
			
		}
		return addressDtoList;
	}

	@Override
	public List<AddressDto> searchAddress(Integer id) {
		return addressResp.searchAddress(id);
	}

	@Override
	public void deleteAddressByNameQuery(Integer id) {
		// TODO Auto-generated method stub
		addressResp.deleteAddressByNameQuery(id);
		
	}


	

}
