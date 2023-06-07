package com.cognizant;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Scanner;

import com.cognizant.model.PatientAppointment;
import com.cognizant.util.DateUtil;
import com.cognizant.model.ClinicCalendar;
import com.cognizant.model.Doctor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
	private static ClinicCalendar clinicCalendar;

	// booking new details
	public static boolean addPatientDetails(String name,String age,String sex,String date,String time) {
		log.info("started addPatientDetails method");
		try {
			Date currentDate = DateUtil.convertToDate(date+" "+time);
			PatientAppointment patientAppointment = new PatientAppointment(name,age,sex,currentDate);
			if(clinicCalendar.addPatient(patientAppointment)) {
				log.info("patient appointment booked successfully ");
			}
			else {
				log.warn("check the booking details and availability of time");
			}
			log.info("patient details are {}",patientAppointment);
			return(true);
		}
		catch(Exception e) {
			log.error("error {}", e);
		}
		log.info("ended addPatientDetails Method");
		return(false);
	}
	
	// to show new appointments
	public static void seeAllAppointments() {
		log.info("entered seeAllAppointments method");
		List<PatientAppointment> patientList = clinicCalendar.getPatientList();
		log.info("All appointments");
		patientList.stream().forEach(e->log.info(e.toString()));
		log.info("existing seeAllAppointments method");
	}

	public static void main(String[] args) {
		log.info("main method started");
		Scanner scan = new Scanner(System.in);
		clinicCalendar = new ClinicCalendar(new ArrayList<PatientAppointment>());
		boolean isLoop = true;
		while (isLoop) {
			log.info("choose correct option \n 1.add a patient appointment \n 2.view all appointments\n 3.exit");
			int option = Integer.parseInt(scan.nextLine());
			switch (option) {
			case 1:
				log.info("enter patient details");
				log.info("enter name");
				String name = scan.nextLine();
				log.info("enter age");
				String age = scan.nextLine();
				log.info("enter sex type");
				String sex = scan.nextLine();
				log.info("enter date in the format of (dd-MM-yyyy)");
				String date = scan.nextLine();
				log.info("enter time (HH:mm)");
//				for(Doctor currentDoctor: Doctor.values()) {
//					log.info("{}",currentDoctor);
//				}
				String time = scan.nextLine();
				addPatientDetails(name, age, sex, date, time);
				break;
			case 2:
				seeAllAppointments();
				break;
			case 3:
				isLoop = false;
				break;
			default: 
				log.info("entered wrong option");
			}
		}

		log.info("existed from main method");
	}
}
