package com.cognizant.model;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.cognizant.util.DateUtil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@Slf4j
public class ClinicCalendar {
	private List<PatientAppointment> patientList;
	
	public static  List<PatientAppointment> getFilteredList(Date patientDate,List<PatientAppointment> patientList) {
		return patientList.stream().filter(e -> e.getDate().equals(patientDate)
				|| DateUtil.convertToBeforeTime(e.getDate()).before(patientDate)
				|| DateUtil.convertToAfterTime(e.getDate()).after(patientDate)).collect(Collectors.toList());
	
	}
	
	
	public boolean addPatient(PatientAppointment patientAppointment) {
		Date patientDate = patientAppointment.getDate();	
		List<PatientAppointment> filteredList = getFilteredList(patientDate,patientList);
		if(filteredList.isEmpty()) {
			patientList.add(patientAppointment);
			return(true);
		}
		log.error("the timings are already booked");
		return(false);
	}
}
