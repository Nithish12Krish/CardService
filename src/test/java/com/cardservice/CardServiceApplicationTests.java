package com.cardservice;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cardservice.model.Card;
import com.cardservice.model.Customer;
import com.cardservice.service.ICardService;

@SpringBootTest
class CardServiceApplicationTests {
	
	@Mock
	ICardService cardservice;

	@Test
	void CardServiceTest() {
		
		
		
//		Card card=new Card();
//		Customer c=new Customer();
//		c.setId((long) 3);
//		c.setCustomerName("Nithish");	
//		
//		
//		card.setCardType("Credit");
//		card.setBankName("HDFC");
//		card.setCardNo((long) 321);
//		card.setMaxLimit(300000);
//		card.setCardLimit(100000);		
//		card.setCurrentLimit(35000);
//		card.setCustomer(c);
//		card.setExpiredDate("07/25");
//		
//		cardservice.addCard(card);
	}

}
