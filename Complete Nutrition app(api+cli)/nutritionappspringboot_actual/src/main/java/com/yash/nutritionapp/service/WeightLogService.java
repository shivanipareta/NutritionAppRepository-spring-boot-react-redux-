package com.yash.nutritionapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.nutritionapp.domain.WeightLog;
import com.yash.nutritionapp.exceptions.WeightLogUserIDException;
import com.yash.nutritionapp.repository.WeightLogRepository;
/**
 * This class will give functionality of services for weight log.
 * @author pradyumn.joshi
 *
 */
@Service
public class WeightLogService {
	@Autowired
	/**
	 * Reference for WeightLogRepository
	 */
	private WeightLogRepository weightLogRepository;
	
	/**
	 * Saves or updates weight log of user by using userId.
	 * userId is unique attribute.
	 * @param weightLog
	 * @return
	 */
	
	public WeightLog saveOrUpdate(WeightLog weightLog) throws WeightLogUserIDException
	{
		try
		{
		WeightLog savedWeightLog=weightLogRepository.save(weightLog);
		
		return savedWeightLog;
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new WeightLogUserIDException("WeightLog  ");
		}}
	
	/**
	 * Displays whole list of users Weight Log.
	 * @return
	 */
	 public List<WeightLog> getAllWeightLog()
	 {
		 return (List <WeightLog>) weightLogRepository.findAll();
	 }
	 /**
	  * Updates WeightLog.
	  * @param weightLog
	  * @param userId
	  * @return
	  */
	 
	 public WeightLog update(WeightLog weightLog)
		{
		
			WeightLog savedWeightLog=weightLogRepository.save(weightLog);
		
			return savedWeightLog;
		}
	 /**
	  * Displays Weight Log of a perticular user by taking input as his/her user id.
	  * @param userId
	  * @return
	  */
	public List<WeightLog> getWeightLogByUserId(String userId) throws WeightLogUserIDException
	{
		return (List <WeightLog>) weightLogRepository.findWeightLogByUserId(userId);
		
	}
	 /**
	  * Delets Weight Log of a perticular user by taking input as his/her user id.
	  * @param userId
	  * @return
	 * @throws WeightLogUserIDException 
	  */
	public void deleteWeightLogByUserId(String userId) throws WeightLogUserIDException
	{
		List<WeightLog> weightLog=weightLogRepository.findWeightLogByUserId(userId);
		if(weightLog==null)
		{
			throw new WeightLogUserIDException("WeightLog user id does not exists!");

		}
		weightLogRepository.deleteAll(weightLog);
	}

}
