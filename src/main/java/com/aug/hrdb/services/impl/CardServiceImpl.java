package com.aug.hrdb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.Card;
import com.aug.hrdb.repositories.CardRepository;
import com.aug.hrdb.services.CardService;



@Service("attendanceService")
@Transactional
public class CardServiceImpl implements CardService {

	@Autowired
	private CardRepository cardRepository;
	
	@Override
	public List<Card> findAll() {
		return cardRepository.findAll();
	}

	
	
	@Override
	public void create(Card card) {
		cardRepository.create(card);
		
	}

	@Override
	public void update(Card card) {
		cardRepository.update(card);
		
	}

	@Override
	public void delete(Card card) {
		cardRepository.delete(card);
		
	}

	@Override
	public Card findById(Integer id) {
		return cardRepository.find(id);
	}

	
	@Override
	public List<Card> findByCriteria(Card card) {
		return cardRepository.findByCriteria(card);
	}

	@Override
	public void deleteById(Integer id) {
		 cardRepository.deleteById(id);
	}

}
