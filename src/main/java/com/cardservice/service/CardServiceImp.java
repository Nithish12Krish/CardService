package com.cardservice.service;






import org.springframework.stereotype.Service;

import com.cardservice.model.Card;
import com.cardservice.model.Customer;
import com.cardservice.repo.ICardRepository;
import com.cardservice.repo.customerRepo;

@Service
public class CardServiceImp implements ICardService {
	
	
	private ICardRepository cardRepo;
	
	private customerRepo cr;
	
	

	public CardServiceImp(ICardRepository cardRepo,customerRepo cr) {
		this.cardRepo = cardRepo;
		this.cr=cr;
	}

	@Override
	public Card addCard(Card card) {
		
		return cardRepo.save(card);
	}

	@Override
	public Card UpdateCard(Long cardNo, float limit) {
		Card card=cardRepo.findByCardNo(cardNo);
		card.setCardLimit(limit);
		return cardRepo.save(card);
		
	}

	@Override
	public Card findCard(Long cardNo) {
		
		return cardRepo.findByCardNo(cardNo);
	}

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return cr.save(customer);
	}

	

}
