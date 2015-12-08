/**
 *
 * @author natechanok
 * @date Apr 27, 2015
 */

package com.aug.hrdb.repositories;

import java.util.List;

import com.aug.hrdb.entities.MasAddressType;

public interface MasAddressTypeRepository extends GenericRepository<MasAddressType, Integer> {
	
	public List<MasAddressType> findByCriteria(MasAddressType masAddressType);
	
}
