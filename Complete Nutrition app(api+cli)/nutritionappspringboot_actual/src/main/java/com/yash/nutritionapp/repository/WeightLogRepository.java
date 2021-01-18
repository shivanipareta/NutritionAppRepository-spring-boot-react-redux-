package com.yash.nutritionapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.yash.nutritionapp.domain.WeightLog;

@Repository
/**
 * This interface implements Build in repository of spring boot which has all CRUD operations defined.
 * @author pradyumn.joshi
 *
 */
public interface WeightLogRepository extends CrudRepository<WeightLog, Long>{
	List<WeightLog> findByUserId(String userId);
	
	
	@Query("select w From WeightLog w WHERE w.userId=:n")
	List<WeightLog> findWeightLogByUserId(@Param("n") String userId);

}
