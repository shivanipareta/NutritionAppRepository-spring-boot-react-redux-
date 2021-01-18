package com.yash.nutritionapp.domain;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.beans.factory.annotation.Autowired;

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
	private Long payment;
	//@OneToOne
	//private NutritionPlan nutritionPlan;
	// @ManyToOne
	  //  @JoinColumn(name="id_user")
	   // private User user;
	
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
	
	/*
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public NutritionPlan getNutritionPlan() {
		return nutritionPlan;
	}


	public void setNutritionPlan(NutritionPlan nutritionPlan) {
		this.nutritionPlan = nutritionPlan;
	}

*/
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getPayment() {
		return payment;
	}
	public void setPayment(Long payment) {
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
