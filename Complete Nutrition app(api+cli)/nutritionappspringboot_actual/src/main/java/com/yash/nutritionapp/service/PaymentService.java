package com.yash.nutritionapp.service;

import org.aspectj.bridge.AbortException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.nutritionapp.domain.Payment;
import com.yash.nutritionapp.exceptions.NutritionPlanIdException;
import com.yash.nutritionapp.exceptions.PaymentIdException;
import com.yash.nutritionapp.repository.PaymentRepository;

@Service
public class PaymentService {
	@Autowired
	PaymentRepository paymentRepository;

	public Payment saveOrUpdate(Payment payment) {
		try {
//			payment.setUserId(payment.getUser().getId());
//			payment.setPayment(payment.getNutritionPlan().getPrice());
//			payment.setPlanId(payment.getNutritionPlan().getId());
	    	if(payment.getUserId()==11) payment.setDiscount(50.0);
			else if(payment.getUserId()==12) payment.setDiscount(100.0);
			else if(payment.getUserId()==13) payment.setDiscount(150.0);
			else if(payment.getUserId()==14) payment.setDiscount(200.0);
			else if(payment.getUserId()==15) payment.setDiscount(250.0);
			else if(payment.getUserId()==16) payment.setDiscount(300.0);
			else if(payment.getUserId()==17) payment.setDiscount(350.0);
			else if(payment.getUserId()==18) payment.setDiscount(400.0);
			else if(payment.getUserId()==19) payment.setDiscount(450.0);
			else if(payment.getUserId()==20) payment.setDiscount(500.0);	
			else payment.setDiscount(0.0);		
			
			Payment savedPayment=paymentRepository.save(payment);
			return savedPayment ;
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PaymentIdException("Nutrition Plan ID "+payment.getId()+" already exitsts!");
		}
		}

	

	public Iterable<Payment> findAllPayments()
	{
		return paymentRepository.findAll();
	}

	public Payment findByUserId(Long id)
	{
		Payment payment=paymentRepository.findByUserId(id);
		if(payment==null)
		{
			throw new PaymentIdException("Payment Id '"+id+"' does not exists !");
		}
		return payment;

	}

	public Payment deletePaymentByUserId(Long id)
	{
		Payment payment=paymentRepository.findByUserId(id);
		if(payment==null)
		{
			throw new PaymentIdException("Payment with Id '"+id+"' does not exists !");
		}
		paymentRepository.delete(payment);
		return payment;
	}

}
