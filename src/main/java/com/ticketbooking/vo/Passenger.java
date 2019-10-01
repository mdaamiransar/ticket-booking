package com.ticketbooking.vo;



public class Passenger {

	public Passenger() {
		
	}
	
	private String name;

	private Integer age;

	private String gender;
	
	private Seat seat;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	@Override
	public String toString() {
		return "Passenger [name=" + name + ", age=" + age + ", gender=" + gender + ", seat=" + seat + "]";
	}
	
}
