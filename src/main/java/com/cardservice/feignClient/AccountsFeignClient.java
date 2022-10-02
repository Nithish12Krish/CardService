package com.cardservice.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cardservice.model.Account;


@FeignClient("AccountService")
public interface AccountsFeignClient {

	@RequestMapping(method = RequestMethod.POST, value = "add", produces = "application/json" )
	Account addAccount(@RequestBody Account account);

}
