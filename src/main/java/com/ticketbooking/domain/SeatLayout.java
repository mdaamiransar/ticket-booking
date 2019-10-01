package com.ticketbooking.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.Transient;

//import org.apache.log4j.Logger;
import org.jboss.logging.Logger;

@Entity
public class SeatLayout {

	
	protected static Logger logger = Logger.getLogger(SeatLayout.class);
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private Integer bus;
	
	private String name;
	
	//0=seater
	//1==horizontal sleeper
	//2=vertical sleeper
	private Integer seatType;
	
	private Integer deck;
	
	private Integer totalSeats;
	
	private Integer layoutType;
		
	private Integer lastRowSeats;
	
	private Integer noOfSleeperSeats;
	
	private String seatStatus;
	
	private Integer row;
	
	private Integer col;
	
	private Integer length;
	
	private Integer width;
	
	private Integer zindex;
	
	private String seatNo;
	
	private Integer baseFare;
	
	private Integer fare;
	
	private Integer ladiesSeat;
	
	private String available;
	
	private Integer views;
	
	private Boolean status;
	
	private String createdBy;
	
	private String modifiedBy;
	
	private String createdDate;
	
	private String modifiedDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBus() {
		return bus;
	}

	public void setBus(Integer bus) {
		this.bus = bus;
	}

	public Integer getSeatType() {
		return seatType;
	}

	public void setSeatType(Integer seatType) {
		this.seatType = seatType;
	}

	public Integer getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(Integer totalSeats) {
		this.totalSeats = totalSeats;
	}

	public Integer getLayoutType() {
		return layoutType;
	}

	public void setLayoutType(Integer layoutType) {
		this.layoutType = layoutType;
	}

	public Integer getLastRowSeats() {
		return lastRowSeats;
	}

	public void setLastRowSeats(Integer lastRowSeats) {
		this.lastRowSeats = lastRowSeats;
	}

	public Integer getViews() {
		return views;
	}

	public void setViews(Integer views) {
		this.views = views;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Integer getNoOfSleeperSeats() {
		return noOfSleeperSeats;
	}

	public void setNoOfSleeperSeats(Integer noOfSleeperSeats) {
		this.noOfSleeperSeats = noOfSleeperSeats;
	}

	public Integer getRow() {
		return row;
	}

	public void setRow(Integer row) {
		this.row = row;
	}

	public Integer getCol() {
		return col;
	}

	public void setCol(Integer col) {
		this.col = col;
	}

	public Integer getDeck() {
		return deck;
	}

	public void setDeck(Integer deck) {
		this.deck = deck;
	}

	public String getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}

	public Integer getFare() {
		return fare;
	}

	public void setFare(Integer fare) {
		this.fare = fare;
	}

	public Integer getBaseFare() {
		return baseFare;
	}

	public void setBaseFare(Integer baseFare) {
		this.baseFare = baseFare;
	}

	public Integer getLadiesSeat() {
		return ladiesSeat;
	}

	public void setLadiesSeat(Integer ladiesSeat) {
		this.ladiesSeat = ladiesSeat;
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}

	
	public String getSeatStatus() {
		return seatStatus;
	}

	public void setSeatStatus(String seatStatus) {
		this.seatStatus = seatStatus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getZindex() {
		return zindex;
	}

	public void setZindex(Integer zindex) {
		this.zindex = zindex;
	}

	
	@Transient
	private int seat;
	
	
	
public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	//	length=1 and width=1 - seater
//			length=2 and width=1 - horizontal sleeper
//			length=1 and width=2 - vertical sleeper
	 @PostLoad
	public void setSeatType(){
		logger.warn("hey harry>>> .................!" );
		if(length == 1 && width ==1){
			seat=0;//seater
		} else if(length == 2 && width == 1){
			seat = 1;//Horizontal sleeper
		} else if(length == 1 && width == 2){
			seat =2;//Vertical sleeper
		}
		
		logger.warn(" testing seat type:: "+ getSeatType());
	}
	
}