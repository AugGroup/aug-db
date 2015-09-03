package com.aug.hrdb.dto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.dto.CardDto;
import com.aug.hrdb.repositories.CardRepository;



@Service("attendanceDtoService")
@Transactional
public class CardDtoService {
	
	@Autowired private CardRepository cardRepository;
	
	public List<CardDto> searchCard(Integer id){
		return cardRepository.searchCard(id);
	}

}
