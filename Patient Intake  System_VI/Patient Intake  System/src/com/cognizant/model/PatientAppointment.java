package com.cognizant.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PatientAppointment {
	private String name;
	private String age;
	private String sex;
	private Date date;
}
