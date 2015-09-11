/**
 *
 * @author Preeyaporn
 * @date 20 พ.ค. 2558
 */
package com.aug.hrdb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.dto.HistoryDto;
import com.aug.hrdb.repositories.HistoryRepository;

@Service("historyDtoService")
@Transactional
public class HistoryDtoService {

	@Autowired private HistoryRepository historyRepository;
	
	public List<HistoryDto> searchHistory(Integer id) {
		return historyRepository.searchHistory(id);
		
		
		
	}
	
	
	
}
