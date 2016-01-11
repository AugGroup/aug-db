/**
 * @author Preeyaporn
 * @date 13 พ.ค. 2558
 */
package com.aug.hrdb.repositories;

import java.util.List;

import com.aug.hrdb.dto.HistoryDto;
import com.aug.hrdb.entities.History;

public interface HistoryRepository extends GenericRepository<History, Integer> {

  List<History> findByCriteria(History history);

  List<HistoryDto> searchHistory(Integer id);

}