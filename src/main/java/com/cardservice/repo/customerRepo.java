package com.cardservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cardservice.model.Customer;

public interface customerRepo extends JpaRepository<Customer, Long> {

}
