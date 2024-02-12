package com.springAndBoot2.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springAndBoot2.DelicacyRepository;
import com.springAndBoot2.HotelRepository;
import com.springAndBoot2.entity.Delicacy;
import com.springAndBoot2.entity.DelicacyRequest;
import com.springAndBoot2.entity.Hotel;
import com.springAndBoot2.exception.ResourceNotFoundException;

@Service
public class DelicacyService {
    
	@Autowired
    private DelicacyRepository delicacyRepository;
    
    @Autowired
    private HotelRepository hotelRepository;

    public Delicacy addDelicacy(DelicacyRequest delicacyRequest) {
        Hotel hotel = hotelRepository.findById(delicacyRequest.getHotelId())
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with id: " + delicacyRequest.getHotelId()));
        
        Delicacy delicacy = new Delicacy();
        delicacy.setName(delicacyRequest.getName());
        delicacy.setAvailableStartTime(delicacyRequest.getAvailableStartTime());
        delicacy.setAvailableEndTime(delicacyRequest.getAvailableEndTime());
        delicacy.setStatus(delicacyRequest.getStatus());
        delicacy.setCost(delicacyRequest.getCost());
        delicacy.setHotel(hotel);
        // Set audit information
        delicacy.setCreatedAt(LocalDateTime.now());
        delicacy.setUpdatedAt(LocalDateTime.now());
        
        return delicacyRepository.save(delicacy);
    }

	public Delicacy updateDelicacy(Long id, Delicacy delicacy) {
		// TODO Auto-generated method stub
		return null;
	}
    
}
