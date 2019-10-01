package com.ticketbooking.vo;

public class Seat {

	
	public Seat() {
		// TODO Auto-generated constructor stub
	}
	private String number;
	
	private Double fare;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Double getFare() {
		return fare;
	}

	public void setFare(Double fare) {
		this.fare = fare;
	}

	@Override
	public String toString() {
		return "Seat [number=" + number + ", fare=" + fare + "]";
	}
	
	
	
	
	
	
}
