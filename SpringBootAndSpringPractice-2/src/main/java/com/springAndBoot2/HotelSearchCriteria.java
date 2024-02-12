package com.springAndBoot2;

import java.time.LocalTime;

public class HotelSearchCriteria {
	private String hotelName;
    private String status;
    private LocalTime startTime;
    private LocalTime endTime;
    private String delicacyName;
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	public LocalTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
	public String getDelicacyName() {
		return delicacyName;
	}
	public void setDelicacyName(String delicacyName) {
		this.delicacyName = delicacyName;
	}
	public HotelSearchCriteria(String hotelName, String status, LocalTime startTime, LocalTime endTime,
			String delicacyName) {
		super();
		this.hotelName = hotelName;
		this.status = status;
		this.startTime = startTime;
		this.endTime = endTime;
		this.delicacyName = delicacyName;
	}
    
    
    
}
