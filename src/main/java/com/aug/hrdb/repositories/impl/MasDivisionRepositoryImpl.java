/**
 *
 * @author Preeyaporn
 * @date 27 เม.ย. 2558
 */
package com.aug.hrdb.repositories.impl;

import org.springframework.stereotype.Repository;

import com.aug.hrdb.entities.MasDivision;
import com.aug.hrdb.repositories.MasDivisionRepository;

@Repository("masDivisionRepository")
public class MasDivisionRepositoryImpl extends GenericRepositoryImpl<MasDivision, Integer> implements MasDivisionRepository{

	public MasDivisionRepositoryImpl() {
		super(MasDivision.class);
	}

}
