package com.springAndBoot2.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Delicacy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    private LocalTime availableStartTime;
    
    private LocalTime availableEndTime;
    
    private String status; 
    
    private double cost;
    
    // Audit columns
    private LocalDateTime createdAt;
    
    private LocalDateTime updatedAt;
    
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    @JsonBackReference
    private Hotel hotel;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}



	public Delicacy(Long id, String name, LocalTime availableStartTime, LocalTime availableEndTime, String status,
			double cost, LocalDateTime createdAt, LocalDateTime updatedAt, Hotel hotel) {
		super();
		this.id = id;
		this.name = name;
		this.availableStartTime = availableStartTime;
		this.availableEndTime = availableEndTime;
		this.status = status;
		this.cost = cost;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.hotel = hotel;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Delicacy() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}

