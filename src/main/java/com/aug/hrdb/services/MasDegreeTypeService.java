/**
 *
 * @author Pranrajit
 * @date 29 เม.ย. 2558
 */
package com.aug.hrdb.services;

import java.util.List;

import com.aug.hrdb.entities.MasDegreeType;

public interface MasDegreeTypeService {

	public void create(MasDegreeType masDegreeType);
	public void update(MasDegreeType masDegreeType);
	public void delete(MasDegreeType masDegreeType);
	public MasDegreeType findById(Integer id);
	public List<MasDegreeType> findAll();
	public List<MasDegreeType> findByCriteria(MasDegreeType masDegreeType);
	public void deleteById(Integer id);
	
}
