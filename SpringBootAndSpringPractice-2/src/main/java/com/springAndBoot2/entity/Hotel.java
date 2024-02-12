package com.springAndBoot2.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String address;

	private LocalTime startTime;

	private LocalTime endTime;

	private String status;

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;
	
	@OneToMany(mappedBy = "hotel")
    private Set<Delicacy> delicacies = new HashSet<>();

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Set<Delicacy> getDelicacies() {
		return delicacies;
	}

	public void setDelicacies(Set<Delicacy> delicacies) {
		this.delicacies = delicacies;
	}

	public Hotel(Long id, String name, String address, LocalTime startTime, LocalTime endTime, String status,
			LocalDateTime createdAt, LocalDateTime updatedAt, Set<Delicacy> delicacies) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.startTime = startTime;
		this.endTime = endTime;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.delicacies = delicacies;
	}

	

}
