package com.yash.nutritionapp.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.nutritionapp.constant.DietPlanConstant;
import com.yash.nutritionapp.domain.DietPlan;
import com.yash.nutritionapp.domain.User;
import com.yash.nutritionapp.exceptions.DietPlanIdException;
import com.yash.nutritionapp.repository.DietPlanRepository;

@Service
public class DietPlanService {

	@Autowired
	private DietPlanRepository dietPlanRepository;
	
	/**
	 * kg
	 */
	private double weight=40;
	/**
	 * meter
	 */
	private Double height=2.1;
	private double bmi;
	private int age=13;
	private String foodType;
	private String slots;


	public DietPlan saveOrUpdate(DietPlan dietPlan) throws DietPlanIdException {
		try {
	
	     // 	height = dietPlan.getUser().getHeight();
	     //    weight =dietPlan.getUser().getWeight(); 
			bmi = weight / (height * height);
		//    Date dob = dietPlan.getUser().getDob();
		 //   dietPlan.setUserId(dietPlan.getUser().getUserIdentification());
		    
//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//		    LocalDate birthday = LocalDate.parse((CharSequence) dob, formatter);
//			LocalDate today = LocalDate.now();
//			Period p = Period.between(birthday, today);
//			age = p.getYears();

			foodType = dietPlan.getFoodType();
			slots = dietPlan.getSlots();
			
			/**
			 * he/she is child
			 */
			if (age <= 14) {
				if (bmi >= 25) {
					
					if (foodType.equalsIgnoreCase(DietPlanConstant.VEG_FoodTYPE)) {
						
						if(dietPlan.getSlots().equalsIgnoreCase(DietPlanConstant.BREAKFAST)) {
							dietPlan.setMap(1);
							dietPlan.setProteinRatio(DietPlanConstant.WEIGHT_LOSS_PROTEIN_RATIO);
							dietPlan.setCarbsRatio(DietPlanConstant.WEIGHT_LOSS_CARBS_RATIO);
							dietPlan.setFatRatio(DietPlanConstant.WEIGHT_LOSS_FAT_RATIO);
							dietPlan.setTotal(DietPlanConstant.TOTAL_WEIGHT_LOSS);
							
							}
						else if(dietPlan.getSlots().equalsIgnoreCase(DietPlanConstant.LUNCH)) {
							dietPlan.setMap(2);
							dietPlan.setProteinRatio(DietPlanConstant.WEIGHT_LOSS_PROTEIN_RATIO);
							dietPlan.setCarbsRatio(DietPlanConstant.WEIGHT_LOSS_CARBS_RATIO);
							dietPlan.setFatRatio(DietPlanConstant.WEIGHT_LOSS_FAT_RATIO);
							dietPlan.setTotal(DietPlanConstant.TOTAL_WEIGHT_LOSS);
						}
						else {
							dietPlan.setMap(3);
							dietPlan.setProteinRatio(DietPlanConstant.WEIGHT_LOSS_PROTEIN_RATIO);
							dietPlan.setCarbsRatio(DietPlanConstant.WEIGHT_LOSS_CARBS_RATIO);
							dietPlan.setFatRatio(DietPlanConstant.WEIGHT_LOSS_FAT_RATIO);
							dietPlan.setTotal(DietPlanConstant.TOTAL_WEIGHT_LOSS);
						} 
					} 
					else {
						if(dietPlan.getSlots().equalsIgnoreCase(DietPlanConstant.BREAKFAST)) {
							dietPlan.setMap(4);
							dietPlan.setProteinRatio(DietPlanConstant.WEIGHT_LOSS_PROTEIN_RATIO);
							dietPlan.setCarbsRatio(DietPlanConstant.WEIGHT_LOSS_CARBS_RATIO);
							dietPlan.setFatRatio(DietPlanConstant.WEIGHT_LOSS_FAT_RATIO);
							dietPlan.setTotal(DietPlanConstant.TOTAL_WEIGHT_LOSS);
							} 
						else if(dietPlan.getSlots().equalsIgnoreCase(DietPlanConstant.LUNCH)) {
							dietPlan.setMap(5);
							dietPlan.setProteinRatio(DietPlanConstant.WEIGHT_LOSS_PROTEIN_RATIO);
							dietPlan.setCarbsRatio(DietPlanConstant.WEIGHT_LOSS_CARBS_RATIO);
							dietPlan.setFatRatio(DietPlanConstant.WEIGHT_LOSS_FAT_RATIO);
							dietPlan.setTotal(DietPlanConstant.TOTAL_WEIGHT_LOSS);
							} 
						else {
							dietPlan.setMap(6);
							dietPlan.setProteinRatio(DietPlanConstant.WEIGHT_LOSS_PROTEIN_RATIO);
							dietPlan.setCarbsRatio(DietPlanConstant.WEIGHT_LOSS_CARBS_RATIO);
							dietPlan.setFatRatio(DietPlanConstant.WEIGHT_LOSS_FAT_RATIO);
							dietPlan.setTotal(DietPlanConstant.TOTAL_WEIGHT_LOSS);
							} 
					}
					// over weight
				} else if (bmi >= 18.5 && bmi < 25) {
					if (foodType.equalsIgnoreCase(DietPlanConstant.VEG_FoodTYPE)) {
						if(dietPlan.getSlots().equalsIgnoreCase(DietPlanConstant.BREAKFAST)) { 
							dietPlan.setMap(7);
							dietPlan.setProteinRatio(DietPlanConstant.FIT_PROTEIN_RATIO);
							dietPlan.setCarbsRatio(DietPlanConstant.FIT_CARBS_RATIO);
							dietPlan.setFatRatio(DietPlanConstant.FIT_FAT_RATIO);
							dietPlan.setTotal(DietPlanConstant.TOTAL_FIT);
							}
						else if(dietPlan.getSlots().equalsIgnoreCase(DietPlanConstant.LUNCH)) {
							dietPlan.setMap(8);
							dietPlan.setProteinRatio(DietPlanConstant.FIT_PROTEIN_RATIO);
							dietPlan.setCarbsRatio(DietPlanConstant.FIT_CARBS_RATIO);
							dietPlan.setFatRatio(DietPlanConstant.FIT_FAT_RATIO);
							dietPlan.setTotal(DietPlanConstant.TOTAL_FIT);}
						else {
							dietPlan.setMap(9);
							dietPlan.setProteinRatio(DietPlanConstant.FIT_PROTEIN_RATIO);
							dietPlan.setCarbsRatio(DietPlanConstant.FIT_CARBS_RATIO);
							dietPlan.setFatRatio(DietPlanConstant.FIT_FAT_RATIO);
							dietPlan.setTotal(DietPlanConstant.TOTAL_FIT);
							}
					} else {
						if(dietPlan.getSlots().equalsIgnoreCase(DietPlanConstant.BREAKFAST)) {
							dietPlan.setMap(10);
							dietPlan.setProteinRatio(DietPlanConstant.FIT_PROTEIN_RATIO);
							dietPlan.setCarbsRatio(DietPlanConstant.FIT_CARBS_RATIO);
							dietPlan.setFatRatio(DietPlanConstant.FIT_FAT_RATIO);
							dietPlan.setTotal(DietPlanConstant.TOTAL_FIT);
							}
						else if(dietPlan.getSlots().equalsIgnoreCase(DietPlanConstant.LUNCH)) { 
							dietPlan.setMap(11);
							dietPlan.setProteinRatio(DietPlanConstant.FIT_PROTEIN_RATIO);
							dietPlan.setCarbsRatio(DietPlanConstant.FIT_CARBS_RATIO);
							dietPlan.setFatRatio(DietPlanConstant.FIT_FAT_RATIO);
							dietPlan.setTotal(DietPlanConstant.TOTAL_FIT);
							}
						else {
							dietPlan.setMap(12);
							dietPlan.setProteinRatio(DietPlanConstant.FIT_PROTEIN_RATIO);
							dietPlan.setCarbsRatio(DietPlanConstant.FIT_CARBS_RATIO);
							dietPlan.setFatRatio(DietPlanConstant.FIT_FAT_RATIO);
							dietPlan.setTotal(DietPlanConstant.TOTAL_FIT);
							}
					}
					// fit
				} else {
					if (foodType.equalsIgnoreCase(DietPlanConstant.VEG_FoodTYPE)) {
						if(dietPlan.getSlots().equalsIgnoreCase(DietPlanConstant.BREAKFAST)) {
							dietPlan.setMeals("Mushrooms, Green Vegetables, Milk");
							dietPlan.setMap(13);
							dietPlan.setProteinRatio(DietPlanConstant.WEIGHT_GAIN_PROTEIN_RATIO);
							dietPlan.setCarbsRatio(DietPlanConstant.WEIGHT_GAIN_CARBS_RATIO);
							dietPlan.setFatRatio(DietPlanConstant.WEIGHT_GAIN_FAT_RATIO);
							dietPlan.setTotal(DietPlanConstant.TOTAL_WEIGHT_GAIN);
							}
						else if(dietPlan.getSlots().equalsIgnoreCase(DietPlanConstant.LUNCH)) {
							dietPlan.setMap(14);
							dietPlan.setMeals("Mushrooms, Green Vegetables, Milk");
							dietPlan.setProteinRatio(DietPlanConstant.WEIGHT_GAIN_PROTEIN_RATIO);
							dietPlan.setCarbsRatio(DietPlanConstant.WEIGHT_GAIN_CARBS_RATIO);
							dietPlan.setFatRatio(DietPlanConstant.WEIGHT_GAIN_FAT_RATIO);
							dietPlan.setTotal(DietPlanConstant.TOTAL_WEIGHT_GAIN);
							}
						else {
							dietPlan.setMap(15);
							dietPlan.setMeals("Mushrooms, Green Vegetables, Milk");
							dietPlan.setProteinRatio(DietPlanConstant.WEIGHT_GAIN_PROTEIN_RATIO);
							dietPlan.setCarbsRatio(DietPlanConstant.WEIGHT_GAIN_CARBS_RATIO);
							dietPlan.setFatRatio(DietPlanConstant.WEIGHT_GAIN_FAT_RATIO);
							dietPlan.setTotal(DietPlanConstant.TOTAL_WEIGHT_GAIN);}
					} else {
						if(dietPlan.getSlots().equalsIgnoreCase(DietPlanConstant.BREAKFAST)) {
							dietPlan.setMap(16);
							dietPlan.setMeals("Chicken soup, Green Vegetables, Milk");
							dietPlan.setProteinRatio(DietPlanConstant.WEIGHT_GAIN_PROTEIN_RATIO);
							dietPlan.setCarbsRatio(DietPlanConstant.WEIGHT_GAIN_CARBS_RATIO);
							dietPlan.setFatRatio(DietPlanConstant.WEIGHT_GAIN_FAT_RATIO);
							dietPlan.setTotal(DietPlanConstant.TOTAL_WEIGHT_GAIN);
						}
						else if(dietPlan.getSlots().equalsIgnoreCase(DietPlanConstant.LUNCH)) {
							dietPlan.setMap(17);
							dietPlan.setMeals("Chicken soup, Green Vegetables, Milk");
							dietPlan.setProteinRatio(DietPlanConstant.WEIGHT_GAIN_PROTEIN_RATIO);
							dietPlan.setCarbsRatio(DietPlanConstant.WEIGHT_GAIN_CARBS_RATIO);
							dietPlan.setFatRatio(DietPlanConstant.WEIGHT_GAIN_FAT_RATIO);
							dietPlan.setTotal(DietPlanConstant.TOTAL_WEIGHT_GAIN);
						}
						else {
							dietPlan.setMap(18);
							dietPlan.setMeals("Chicken soup, Green Vegetables, Milk");
							dietPlan.setProteinRatio(DietPlanConstant.WEIGHT_GAIN_PROTEIN_RATIO);
							dietPlan.setCarbsRatio(DietPlanConstant.WEIGHT_GAIN_CARBS_RATIO);
							dietPlan.setFatRatio(DietPlanConstant.WEIGHT_GAIN_FAT_RATIO);
							dietPlan.setTotal(DietPlanConstant.TOTAL_WEIGHT_GAIN);
						}
					}
				}
			}
			/**
			 * he/she is teeneger
			 */
			else if (age > 14 && age < 30) {
				if (bmi >= 25) {
					if (foodType.equalsIgnoreCase(DietPlanConstant.VEG_FoodTYPE)) {
						if(dietPlan.getSlots().equalsIgnoreCase(DietPlanConstant.BREAKFAST)) {
							dietPlan.setMap(19);
							dietPlan.setProteinRatio(DietPlanConstant.WEIGHT_LOSS_PROTEIN_RATIO);
							dietPlan.setCarbsRatio(DietPlanConstant.WEIGHT_LOSS_CARBS_RATIO);
							dietPlan.setFatRatio(DietPlanConstant.WEIGHT_LOSS_FAT_RATIO);
							dietPlan.setTotal(DietPlanConstant.TOTAL_WEIGHT_LOSS);
						}
						else if(dietPlan.getSlots().equalsIgnoreCase(DietPlanConstant.LUNCH)) {
							dietPlan.setMap(20);
							dietPlan.setProteinRatio(DietPlanConstant.WEIGHT_LOSS_PROTEIN_RATIO);
							dietPlan.setCarbsRatio(DietPlanConstant.WEIGHT_LOSS_CARBS_RATIO);
							dietPlan.setFatRatio(DietPlanConstant.WEIGHT_LOSS_FAT_RATIO);
							dietPlan.setTotal(DietPlanConstant.TOTAL_WEIGHT_LOSS);
						}
						else {
							dietPlan.setMap(21);
							dietPlan.setProteinRatio(DietPlanConstant.WEIGHT_LOSS_PROTEIN_RATIO);
							dietPlan.setCarbsRatio(DietPlanConstant.WEIGHT_LOSS_CARBS_RATIO);
							dietPlan.setFatRatio(DietPlanConstant.WEIGHT_LOSS_FAT_RATIO);
							dietPlan.setTotal(DietPlanConstant.TOTAL_WEIGHT_LOSS);
						}
					} else {
						if(dietPlan.getSlots().equalsIgnoreCase(DietPlanConstant.BREAKFAST)) {
							dietPlan.setMap(22);
							dietPlan.setProteinRatio(DietPlanConstant.WEIGHT_LOSS_PROTEIN_RATIO);
							dietPlan.setCarbsRatio(DietPlanConstant.WEIGHT_LOSS_CARBS_RATIO);
							dietPlan.setFatRatio(DietPlanConstant.WEIGHT_LOSS_FAT_RATIO);
							dietPlan.setTotal(DietPlanConstant.TOTAL_WEIGHT_LOSS);
						}
						else if(dietPlan.getSlots().equalsIgnoreCase(DietPlanConstant.LUNCH)) {
							dietPlan.setMap(23);
							dietPlan.setProteinRatio(DietPlanConstant.WEIGHT_LOSS_PROTEIN_RATIO);
							dietPlan.setCarbsRatio(DietPlanConstant.WEIGHT_LOSS_CARBS_RATIO);
							dietPlan.setFatRatio(DietPlanConstant.WEIGHT_LOSS_FAT_RATIO);
							dietPlan.setTotal(DietPlanConstant.TOTAL_WEIGHT_LOSS);
						}
						else {
							dietPlan.setMap(24);
							dietPlan.setProteinRatio(DietPlanConstant.WEIGHT_LOSS_PROTEIN_RATIO);
							dietPlan.setCarbsRatio(DietPlanConstant.WEIGHT_LOSS_CARBS_RATIO);
							dietPlan.setFatRatio(DietPlanConstant.WEIGHT_LOSS_FAT_RATIO);
							dietPlan.setTotal(DietPlanConstant.TOTAL_WEIGHT_LOSS);
						}
					}
				} else if (bmi >= 18.5 && bmi < 25) {
					if (foodType.equalsIgnoreCase(DietPlanConstant.VEG_FoodTYPE)) {
						if(dietPlan.getSlots().equalsIgnoreCase(DietPlanConstant.BREAKFAST)) {
							dietPlan.setMap(25);
							dietPlan.setProteinRatio(DietPlanConstant.FIT_PROTEIN_RATIO);
							dietPlan.setCarbsRatio(DietPlanConstant.FIT_CARBS_RATIO);
							dietPlan.setFatRatio(DietPlanConstant.FIT_FAT_RATIO);
							dietPlan.setTotal(DietPlanConstant.TOTAL_FIT);
						}
						else if(dietPlan.getSlots().equalsIgnoreCase(DietPlanConstant.LUNCH)) {
							dietPlan.setMap(26);
							dietPlan.setProteinRatio(DietPlanConstant.FIT_PROTEIN_RATIO);
							dietPlan.setCarbsRatio(DietPlanConstant.FIT_CARBS_RATIO);
							dietPlan.setFatRatio(DietPlanConstant.FIT_FAT_RATIO);
							dietPlan.setTotal(DietPlanConstant.TOTAL_FIT);
						}
						else {
							dietPlan.setMap(27);
							dietPlan.setProteinRatio(DietPlanConstant.FIT_PROTEIN_RATIO);
							dietPlan.setCarbsRatio(DietPlanConstant.FIT_CARBS_RATIO);
							dietPlan.setFatRatio(DietPlanConstant.FIT_FAT_RATIO);
							dietPlan.setTotal(DietPlanConstant.TOTAL_FIT);
						}
					} else {
						if(dietPlan.getSlots().equalsIgnoreCase(DietPlanConstant.BREAKFAST)) {
							dietPlan.setMap(28);
							dietPlan.setProteinRatio(DietPlanConstant.FIT_PROTEIN_RATIO);
							dietPlan.setCarbsRatio(DietPlanConstant.FIT_CARBS_RATIO);
							dietPlan.setFatRatio(DietPlanConstant.FIT_FAT_RATIO);
							dietPlan.setTotal(DietPlanConstant.TOTAL_FIT);
						}
						else if(dietPlan.getSlots().equalsIgnoreCase(DietPlanConstant.LUNCH)) {
							dietPlan.setMap(29);
							dietPlan.setProteinRatio(DietPlanConstant.FIT_PROTEIN_RATIO);
							dietPlan.setCarbsRatio(DietPlanConstant.FIT_CARBS_RATIO);
							dietPlan.setFatRatio(DietPlanConstant.FIT_FAT_RATIO);
							dietPlan.setTotal(DietPlanConstant.TOTAL_FIT);
						}
						else {
							dietPlan.setMap(30);
							dietPlan.setProteinRatio(DietPlanConstant.FIT_PROTEIN_RATIO);
							dietPlan.setCarbsRatio(DietPlanConstant.FIT_CARBS_RATIO);
							dietPlan.setFatRatio(DietPlanConstant.FIT_FAT_RATIO);
							dietPlan.setTotal(DietPlanConstant.TOTAL_FIT);
						}
					}
				} else {
					if (foodType.equalsIgnoreCase(DietPlanConstant.VEG_FoodTYPE)) {
						if(dietPlan.getSlots().equalsIgnoreCase(DietPlanConstant.BREAKFAST)) {
							dietPlan.setMap(31);
							dietPlan.setProteinRatio(DietPlanConstant.WEIGHT_GAIN_PROTEIN_RATIO);
							dietPlan.setCarbsRatio(DietPlanConstant.WEIGHT_GAIN_CARBS_RATIO);
							dietPlan.setFatRatio(DietPlanConstant.WEIGHT_GAIN_FAT_RATIO);
							dietPlan.setTotal(DietPlanConstant.TOTAL_WEIGHT_GAIN);
						}
						else if(dietPlan.getSlots().equalsIgnoreCase(DietPlanConstant.LUNCH)) {
							dietPlan.setMap(32);
							dietPlan.setProteinRatio(DietPlanConstant.WEIGHT_GAIN_PROTEIN_RATIO);
							dietPlan.setCarbsRatio(DietPlanConstant.WEIGHT_GAIN_CARBS_RATIO);
							dietPlan.setFatRatio(DietPlanConstant.WEIGHT_GAIN_FAT_RATIO);
							dietPlan.setTotal(DietPlanConstant.TOTAL_WEIGHT_GAIN);
						}
						else {
							dietPlan.setMap(33);
							dietPlan.setProteinRatio(DietPlanConstant.WEIGHT_GAIN_PROTEIN_RATIO);
							dietPlan.setCarbsRatio(DietPlanConstant.WEIGHT_GAIN_CARBS_RATIO);
							dietPlan.setFatRatio(DietPlanConstant.WEIGHT_GAIN_FAT_RATIO);
							dietPlan.setTotal(DietPlanConstant.TOTAL_WEIGHT_GAIN);
						}
					} else {
						if(dietPlan.getSlots().equalsIgnoreCase(DietPlanConstant.BREAKFAST)) {
							dietPlan.setMap(34);
							dietPlan.setProteinRatio(DietPlanConstant.WEIGHT_GAIN_PROTEIN_RATIO);
							dietPlan.setCarbsRatio(DietPlanConstant.WEIGHT_GAIN_CARBS_RATIO);
							dietPlan.setFatRatio(DietPlanConstant.WEIGHT_GAIN_FAT_RATIO);
							dietPlan.setTotal(DietPlanConstant.TOTAL_WEIGHT_GAIN);
						}
						else if(dietPlan.getSlots().equalsIgnoreCase(DietPlanConstant.LUNCH)) {
							dietPlan.setMap(35);
							dietPlan.setProteinRatio(DietPlanConstant.WEIGHT_GAIN_PROTEIN_RATIO);
							dietPlan.setCarbsRatio(DietPlanConstant.WEIGHT_GAIN_CARBS_RATIO);
							dietPlan.setFatRatio(DietPlanConstant.WEIGHT_GAIN_FAT_RATIO);
							dietPlan.setTotal(DietPlanConstant.TOTAL_WEIGHT_GAIN);
						}
						else {
							dietPlan.setMap(36);
							dietPlan.setProteinRatio(DietPlanConstant.WEIGHT_GAIN_PROTEIN_RATIO);
							dietPlan.setCarbsRatio(DietPlanConstant.WEIGHT_GAIN_CARBS_RATIO);
							dietPlan.setFatRatio(DietPlanConstant.WEIGHT_GAIN_FAT_RATIO);
							dietPlan.setTotal(DietPlanConstant.TOTAL_WEIGHT_GAIN);
						}
					}
				}
			}
			/**
			 * he/she is senior citizen
			 */
			else {
				if (bmi >= 25) {
					if (foodType.equalsIgnoreCase(DietPlanConstant.VEG_FoodTYPE)) {
						if(dietPlan.getSlots().equalsIgnoreCase(DietPlanConstant.BREAKFAST)) {
							dietPlan.setMap(37);
							dietPlan.setProteinRatio(DietPlanConstant.WEIGHT_LOSS_PROTEIN_RATIO);
							dietPlan.setCarbsRatio(DietPlanConstant.WEIGHT_LOSS_CARBS_RATIO);
							dietPlan.setFatRatio(DietPlanConstant.WEIGHT_LOSS_FAT_RATIO);
							dietPlan.setTotal(DietPlanConstant.TOTAL_WEIGHT_LOSS);
						}
						else if(dietPlan.getSlots().equalsIgnoreCase(DietPlanConstant.LUNCH)) {
							dietPlan.setMap(38);
							dietPlan.setProteinRatio(DietPlanConstant.WEIGHT_LOSS_PROTEIN_RATIO);
							dietPlan.setCarbsRatio(DietPlanConstant.WEIGHT_LOSS_CARBS_RATIO);
							dietPlan.setFatRatio(DietPlanConstant.WEIGHT_LOSS_FAT_RATIO);
							dietPlan.setTotal(DietPlanConstant.TOTAL_WEIGHT_LOSS);
						}
						else {
							dietPlan.setMap(39);
							dietPlan.setProteinRatio(DietPlanConstant.WEIGHT_LOSS_PROTEIN_RATIO);
							dietPlan.setCarbsRatio(DietPlanConstant.WEIGHT_LOSS_CARBS_RATIO);
							dietPlan.setFatRatio(DietPlanConstant.WEIGHT_LOSS_FAT_RATIO);
							dietPlan.setTotal(DietPlanConstant.TOTAL_WEIGHT_LOSS);
						}
					} else {
						if(dietPlan.getSlots().equalsIgnoreCase(DietPlanConstant.BREAKFAST)) {
							dietPlan.setMap(40);
							dietPlan.setProteinRatio(DietPlanConstant.WEIGHT_LOSS_PROTEIN_RATIO);
							dietPlan.setCarbsRatio(DietPlanConstant.WEIGHT_LOSS_CARBS_RATIO);
							dietPlan.setFatRatio(DietPlanConstant.WEIGHT_LOSS_FAT_RATIO);
							dietPlan.setTotal(DietPlanConstant.TOTAL_WEIGHT_LOSS);
						}
						else if(dietPlan.getSlots().equalsIgnoreCase(DietPlanConstant.LUNCH)) {
							dietPlan.setMap(41);
							dietPlan.setProteinRatio(DietPlanConstant.WEIGHT_LOSS_PROTEIN_RATIO);
							dietPlan.setCarbsRatio(DietPlanConstant.WEIGHT_LOSS_CARBS_RATIO);
							dietPlan.setFatRatio(DietPlanConstant.WEIGHT_LOSS_FAT_RATIO);
							dietPlan.setTotal(DietPlanConstant.TOTAL_WEIGHT_LOSS);
						}
						else {
							dietPlan.setMap(42);
							dietPlan.setProteinRatio(DietPlanConstant.WEIGHT_LOSS_PROTEIN_RATIO);
							dietPlan.setCarbsRatio(DietPlanConstant.WEIGHT_LOSS_CARBS_RATIO);
							dietPlan.setFatRatio(DietPlanConstant.WEIGHT_LOSS_FAT_RATIO);
							dietPlan.setTotal(DietPlanConstant.TOTAL_WEIGHT_LOSS);
						}
					}
				} else if (bmi >= 18.5 && bmi < 25) {
					if (foodType.equalsIgnoreCase(DietPlanConstant.VEG_FoodTYPE)) {
						if(dietPlan.getSlots().equalsIgnoreCase(DietPlanConstant.BREAKFAST)) {
							dietPlan.setMap(43);
							dietPlan.setProteinRatio(DietPlanConstant.FIT_PROTEIN_RATIO);
							dietPlan.setCarbsRatio(DietPlanConstant.FIT_CARBS_RATIO);
							dietPlan.setFatRatio(DietPlanConstant.FIT_FAT_RATIO);
							dietPlan.setTotal(DietPlanConstant.TOTAL_FIT);
						}
						else if(dietPlan.getSlots().equalsIgnoreCase(DietPlanConstant.LUNCH)) {
							dietPlan.setMap(44);
							dietPlan.setProteinRatio(DietPlanConstant.FIT_PROTEIN_RATIO);
							dietPlan.setCarbsRatio(DietPlanConstant.FIT_CARBS_RATIO);
							dietPlan.setFatRatio(DietPlanConstant.FIT_FAT_RATIO);
							dietPlan.setTotal(DietPlanConstant.TOTAL_FIT);
						}
						else {
							dietPlan.setMap(45);
							dietPlan.setProteinRatio(DietPlanConstant.FIT_PROTEIN_RATIO);
							dietPlan.setCarbsRatio(DietPlanConstant.FIT_CARBS_RATIO);
							dietPlan.setFatRatio(DietPlanConstant.FIT_FAT_RATIO);
							dietPlan.setTotal(DietPlanConstant.TOTAL_FIT);
						}
					} else {
						if(dietPlan.getSlots().equalsIgnoreCase(DietPlanConstant.BREAKFAST)) {
							dietPlan.setMap(46);
							dietPlan.setProteinRatio(DietPlanConstant.FIT_PROTEIN_RATIO);
							dietPlan.setCarbsRatio(DietPlanConstant.FIT_CARBS_RATIO);
							dietPlan.setFatRatio(DietPlanConstant.FIT_FAT_RATIO);
							dietPlan.setTotal(DietPlanConstant.TOTAL_FIT);
						}
						else if(dietPlan.getSlots().equalsIgnoreCase(DietPlanConstant.LUNCH)) {
							dietPlan.setMap(47);
							dietPlan.setProteinRatio(DietPlanConstant.FIT_PROTEIN_RATIO);
							dietPlan.setCarbsRatio(DietPlanConstant.FIT_CARBS_RATIO);
							dietPlan.setFatRatio(DietPlanConstant.FIT_FAT_RATIO);
							dietPlan.setTotal(DietPlanConstant.TOTAL_FIT);
						}
						else {
							dietPlan.setMap(48);
							dietPlan.setProteinRatio(DietPlanConstant.FIT_PROTEIN_RATIO);
							dietPlan.setCarbsRatio(DietPlanConstant.FIT_CARBS_RATIO);
							dietPlan.setFatRatio(DietPlanConstant.FIT_FAT_RATIO);
							dietPlan.setTotal(DietPlanConstant.TOTAL_FIT);
						}
					}
				} else {
					if (foodType.equalsIgnoreCase(DietPlanConstant.VEG_FoodTYPE)) {
						if(dietPlan.getSlots().equalsIgnoreCase(DietPlanConstant.BREAKFAST)) {
							dietPlan.setMap(49);
							dietPlan.setProteinRatio(DietPlanConstant.WEIGHT_GAIN_PROTEIN_RATIO);
							dietPlan.setCarbsRatio(DietPlanConstant.WEIGHT_GAIN_CARBS_RATIO);
							dietPlan.setFatRatio(DietPlanConstant.WEIGHT_GAIN_FAT_RATIO);
							dietPlan.setTotal(DietPlanConstant.TOTAL_WEIGHT_GAIN);
						}
						else if(dietPlan.getSlots().equalsIgnoreCase(DietPlanConstant.LUNCH)) {
							dietPlan.setMap(50);
							dietPlan.setProteinRatio(DietPlanConstant.WEIGHT_GAIN_PROTEIN_RATIO);
							dietPlan.setCarbsRatio(DietPlanConstant.WEIGHT_GAIN_CARBS_RATIO);
							dietPlan.setFatRatio(DietPlanConstant.WEIGHT_GAIN_FAT_RATIO);
							dietPlan.setTotal(DietPlanConstant.TOTAL_WEIGHT_GAIN);
						}
						else {
							dietPlan.setMap(51);
							dietPlan.setProteinRatio(DietPlanConstant.WEIGHT_GAIN_PROTEIN_RATIO);
							dietPlan.setCarbsRatio(DietPlanConstant.WEIGHT_GAIN_CARBS_RATIO);
							dietPlan.setFatRatio(DietPlanConstant.WEIGHT_GAIN_FAT_RATIO);
							dietPlan.setTotal(DietPlanConstant.TOTAL_WEIGHT_GAIN);
						}
					} else {
						if(dietPlan.getSlots().equalsIgnoreCase(DietPlanConstant.BREAKFAST)) {
							dietPlan.setMap(52);
							dietPlan.setProteinRatio(DietPlanConstant.WEIGHT_GAIN_PROTEIN_RATIO);
							dietPlan.setCarbsRatio(DietPlanConstant.WEIGHT_GAIN_CARBS_RATIO);
							dietPlan.setFatRatio(DietPlanConstant.WEIGHT_GAIN_FAT_RATIO);
							dietPlan.setTotal(DietPlanConstant.TOTAL_WEIGHT_GAIN);
						}
						else if(dietPlan.getSlots().equalsIgnoreCase(DietPlanConstant.LUNCH)) {
							dietPlan.setMap(53);
							dietPlan.setProteinRatio(DietPlanConstant.WEIGHT_GAIN_PROTEIN_RATIO);
							dietPlan.setCarbsRatio(DietPlanConstant.WEIGHT_GAIN_CARBS_RATIO);
							dietPlan.setFatRatio(DietPlanConstant.WEIGHT_GAIN_FAT_RATIO);
							dietPlan.setTotal(DietPlanConstant.TOTAL_WEIGHT_GAIN);
						}
						else {
							dietPlan.setMap(54);
							dietPlan.setProteinRatio(DietPlanConstant.WEIGHT_GAIN_PROTEIN_RATIO);
							dietPlan.setCarbsRatio(DietPlanConstant.WEIGHT_GAIN_CARBS_RATIO);
							dietPlan.setFatRatio(DietPlanConstant.WEIGHT_GAIN_FAT_RATIO);
							dietPlan.setTotal(DietPlanConstant.TOTAL_WEIGHT_GAIN);
						}
					}
				}
			}

			dietPlan.setUserId(dietPlan.getUserId().toUpperCase());
			Long id = dietPlan.getId();
			dietPlanRepository.save(dietPlan);
			DietPlan savedDietPlan = dietPlanRepository.save(dietPlan);
			return savedDietPlan;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DietPlanIdException("User Id" + dietPlan.getUserId() + "already exists");
		}

	}


	public List<DietPlan> getAllDietPlan() {
		return (List<DietPlan>) dietPlanRepository.findAll();
	}

	public DietPlan getDietPlanByUserId(String userId) throws DietPlanIdException {
		DietPlan dietPlan = dietPlanRepository.findByUserId(userId.toUpperCase());
		if (dietPlan == null) {
			throw new DietPlanIdException("User Identifier " + userId.toUpperCase() + " not exists");
		}
		return dietPlan;
	}

	public void deleteDietPlanByUserId(String userId) throws DietPlanIdException {
		DietPlan dietPlan = dietPlanRepository.findByUserId(userId);
		if (dietPlan == null) {
			throw new DietPlanIdException("user Identifier " + userId.toUpperCase() + " not exists");
		}

		dietPlanRepository.delete(dietPlan);
	}

}
