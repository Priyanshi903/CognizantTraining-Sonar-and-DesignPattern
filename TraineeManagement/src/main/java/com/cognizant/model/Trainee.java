package com.cognizant.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trainee {
	@Id
	private int traineeId;
	private String name;
	private String emailId;
	
	private String cohortCode;
	
	@Enumerated(EnumType.STRING)
	private Track track;
}
