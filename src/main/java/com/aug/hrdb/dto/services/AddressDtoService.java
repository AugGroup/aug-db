/**
 *
 * @author natechanok
 * @date May 24, 2015
 */

package com.aug.hrdb.dto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.dto.AddressDto;
import com.aug.hrdb.repositories.AddressRepository;



@Service("addressDtoService")
@Transactional
public class AddressDtoService {
	@Autowired private AddressRepository addressResp;
	
	public List<AddressDto> searchAddress(Integer id){
		return addressResp.searchAddress(id);
	}

}
