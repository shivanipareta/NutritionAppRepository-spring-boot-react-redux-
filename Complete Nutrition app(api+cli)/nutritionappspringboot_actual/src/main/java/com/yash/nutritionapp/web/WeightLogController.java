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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.nutritionapp.domain.WeightLog;
import com.yash.nutritionapp.exceptions.WeightLogUserIDException;
import com.yash.nutritionapp.service.MapValidationErrorService;
import com.yash.nutritionapp.service.WeightLogService;


@RestController  
@RequestMapping("/api/weightlog") 
@CrossOrigin 

/**
 * Controller Class for Weight Log module of NutritionApp.
 * @author pradyumn.joshi
 */
public class WeightLogController {
	@Autowired
	private WeightLogService weightLogService;
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	/**
	 * Displays all values in db in JSON(Javascript object notation) Format.
	 * @return
	 */
	@GetMapping("/all")
	public ResponseEntity<?> findAll() {
		List<WeightLog> weightLogs = weightLogService.getAllWeightLog();
		return new ResponseEntity<List<WeightLog>>(weightLogs, HttpStatus.OK);
	}
	/**
	 * creates weight log.
	 * @param weightLog
	 * @param result
	 * @return
	 * @throws WeightLogUserIDException
	 */

	@PostMapping
	public ResponseEntity<?> createNewWeightLog(@RequestBody WeightLog weightLog, BindingResult result) throws WeightLogUserIDException {
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if (errorMap != null)
			return errorMap;
		WeightLog savedWeightLog = weightLogService.saveOrUpdate(weightLog);
		return new ResponseEntity<WeightLog>(savedWeightLog, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<?> updateWeightLog(@Valid @RequestBody WeightLog weightLog, BindingResult result) throws WeightLogUserIDException {
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if (errorMap != null)
			return errorMap;
		WeightLog savedWeightLog = weightLogService.update(weightLog);
		return new ResponseEntity<WeightLog>(savedWeightLog, HttpStatus.CREATED);
	}
	
	@GetMapping("/{weightLogUserId}")
	public ResponseEntity<?> findListByWeightLogUserId(@PathVariable String weightLogUserId) throws WeightLogUserIDException  {
		List<WeightLog> weightLogs = weightLogService.getWeightLogByUserId(weightLogUserId);
		return new ResponseEntity<List<WeightLog>>(weightLogs, HttpStatus.OK);
	}
	@DeleteMapping("/{weightLogUserId}")
	public ResponseEntity<?> deleteWeightLogByUserId(@PathVariable String weightLogUserId) throws WeightLogUserIDException {
		weightLogService.deleteWeightLogByUserId(weightLogUserId);
		return new ResponseEntity<String>(
				"WeightLog with " + weightLogUserId + " is successfully deleted", HttpStatus.OK);
	}
}

	
	
	


