package com.cognizant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.model.Trainee;

@Repository
public interface TraineeRepo extends JpaRepository<Trainee, Integer>{
	public Trainee findByTraineeIdAndCohortCode(int traineeId,String cohortCode);
	public List<Trainee> findByCohortCode(String code);

}
