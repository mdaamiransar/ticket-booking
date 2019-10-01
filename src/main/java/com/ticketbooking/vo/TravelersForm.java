package com.ticketbooking.vo;

import java.util.List;

public class TravelersForm {

	private PassengerContact passengerContact;
	
	private List<Passenger> passengers;

	public PassengerContact getPassengerContact() {
		return passengerContact;
	}

	public void setPassengerContact(PassengerContact passengerContact) {
		this.passengerContact = passengerContact;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

	@Override
	public String toString() {
		return "TravelersForm [passengerContact=" + passengerContact
				+ ", passengers=" + passengers + "]";
	}
	
	
	
	
	
}
