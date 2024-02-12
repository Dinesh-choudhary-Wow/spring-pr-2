package com.springAndBoot2.entity;

import java.time.LocalTime;

public class DelicacyRequest {
	private String name;
    private LocalTime availableStartTime;
    private LocalTime availableEndTime;
    private String status;
    private double cost;
    private Long hotelId;
	public Long getHotelId() {
		return hotelId;
	}
	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalTime getAvailableStartTime() {
		return availableStartTime;
	}
	public void setAvailableStartTime(LocalTime availableStartTime) {
		this.availableStartTime = availableStartTime;
	}
	public LocalTime getAvailableEndTime() {
		return availableEndTime;
	}
	public void setAvailableEndTime(LocalTime availableEndTime) {
		this.availableEndTime = availableEndTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public DelicacyRequest(String name, LocalTime availableStartTime, LocalTime availableEndTime, String status,
			double cost, Long hotelId) {
		super();
		this.name = name;
		this.availableStartTime = availableStartTime;
		this.availableEndTime = availableEndTime;
		this.status = status;
		this.cost = cost;
		this.hotelId = hotelId;
	}
	
    
    
}
