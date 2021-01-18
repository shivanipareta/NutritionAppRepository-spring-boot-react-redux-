package com.yash.nutritionapp.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yash.nutritionapp.UserRole;
import com.yash.nutritionapp.UserStatus;

/**
 * Model class for user used to store user related data
 * @author Vanshika Chaturvedi
 *
 */
@Entity
@Table(name="users")
public class User {
	
		public User(Long id,
			@NotBlank(message = "userIdentification cannot be blank") @Size(min = 3, max = 255, message = "Please use 3 to 200 characters for userIdentification") String userIdentification,
			@NotBlank(message = "name cannot be blank") @Size(min = 3, max = 255, message = "Please use 3 to 200 characters for name") String name,
			@NotBlank(message = "contact cannot be blank") String contact,
			@NotBlank(message = "Please specify gender details") String gender,
			Date dob, String photo,
			@NotBlank(message = "Email cannot be blank") String email, UserRole role, UserStatus status, Double weight,
			Double height, String dietaryOrientation, Double intensity, String goal, String workOutTime,
			String wakeUpTime, String sleepTime,
			@NotBlank(message = "Medical Condition cannot be blank") String medicalConditon,
			@NotBlank(message = "Specify this field") String allergicTo,
			@NotBlank(message = "LoginName cannot be blank") String loginName,
			@NotBlank(message = "Please enter a valid password") String password) {
		super();
		this.id = id;
		this.userIdentification = userIdentification;
		this.name = name;
		this.contact = contact;
		this.gender = gender;
		this.dob = dob;
		this.photo = photo;
		this.email = email;
		this.role = role;
		this.status = status;
		this.weight = weight;
		this.height = height;
		this.dietaryOrientation = dietaryOrientation;
		this.intensity = intensity;
		this.goal = goal;
		this.workOutTime = workOutTime;
		this.wakeUpTime = wakeUpTime;
		this.sleepTime = sleepTime;
		this.medicalConditon = medicalConditon;
		this.allergicTo = allergicTo;
		this.loginName = loginName;
		this.password = password;
	}

		public User() {
		super();
	}

		@Id
		@GeneratedValue(strategy= GenerationType.IDENTITY)
		@Column(name="id_user")
		private Long id;
		
		@Column(nullable = false, unique = true)
		@NotBlank(message="userIdentification cannot be blank")
		@Size(min = 3, max = 255,message = "Please use 3 to 200 characters for userIdentification")
		/**
		 * userIdentification is unique and is String
		 */
		private String userIdentification;
		

		
		@NotBlank(message="name cannot be blank")
		@Size(min = 3, max = 255,message = "Please use 3 to 200 characters for name")
		@Column(nullable = false)
		/**
		 * name is of type String and used to store user's name
		 */
		private String name;
		
		@NotBlank(message="contact cannot be blank")
		/**
		 * contact is of type String and store user contact details
		 */
		private String contact;
		
		@NotBlank(message="Please specify gender details")
		@Column(nullable = false)
		/**
		 * gender is of type String and stores gender value
		 */
		private String gender;
		
		@JsonFormat(pattern = "dd/MM/yyyy")
		@Column(nullable = false)
		
		/**
		 * dob is Date of Birth and is of type String
		 */
		private Date dob;
		
		
		/**
		 * photo is used to store filename of with jpg/png extension
		 */
		private String photo;
		
		@NotBlank(message="Email cannot be blank")
		@Column(nullable = false)
		/**
		 * email stores email of user
		 */
		private String email;
		
		
		/**
		 * Role specifies whether a user is customer or a dietitian 
		 */
		private UserRole role = UserRole.USER;
		
		
		/**
		 * status defines if any user is active or blocked
		 */
		private UserStatus status = UserStatus.ACTIVE;
		
		
		/**
		 * weight is of type double and store weight of user
		 */
		private Double weight;
		
		
		/**
		 * height is of type double and stores height
		 */
		private Double height;
		
		
		/**
		 * diateryOrientation defines how the diet plan of the specific users is
		 */
		private String dietaryOrientation;
		
		
		/**
		 * intensity is a number which defines the ability to do work out on the scale of 1-10
		 */
		private Double intensity;
		
		
		/**
		 * goal defines the specific goal set by user or dietitian 
		 */
		private String goal;
		
		
		/**
		 * number of hours a person can workout
		 */
		private String workOutTime;
		
		
		/**
		 * time by which user wakes up
		 */
		private String wakeUpTime;
		
		
		/**
		 * time by which user goes to sleep
		 */
		private String sleepTime;
		
