/**
 * @author natechanok
 * @date Apr 30, 2015
 */
package com.aug.hrdb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.dto.OfficialDto;
import com.aug.hrdb.entities.Applicant;
import com.aug.hrdb.entities.Official;
import com.aug.hrdb.repositories.OfficialRepository;
import com.aug.hrdb.services.OfficialService;

@Transactional
@Service(value = "officialService")
public class OfficialServiceImpl implements OfficialService {

  @Autowired
  private OfficialRepository officialRepository;

  @Override
  public void create(Official official) {
    officialRepository.create(official);
  }

  @Override
  public void update(Official official) {
    officialRepository.update(official);
  }

  @Override
  public void delete(Official official) {
    officialRepository.delete(official);
  }

  @Override
  public List<Official> findAll() {
    return officialRepository.findAll();
  }

  @Override
  public void deleteById(Integer id) {
    officialRepository.deleteById(id);
  }

  @Override
  public Official findById(Integer id) {
    return officialRepository.find(id);
  }

  @Override
  public List<Official> findByCriteria(Applicant applicant) {
    return officialRepository.findByCriteria(applicant);
  }

  @Override
  public void saveOfficialByNameQuery(OfficialDto officialDto) {
    officialRepository.saveOfficialByNameQuery(officialDto);
  }

  @Override
  public Official searchEmpIdToOfficial() {
    return officialRepository.searchEmpIdToOfficial();
  }

  @Override
  public void updateOfficialByNameQuery(OfficialDto officialDto) {
    officialRepository.updateOfficialByNameQuery(officialDto);
  }

}