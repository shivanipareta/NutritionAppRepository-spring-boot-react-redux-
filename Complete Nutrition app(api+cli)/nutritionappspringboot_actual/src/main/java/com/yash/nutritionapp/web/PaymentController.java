package com.yash.nutritionapp.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.nutritionapp.domain.Payment;
import com.yash.nutritionapp.service.MapValidationErrorService;
import com.yash.nutritionapp.service.PaymentService;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin
public class PaymentController {
	@Autowired
	PaymentService paymentService;
	@Autowired
	MapValidationErrorService mapValidationErrorService;
	//localhost:8090/api/payments  post
	@PostMapping("")
	public ResponseEntity<?> savePayment(@Valid @RequestBody Payment payment,BindingResult result)
	{
		ResponseEntity<?> errorMap=mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null)
			return errorMap;
		Payment pay=paymentService.saveOrUpdate(payment);
		return new ResponseEntity<Payment>(pay, HttpStatus.CREATED);
	}
	
	//localhost:8090/api/payments/20  get
	@GetMapping("/{id}")
	public ResponseEntity<?> getPaymentByUserId(@PathVariable Long id)
	{
		Payment payment=paymentService.findByUserId(id);
		return new ResponseEntity<Payment>(payment,HttpStatus.OK);
	}
	
	//localhost:8090/api/payments/all   get
	@GetMapping("/all")
	public Iterable<Payment> findAllPayments()
	{
		return paymentService.findAllPayments();
	}
	
	
	//localhost:8090/api/payments/20 delete
	@DeleteMapping("/{id}")
	public Payment deletePayment(@PathVariable Long id)
	{
		return paymentService.deletePaymentByUserId(id);
	}
	

}
