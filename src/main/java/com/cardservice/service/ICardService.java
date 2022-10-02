package com.cardservice.service;

import com.cardservice.model.Card;
import com.cardservice.model.Customer;

public interface ICardService {
	
	Card findCard(Long cardNo);
	 
	 Card addCard(Card card);
	 
	 Card UpdateCard(Long cardNo,float limit);
	 
	 Customer addCustomer(Customer customer);
	 

}
