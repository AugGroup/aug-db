/**
 *
 * @author Pranrajit
 * @date 27 เม.ย. 2558
 */
package com.aug.hrdb.repositories;

import java.util.List;

import com.aug.hrdb.entities.MasDegreeType;

public interface MasDegreeTypeRepository extends GenericRepository<MasDegreeType,Integer> {

	public List<MasDegreeType> findByCriteria(MasDegreeType masDegreeType);

}
