/**
 *
 * @author Preeyaporn
 * @date 29 เม.ย. 2558
 */
package com.aug.hrdb.services;

import java.util.List;

import com.aug.hrdb.entities.MasDivision;

public interface MasDivisionService {

	public List<MasDivision> findAll();
	public void create(MasDivision masDivision);
	public void update(MasDivision masDivision);
	public void delete(MasDivision masDivision);
	public MasDivision findById(Integer id);
	public List<MasDivision> findByCriteria(MasDivision masDivision);
	public MasDivision deleteById(Integer id);
}
