package com.cardservice.controller;

import java.text.ParseException;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cardservice.dto.Carddto;
import com.cardservice.feignClient.AccountsFeignClient;
import com.cardservice.model.Account;
import com.cardservice.model.Card;
import com.cardservice.model.Customer;
import com.cardservice.repo.customerRepo;
import com.cardservice.service.ICardService;

@RestController
@RequestMapping("cards")
public class CardController {
	
	@Autowired
	ICardService  cardService;
	
	
	
	AccountsFeignClient accountsFeignClient;
	
	Logger logger = LoggerFactory.getLogger(CardController.class);
	
	public CardController(AccountsFeignClient accountsFeignClient) {
		
		super();
		this.accountsFeignClient = accountsFeignClient;
	}

	@Autowired
    private ModelMapper modelMapper;
	
	
	//find Card Using CardNumber 
	@GetMapping("/find/{cardNo}")
	public ResponseEntity<Carddto> getCardByNumber(@PathVariable("cardNo")Long cardNo){
		logger.info("Running find Card using Card NUmber");
		Carddto card=convertToDto(cardService.findCard(cardNo));
		return new ResponseEntity<>(card,HttpStatus.OK);
	}
	
	//Adding new Card to database
	@PostMapping("/add")
	public ResponseEntity<Card> addCard(@RequestBody Card card){
		Card c=null;
		try {
			logger.info("Adding Card to database");
			c=this.cardService.addCard(card);
			return ResponseEntity.status(HttpStatus.CREATED).body(c);
		}catch(Exception e) {
			logger.error("Invalid Error");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	@PostMapping("/addcustomer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
		Customer c=null;
		try {
			logger.info("Adding Customer to database");
			c=this.cardService.addCustomer(customer);
			return ResponseEntity.status(HttpStatus.CREATED).body(c);
		}catch(Exception e) {
			logger.error("Invalid Error");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	//Updating Card Limit 
	@PutMapping("/update/{cardNo}/{limit}")
	public ResponseEntity<Carddto> updateCardLimit(@PathVariable Long cardNo,@PathVariable float limit){
		logger.info("Updating Card Limit using Card Number");
		Carddto updateCard=convertToDto(cardService.UpdateCard(cardNo, limit));
		return new ResponseEntity<>(updateCard,HttpStatus.OK);
		
	}
	
	//Card Payment Using Bank Account 
	@PutMapping("/payment/{cardNo}/{amount}")
	public ResponseEntity<Carddto> cardPayment(@RequestBody Account account,@PathVariable Long cardNo,@PathVariable float amount){
		//Adding new bank account to db for card payment
		Account acc=accountsFeignClient.addAccount(account);
		
		logger.info("Updating Payment ");
		Carddto card=convertToDto(cardService.findCard(cardNo));
		card.setCurrentLimit(card.getCurrentLimit()+amount);
		acc.setCurrentBalance(acc.getCurrentBalance()-amount);
		
		return new ResponseEntity<>(card,HttpStatus.OK);
		
	}
	
	//Converter for Card  to CardDto
	private Carddto convertToDto(Card card) {
	    Carddto carddto = modelMapper.map(card,Carddto.class);
	    
	    return carddto;
	}
	
	private Card convertToEntity(Carddto carddto) throws ParseException {
	    Card card = modelMapper.map(carddto, Card.class);	 
	    
	    return card;
	}
	
	

}
