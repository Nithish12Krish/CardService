package com.cardservice.model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="nithish_card")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class Card {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Long cardNo;
	private String bankName;
	
	//Multiple Cards can be holded by one customer
	@ManyToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name="customerId",referencedColumnName = "customerId")
	private Customer customer;
	
	private String cardType;
	private String expiredDate;
	private float maxLimit;
	private float cardLimit;
	private float currentLimit;
	private String status;
	
	

}
