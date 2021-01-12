package com.yash.nutritionapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yash.nutritionapp.domain.Payment;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long> {

	Payment findByUserId(Long id);	
	@Override
	Iterable<Payment> findAllById(Iterable<Long> id);
	@Override
	Iterable<Payment> findAll();
}
