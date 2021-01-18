package com.yash.nutritionapp.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * NutritionPlan class is created as a hub for data where attributes are added to the nutrition plan.
 * @author satakshi pachori
 */

@Entity
@Table(name="nutritionplans")
public class NutritionPlan {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	/**
	 * ID of the Nutrition Plan
	 * ID is auto-generated
	 */
	private long id;

	@NotBlank(message = "Nutrition Plan is required")
	@Size(min = 5, max = 255,message = "Please use 5 to 255 characters for Nutrition Plan Name")
	/**
	 * Name of the Nutrition Plan
	 */
	private String name;

	@NotBlank(message = "Plan Description is required")
	@Size(min = 10, max = 255,message = "Please use 10 to 255 characters for breif description of Nutrition Plan" )
	/**
	 * Description of the Plan
	 */
	private String planDescription;

	@JsonFormat(pattern="yyyy-MM-dd")
	/**
	 * Date of creation of the Plan
	 */
	private Date created_At;

	@JsonFormat(pattern="yyyy-MM-dd")
	/**
	 * Date of updation of Plan
	 */
	private Date updated_At;

	@NotNull(message = "Plan Price is required")
	/**
	 * Price of the Plan
	 */
	private long price;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlanDescription() {
		return planDescription;
	}

	public void setPlanDescription(String planDescription) {
		this.planDescription = planDescription;
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

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	@PrePersist
	public void createdOn() {
		this.created_At = new Date();
	}

	@PreUpdate
	public void updatedOn() {
		this.updated_At = new Date();
	}
}
