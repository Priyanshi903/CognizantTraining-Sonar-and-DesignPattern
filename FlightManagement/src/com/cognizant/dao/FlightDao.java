package com.cognizant.dao;


import com.cognizant.exception.CantDeletePassengerVIPException;

public interface FlightDao {
	public void addPassenger();

	public void removePassenger() throws CantDeletePassengerVIPException;

}
