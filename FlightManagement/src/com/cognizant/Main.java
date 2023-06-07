package com.cognizant;

import com.cognizant.daoimpl.FlightImpl;
import com.cognizant.exception.CantDeletePassengerVIPException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
	
	private static FlightImpl flightImpl = new FlightImpl();

	private static void testAddPassengers() {
		flightImpl.addPassenger();
	}

	private static void testDeletePasseneger() throws CantDeletePassengerVIPException {
		flightImpl.removePassenger();
	}

	public static void main(String[] args) {

		log.info("Flight Management Application Started");

		log.info("Adding a passenger .......Start");
		testAddPassengers();
		log.info("All Passengers Added........End");

		
		try {
			log.info("Delete a passenger .......Start");
			testDeletePasseneger();
			log.info("Passenger Deleted........End");
		} catch (CantDeletePassengerVIPException e) {
			
			log.warn(e.getMessage());
		}
		

	}

}
