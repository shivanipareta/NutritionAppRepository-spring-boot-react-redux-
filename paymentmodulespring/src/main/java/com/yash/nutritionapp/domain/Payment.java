package com.yash.nutritionapp.domain;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * This Payment class is used to create all fields and getter setter for the fields
 * @author admin
 *
 */
@Entity
public class Payment {
	/**
	 * This field represent id of payment
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/**
	 * This field represent amount of payment
	 */

	//payment is coming from NUTRITION PLAN MODULE AS PRICE
	private Double payment;
	/**
	 * This field represent discount amount for payment
	 * never be negative
	 * In case if user enter negative payment, he should throw with PaymentException
	 */
	private Double discount;
	/**
	 * This field represent Date of payment
	 */
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date created_At;
	/**
	 * This field represent Updated date of payment
	 */
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date updated_At;
	/**
	 * This field represent id of user for which payment is happening 
	 */
	//@Column(updatable = false,unique = true)
	//User id is coming from USER module
	private Long userId;
	/**
	 * This field represent id of plan which user chose
	 */
	//plan id is coming from NUTRITION PLAN  module
	private Long planId;
	
	public Payment() {
		super();
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getPayment() {
		return payment;
	}
	public void setPayment(Double payment) {
		this.payment = payment;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public Date getCreated_At() {
		return created_At;
	}
	public void setCreated_At(Date created_At) {
		this.created_At = created_At;
	}
	public Date getUpdated_At() {
		return updated_At;
	}
	public void setUpdated_At(Date updated_At) {
		this.updated_At = updated_At;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getPlanId() {
		return planId;
	}
	public void setPlanId(Long planId) {
		this.planId = planId;
	}


	@PrePersist
	protected void onCreate() {
		this.created_At=new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		this.updated_At=new Date();
	}
}
