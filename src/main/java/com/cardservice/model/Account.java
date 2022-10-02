package com.cardservice.model;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="nithish_account")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(unique=true)
	private Long accountNo;
	
	//Multiple Accounts can be holded by one customer
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="customerId",referencedColumnName = "customerId")
	private Customer customer;
	
	private String bankName;
	private String accountType;
	private float currentBalance;
	private String status;
	
	
	

}
