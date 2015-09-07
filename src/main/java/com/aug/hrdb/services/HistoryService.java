/**
 *
 * @author Preeyaporn
 * @date 13 พ.ค. 2558
 */
package com.aug.hrdb.services;

import java.util.List;

import com.aug.hrdb.entities.History;

public interface HistoryService {

	public List<History> findAll();
	public void create(History history);
	public void update(History history);
	public void delete(History history);
	public History findById(Integer id);
	public List<History> findByCriteria(History history);
	public void deleteById(Integer id);
}
