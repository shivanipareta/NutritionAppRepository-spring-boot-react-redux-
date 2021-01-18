package com.yash.nutritionapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.nutritionapp.domain.NutritionPlan;
import com.yash.nutritionapp.exceptions.NutritionPlanIdException;
import com.yash.nutritionapp.repository.NutritionPlanRepository;
/**
 * This interface is used for providing services
 * @author satakshi.pachori
 *
 */
@Service
public class NutritionPlanService {

	@Autowired
	private NutritionPlanRepository nutritionPlanRepository;
	
	/**
	 * saveOrUpdate method is used for inserting or updating record
	 */
	public NutritionPlan saveOrUpdate(NutritionPlan nutritionPlan) throws NutritionPlanIdException
	{
		try
		{
			NutritionPlan savedNutritionPlan=nutritionPlanRepository.save(nutritionPlan);
			return savedNutritionPlan;
		}catch(Exception e) {
			e.printStackTrace();
			throw new NutritionPlanIdException("Nutrition Plan ID "+nutritionPlan.getId()+" already exitsts!");
		}
	}
	
	/**
	 * getAllNutritionPlans method is used for fetching all the records
	 */
	public List<NutritionPlan> getAllNutritionPlans()
	{
		return (List<NutritionPlan>)nutritionPlanRepository.findAll();
	}
	
	/**
	 * getNutritionPlanById method is used for fetching one record by its id
	 */
	public NutritionPlan getNutritionPlanById(long id) throws NutritionPlanIdException
	{
		NutritionPlan nutritionPlan=nutritionPlanRepository.findById(id);
		if(nutritionPlan==null)
		{
			throw new NutritionPlanIdException("Nutrition Plan with ID "+id+" does not exists!");

		}
		return nutritionPlan;
	}
	
	/**
	 * deleteNutritionPlan method is used for deleting on record by its id
	 */
	public void deleteNutritionPlan(long id) throws NutritionPlanIdException
	{
		NutritionPlan nutritionPlan=nutritionPlanRepository.findById(id);
		if(nutritionPlan==null)
		{
			throw new NutritionPlanIdException("Nutrition Plan with ID "+id+" does not exists!");
		}
		nutritionPlanRepository.delete(nutritionPlan);
	}

}
