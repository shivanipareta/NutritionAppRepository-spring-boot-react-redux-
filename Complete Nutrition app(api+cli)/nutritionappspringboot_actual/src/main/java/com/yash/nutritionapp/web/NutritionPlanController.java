package com.yash.nutritionapp.web;

import java.util.List;

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

import com.yash.nutritionapp.domain.NutritionPlan;
import com.yash.nutritionapp.exceptions.NutritionPlanIdException;
import com.yash.nutritionapp.service.MapValidationErrorService;
import com.yash.nutritionapp.service.NutritionPlanService;


@RestController
@RequestMapping("/api/nutritionplan")
@CrossOrigin
public class NutritionPlanController {
	
	@Autowired
	private NutritionPlanService nutritionPlanService;
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
	@GetMapping("/all")
	public ResponseEntity<?> findAll() {
		List<NutritionPlan> nutritionPlan = nutritionPlanService.getAllNutritionPlans();
		return new ResponseEntity<List<NutritionPlan>>(nutritionPlan, HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<?> createNewNutritionPlan(@Valid @RequestBody NutritionPlan nutritionPlan, BindingResult result) throws NutritionPlanIdException {
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if (errorMap != null)
			return errorMap;
		NutritionPlan savedNutritionPlan=nutritionPlanService.saveOrUpdate(nutritionPlan);
		return new ResponseEntity<NutritionPlan>(savedNutritionPlan, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findByNutritionPlanId(@PathVariable long id) throws NutritionPlanIdException {
		NutritionPlan nutritionPlan=nutritionPlanService.getNutritionPlanById(id);
		return new ResponseEntity<NutritionPlan>(nutritionPlan, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteByNutritionPlanId(@PathVariable long id) throws NutritionPlanIdException {
		nutritionPlanService.deleteNutritionPlan(id);
		return new ResponseEntity<String>("Nutrition Plan with ID "+id+" is successfully deleted!", HttpStatus.OK);
	}
}
