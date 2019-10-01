package com.ticketbooking.domain;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Bus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String code;
	
	private String name;
	
	private Integer regiNumber;
	
	private Integer type;
	
	private Integer maximumSeats;
	
	private String startPoint;
	
	private String endPoint;
	
	private String startTime;
	
	private String endTime;
	
	private Integer amenities;
	
	private String image;
	
	private Integer views;
	
	private Boolean status;
	
	private String createdBy;
	
	private String modifiedBy;
	
	private String createdDate;
	
	private String modifiedDate;
	
	//adding fields
	private Integer fare;
	
	private Integer promoCode;
	
	private String video;
	
	private String youtubeURL;
	
	private Integer seatType;
	
	private Integer layoutType;
	
	private Integer totalSeats;
	
	private Integer totalRows;
	
	private Integer totalCols;
	
	private Integer deck;
	
	private Integer totalLastRowSeats;
	
	private Integer totalSleeperSeats;
	
	
	
	@Transient
	private MultipartFile file;
			
	public MultipartFile getFile() {
		return file;
	}
	
	public void setFile(MultipartFile file) {
		this.file = file;
	}

	// default constructor
	public Bus() {

		this.code = "BUS" + UUID.randomUUID().toString().substring(26).toUpperCase();

	}
		
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRegiNumber() {
		return regiNumber;
	}

	public void setRegiNumber(Integer regiNumber) {
		this.regiNumber = regiNumber;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getMaximumSeats() {
		return maximumSeats;
	}

	public void setMaximumSeats(Integer maximumSeats) {
		this.maximumSeats = maximumSeats;
	}

	public String getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(String startPoint) {
		this.startPoint = startPoint;
	}

	public String getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Integer getAmenities() {
		return amenities;
	}

	public void setAmenities(Integer amenities) {
		this.amenities = amenities;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getViews() {
		return views;
	}

	public void setViews(Integer views) {
		this.views = views;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
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

	public Integer getFare() {
		return fare;
	}

	public void setFare(Integer fare) {
		this.fare = fare;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public String getYoutubeURL() {
		return youtubeURL;
	}

	public void setYoutubeURL(String youtubeURL) {
		this.youtubeURL = youtubeURL;
	}

	public Integer getSeatType() {
		return seatType;
	}

	public void setSeatType(Integer seatType) {
		this.seatType = seatType;
	}

	public Integer getLayoutType() {
		return layoutType;
	}

	public void setLayoutType(Integer layoutType) {
		this.layoutType = layoutType;
	}

	public Integer getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(Integer totalSeats) {
		this.totalSeats = totalSeats;
	}

	public Integer getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(Integer totalRows) {
		this.totalRows = totalRows;
	}

	public Integer getTotalCols() {
		return totalCols;
	}

	public void setTotalCols(Integer totalCols) {
		this.totalCols = totalCols;
	}

	public Integer getTotalLastRowSeats() {
		return totalLastRowSeats;
	}

	public void setTotalLastRowSeats(Integer totalLastRowSeats) {
		this.totalLastRowSeats = totalLastRowSeats;
	}

	public Integer getTotalSleeperSeats() {
		return totalSleeperSeats;
	}

	public void setTotalSleeperSeats(Integer totalSleeperSeats) {
		this.totalSleeperSeats = totalSleeperSeats;
	}

	public Integer getDeck() {
		return deck;
	}

	public void setDeck(Integer deck) {
		this.deck = deck;
	}

	public Integer getPromoCode() {
		return promoCode;
	}

	public void setPromoCode(Integer promoCode) {
		this.promoCode = promoCode;
	}
}