package com.cognizant;

import java.util.Scanner;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.model.Track;
import com.cognizant.model.Trainee;

import com.cognizant.repository.TraineeRepo;
import com.cognizant.repository.TraineeRepoImpl;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class TraineeManagementApplication {
	private static TraineeRepoImpl traineeRepoImpl;
	private static Scanner sc;
	
	private static void testAddTrainee() {
		sc=new Scanner(System.in);
		log.info("Enter the trainee id:");
		int traineeId = Integer.parseInt(sc.nextLine());

		log.info("Enter the trainee name:");
		String name = sc.nextLine();

		log.info("Enter email id:");
		String emailId = sc.nextLine();

		log.info("Enter the cohort code:");
		String cohortCode = sc.nextLine();

		Trainee trainee = new Trainee(traineeId, name, emailId, cohortCode, Track.DEFAULT);

		log.info("Enter the track number\n1.JAVAFSE\n2.DOTNET\n3.NETWORKING\n4.DEVOPS\5.TESTING");
		int track = Integer.parseInt(sc.nextLine());

		switch (track) {
		case 1:
			trainee.setTrack(Track.JAVAFSE);
			break;
		case 2:
			trainee.setTrack(Track.DOTNET);
			break;
		case 3:
			trainee.setTrack(Track.NETWORKING);
			break;
		case 4:
			trainee.setTrack(Track.DEVOPS);
			break;
		case 5:
			trainee.setTrack(Track.TESTING);
			break;
		}

		traineeRepoImpl.addTrainee(trainee);
		log.info("Trainee Added Successfully");

	}

	private static void testDeleteTrainee() {
		sc=new Scanner(System.in);
		log.info("Enter the trainee id:");
		int empId = Integer.parseInt(sc.nextLine());

		traineeRepoImpl.removeTrainee(empId);
		log.info("Trainee Deleted...........");

	}

	private static void testGetAllTaineeInCohort() {
		sc=new Scanner(System.in);
		log.info("Enter the cohort code:");
		String cohortCode = sc.nextLine();
		List<Trainee> trainees=traineeRepoImpl.getAllTraineesInCohort(cohortCode);
		log.info("All Trainees in {} ={}",cohortCode,trainees);
	}

	private static void testGetTraineeInACohort() {
		sc=new Scanner(System.in);
		log.info("Enter the trainee id:");
		int traineeId = Integer.parseInt(sc.nextLine());

		log.info("Enter the cohort code:");
		String cohortCode = sc.nextLine();

		Trainee trainee =traineeRepoImpl.getTraineeByNameInACohort(traineeId, cohortCode);
		log.info("Trainee {}", trainee);

	}

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(TraineeManagementApplication.class, args);
		traineeRepoImpl=context.getBean(TraineeRepoImpl.class);
		
//		testAddTrainee();
//		testGetTraineeInACohort();
		testGetAllTaineeInCohort();
	}

}
