package com.cardservice.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="nithish_customer")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Customer {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(nullable=false,updatable=false)
	private int customerId;
	private String customerName;
	@Pattern(regexp="^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$")
	private String email;
	private String phoneNo;
	private String dob;
	private String panNo;
	private String address;
	
	
	//One Customer can have multiple cards
	@OneToMany(mappedBy="customer",cascade={CascadeType.ALL})
	private List<Card> cards;
	
	//One Customer can have multiple Bank Accounts
	@OneToMany(mappedBy="customer",cascade={CascadeType.ALL})
	private List<Account> accounts;

}
