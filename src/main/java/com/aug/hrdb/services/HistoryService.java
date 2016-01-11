/**
 * @author Preeyaporn
 * @date 13 พ.ค. 2558
 */
package com.aug.hrdb.services;

import java.util.List;

import com.aug.hrdb.dto.HistoryDto;
import com.aug.hrdb.entities.History;

public interface HistoryService {

  List<History> findAll();

  void create(History history);

  void update(History history);

  void delete(History history);

  History findById(Integer id);

  void deleteById(Integer id);

  List<History> findByCriteria(History history);

  List<HistoryDto> searchHistory(Integer id);

}