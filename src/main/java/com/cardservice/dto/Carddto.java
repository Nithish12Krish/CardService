package com.cardservice.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//For Data transfer object for Card entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Carddto {
	
	private Long cardNo;
	private String bankName;
	private String cardType;
	private Date expiredDate;
	private float maxLimit;
	private float cardLimit;
	private float currentLimit;
	private String status;

}
