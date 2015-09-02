/**
 *
 * @author Preeyaporn
 * @date 13 พ.ค. 2558
 */
package com.aug.hrdb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.History;
import com.aug.hrdb.repositories.HistoryRepository;
import com.aug.hrdb.services.HistoryService;

@Service("historyService")
@Transactional
public class HistoryServiceImpl implements HistoryService{

	@Autowired
	private HistoryRepository historyRepository;
	
	@Override
	public List<History> findAll() {
		return historyRepository.findAll();
	}

	@Override
	public void create(History history) {
		historyRepository.create(history);
	}

	@Override
	public void update(History history) {
		historyRepository.update(history);
	}

	@Override
	public void delete(History history) {
		historyRepository.delete(history);
	}

	@Override
	public History findById(Integer id) {
		return historyRepository.find(id);
	}

	@Override
	public List<History> findByCriteria(History history) {
		return historyRepository.findByCriteria(history);
	}

	@Override
	public History deleteById(Integer id) {
		return historyRepository.deleteById(id);
	}

}
