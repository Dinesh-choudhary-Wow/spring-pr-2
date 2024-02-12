package com.springAndBoot2.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springAndBoot2.HotelRepository;
import com.springAndBoot2.HotelSearchCriteria;
import com.springAndBoot2.entity.Delicacy;
import com.springAndBoot2.entity.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;
    
    public Hotel addHotel(Hotel hotel) {

        hotel.setCreatedAt(LocalDateTime.now());
        hotel.setUpdatedAt(LocalDateTime.now());
        return hotelRepository.save(hotel);
    }
    
    @Autowired
    private EntityManager entityManager;

    public List<Hotel> searchHotels(HotelSearchCriteria searchCriteria) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Hotel> query = builder.createQuery(Hotel.class);
        Root<Hotel> root = query.from(Hotel.class);
        List<Predicate> predicates = new ArrayList<>();

        // Add predicates based on provided search criteria
        if (searchCriteria.getHotelName() != null && !searchCriteria.getHotelName().isEmpty()) {
            predicates.add(builder.equal(root.get("name"), searchCriteria.getHotelName()));
        }
        if (searchCriteria.getStatus() != null && !searchCriteria.getStatus().isEmpty()) {
            predicates.add(builder.equal(root.get("status"), searchCriteria.getStatus()));
        }
        if (searchCriteria.getStartTime() != null) {
            predicates.add(builder.lessThanOrEqualTo(root.get("startTime"), searchCriteria.getStartTime()));
        }
        if (searchCriteria.getEndTime() != null) {
            predicates.add(builder.greaterThanOrEqualTo(root.get("endTime"), searchCriteria.getEndTime()));
        }

        // Join with delicacies if delicacyName is provided
        if (searchCriteria.getDelicacyName() != null && !searchCriteria.getDelicacyName().isEmpty()) {
            Join<Hotel, Delicacy> delicacyJoin = root.join("delicacies");
            predicates.add(builder.equal(delicacyJoin.get("name"), searchCriteria.getDelicacyName()));
        }

        query.select(root).distinct(true).where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(query).getResultList();
    }
}
