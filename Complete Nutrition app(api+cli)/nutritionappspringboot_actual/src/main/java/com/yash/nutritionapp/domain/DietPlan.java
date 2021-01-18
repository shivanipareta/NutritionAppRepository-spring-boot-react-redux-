package com.yash.nutritionapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * creating DietPlan as Model for of DietPlan(Entity) corresponding to table in sql 
 * @author admin
 *
 */
@Entity
@Table(name = "dietplan")
public class DietPlan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long id;
	
	
	//@OneToOne
	//private User user;
	
	
	//@NotBlank(message = "User Identifier is required")
	@Size(min = 2, max = 6, message = "User Identifier must be in between 3 to 6 characters")
	/**
	 * Identifier for user
	 */
	@Column(name = "userIdentity")
	private String userId;
	
	@NotBlank(message="slots  cannot be blank")
	@Size(min = 3, max = 255,message = "Please use 3 to 200 characters for slots")

	/**
	 * diet plan slots
	 */
	private String slots;
	private  String meals;
	@NotBlank(message = "food type cannot be blank")
	/**
	 * diet plan food type
	 */
	private String foodType;
	
	/**
	 * diet plan protein ratio
	 */
	private double proteinRatio;
	
	/**
	 * diet plan fat ratio
	 */
	private double fatRatio;
	
	/**
	 * diet plan carbs ratio
	 */
	private double carbsRatio;
	
	/**
	 * diet plan ratio total
	 */
	private double total;
	
	private int map;
	/*
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	*/
	
	public int getMap() {
		return map;
	}
	public String getMeals() {
		return meals;
	}
	public void setMeals(String meals) {
		this.meals = meals;
	}
	public void setMap(int map) {
		this.map = map;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getSlots() {
		return slots;
	}
	public void setSlots(String slots) {
		this.slots = slots;
	}
	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	public double getProteinRatio() {
		return proteinRatio;
	}
	public void setProteinRatio(double proteinRatio) {
		this.proteinRatio = proteinRatio;
	}
	public double getFatRatio() {
		return fatRatio;
	}
	public void setFatRatio(double fatRatio) {
		this.fatRatio = fatRatio;
	}
	public double getCarbsRatio() {
		return carbsRatio;
	}
	public void setCarbsRatio(double carbsRatio) {
		this.carbsRatio = carbsRatio;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
}
