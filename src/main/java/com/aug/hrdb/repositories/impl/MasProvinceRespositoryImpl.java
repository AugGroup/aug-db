/**
 *
 * @author Pranrajit
 * @date 27 เม.ย. 2558
 */
package com.aug.hrdb.repositories.impl;

import org.springframework.stereotype.Repository;

import com.aug.hrdb.entities.MasProvince;
import com.aug.hrdb.repositories.MasProvinceRespository;


@Repository
public class MasProvinceRespositoryImpl extends GenericRepositoryImpl<MasProvince, Integer> implements MasProvinceRespository{

	public MasProvinceRespositoryImpl() {
		super(MasProvince.class);
		// TODO Auto-generated constructor stub
	}

}