		@NotBlank(message="Medical Condition cannot be blank")
		/**
		/**
		 * medical condition defines if a user is having any medical conditions or not
		 */
		private String medicalConditon;
		
		@NotBlank(message="Specify this field")
		/**
		 * this is a String type stores value if a person is allergic to something
		 */
		private String allergicTo;
		
		@NotBlank(message="LoginName cannot be blank")
		@Column(nullable = false)
		/**
		 * loginNmae is the login name specified by user
		 */
		private String loginName;
		
		@NotBlank(message="Please enter a valid password")
		@Column(nullable = false)
		/**
		 * password is the password set by user
		 */
		private String password;

		

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getUserIdentification() {
			return userIdentification;
		}

		public void setUserIdentification(String userIdentification) {
			this.userIdentification = userIdentification;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getContact() {
			return contact;
		}

		public void setContact(String contact) {
			this.contact = contact;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public  Date getDob() {
			return dob;
		}

		public void setDob(Date dob) {
			this.dob = dob;
		}

		public String getPhoto() {
			return photo;
		}

		public void setPhoto(String photo) {
			this.photo = photo;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public UserRole getRole() {
			return role;
		}

		public void setRole(UserRole role) {
			this.role = role;
		}

		public UserStatus getStatus() {
			return status;
		}

		public void setStatus(UserStatus status) {
			this.status = status;
		}

		public Double getWeight() {
			return weight;
		}

		public void setWeight(Double weight) {
			this.weight = weight;
		}

		public Double getHeight() {
			return height;
		}

		public void setHeight(Double height) {
			this.height = height;
		}

		public String getDietaryOrientation() {
			return dietaryOrientation;
		}

		public void setDietaryOrientation(String dietaryOrientation) {
			this.dietaryOrientation = dietaryOrientation;
		}

		public Double getIntensity() {
			return intensity;
		}

		public void setIntensity(Double intensity) {
			this.intensity = intensity;
		}

		public String getGoal() {
			return goal;
		}

		public void setGoal(String goal) {
			this.goal = goal;
		}

		public String getWorkOutTime() {
			return workOutTime;
		}

		public void setWorkOutTime(String workOutTime) {
			this.workOutTime = workOutTime;
		}

		public String getWakeUpTime() {
			return wakeUpTime;
		}

		public void setWakeUpTime(String wakeUpTime) {
			this.wakeUpTime = wakeUpTime;
		}

		public String getSleepTime() {
			return sleepTime;
		}

		public void setSleepTiem(String sleepTime) {
			this.sleepTime = sleepTime;
		}

		public String getMedicalConditon() {
			return medicalConditon;
		}

		public void setMedicalConditon(String medicalConditon) {
			this.medicalConditon = medicalConditon;
		}

		public String getAllergicTo() {
			return allergicTo;
		}

		public void setAllergicTo(String allergicTo) {
			this.allergicTo = allergicTo;
		}

		public String getLoginName() {
			return loginName;
		}

		public void setLoginName(String loginName) {
			this.loginName = loginName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		@Override
		public String toString() {
			return "User [id=" + id + ", userIdentification=" + userIdentification + ", name=" + name + ", contact="
					+ contact + ", gender=" + gender + ", dob=" + dob + ", photo=" + photo + ", email=" + email
					+ ", role=" + role + ", status=" + status + ", weight=" + weight + ", height=" + height
					+ ", dietaryOrientation=" + dietaryOrientation + ", intensity=" + intensity + ", goal=" + goal
					+ ", workOutTime=" + workOutTime + ", wakeUpTime=" + wakeUpTime + ", sleepTime=" + sleepTime
					+ ", medicalConditon=" + medicalConditon + ", allergicTo=" + allergicTo + ", loginName=" + loginName
					+ ", password=" + password + "]";
		}


}
