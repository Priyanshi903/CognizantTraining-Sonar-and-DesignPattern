package com.cognizant.daoimpl;

import java.util.ArrayList;
import java.util.Scanner;

import com.cognizant.dao.FlightDao;
import com.cognizant.exception.CantDeletePassengerVIPException;
import com.cognizant.model.Flight;
import com.cognizant.model.Passenger;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FlightImpl implements FlightDao{	
	private Flight economyFlight;
	private Flight businessFlight;
	private static Scanner sc = new Scanner(System.in);

	public FlightImpl() {
		economyFlight = new Flight("1001E", "Economy", new ArrayList<Passenger>());
		businessFlight = new Flight("1001B", "Business", new ArrayList<Passenger>());
	}

	private void addPassengerToBusiness(Passenger passenger) {

		log.info("Adding passenger to buisness class");

		businessFlight.getPassengers().add(passenger);
		log.info("Business Flight {}", businessFlight);

		log.info("Passenger Added to buisness class");
		log.info("Business Flight ={}", businessFlight);
	}

	private void addPassengerToEconomy(Passenger passenger) {

		log.info("Adding passenger to Economy class");

		economyFlight.getPassengers().add(passenger);
		log.info("Economy Flight {}", economyFlight);

		log.info("Passenger Added to buisness class");
		log.info("Economy Flight ={}", economyFlight);
	}

	public void addPassenger() {

		log.info("How many passengers are you going to add?");
		int n = Integer.parseInt(sc.nextLine());
		boolean flag = true;
		while (flag) {

			log.info("Enter the passenger name: ");
			String name = sc.nextLine();

			log.info(" VIP?[Y/N]");
			String vipStatus = sc.nextLine();

			boolean vip = vipStatus.equalsIgnoreCase("Y");

			Passenger passenger=new Passenger(name, vip);
			
			log.debug("Passenger you want to add= {}", passenger);

			if (passenger.isVip()) {

				log.info("Choose Business(B) / Economy(E) ");
				String flightChoice = sc.nextLine();
				boolean isflightChoice = flightChoice.equalsIgnoreCase("B");
				if (isflightChoice) {
					addPassengerToBusiness(passenger);
				}
			} else
				addPassengerToEconomy(passenger);
			n--;
			if (n == 0)
				flag = false;
		}

	}

	private Passenger getPassengerType(String name) {

		for (Passenger passenger : economyFlight.getPassengers()) {
			if (passenger.getName().equalsIgnoreCase(name))
				return passenger;
		}

		for (Passenger passenger : businessFlight.getPassengers()) {
			if (passenger.getName().equalsIgnoreCase(name))
				return passenger;
		}

		return null;

	}

	public void removePassenger() throws CantDeletePassengerVIPException {

		log.info("Enter passenger name to be deleted");
		String name = sc.nextLine();
		
		Passenger passenger = getPassengerType(name);
		log.debug("Passenger going to be deleted={}",passenger);

		if (passenger!=null && passenger.isVip()) {

			throw new CantDeletePassengerVIPException("We cannot remove VIP");
		}
		if(economyFlight.getPassengers().contains(passenger)) {
			int index = economyFlight.getPassengers().indexOf(passenger);
			economyFlight.getPassengers().remove(index);
			}
		if(businessFlight.getPassengers().contains(passenger)) {
			int index = businessFlight.getPassengers().indexOf(passenger);
			businessFlight.getPassengers().remove(index);
			}

		log.info("Economy Flight after deleting passenger={}", economyFlight);
		log.info("Business Flight after deleting passenger={}", businessFlight);

	}

	


}
