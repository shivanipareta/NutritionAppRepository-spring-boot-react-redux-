package com.yash.nutritionapp.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * creating WeightLog as Model for of WeightLog(Ebtity) corresponding to table in sql
 * @author pradyumn.joshi
 *
 */

@Entity
//@Table(name = "weightLog")
public class WeightLog
{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	/**
	 * Id of weight log.
	 */
	private long id;
	
   // @ManyToOne
   // @JoinColumn(name="id_user" )
   // private User user;
    
	
	//@Digits(integer = 5, fraction = 2 ,message="Please Enter Valid Number.Number upto two decimal places allowed. ")
	//@NotNull(message="weight cannot be blank")
	/**
	 * weight of user.
	 */
	private Double weight;
	
	@JsonFormat(pattern ="yyyy-MM-dd")
	/**
	 * Creation Date of weight log.
	 */
	private Date created_At;//pre-persist
	
	@JsonFormat(pattern ="yyyy-MM-dd")
	/**
	 * Updation Date of weight log.
	 */
	private Date updated_At;//post-update
	
	
	
		/**
	 * Unique User id of the user.
	 * It will be refrencing to userid of the user.
	 */
	private String userId;
	

	/**
	 * Getters and Setters of WeightLog
	 */
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	/*
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	*/
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @PrePersist annotation will execute before object will be saved in db
	 */	
	@PrePersist
	public void createdOn() {
		this.created_At = new Date();
	}

	/**
	 * @PostUpdate annotation will execute after update. These annotations will run
	 *             as life cycle
	 */
	@PreUpdate
	public void updatedOn() {
		this.updated_At = new Date();
	}
	
	



}


