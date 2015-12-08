/**
 *
 * @author Pranrajit
 * @date 25 พ.ค. 2558
 */
package com.aug.hrdb.repositories;

import java.util.List;

import com.aug.hrdb.entities.MasLeaveType;

public interface MasLeaveTypeRepository extends GenericRepository<MasLeaveType, Integer> {

	public List<MasLeaveType> findByCriteria(MasLeaveType masLeaveType);
	
}
