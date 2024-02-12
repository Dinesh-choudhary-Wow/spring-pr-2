package com.springAndBoot2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springAndBoot2.HotelSearchCriteria;
import com.springAndBoot2.entity.Hotel;
import com.springAndBoot2.service.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;
    
    @PostMapping
    public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel) {
        Hotel addedHotel = hotelService.addHotel(hotel);
        return new ResponseEntity<>(addedHotel, HttpStatus.CREATED);
    }
    
    @PostMapping("/search")
    public ResponseEntity<List<Hotel>> searchHotels(@RequestBody HotelSearchCriteria searchCriteria) {
        List<Hotel> foundHotels = hotelService.searchHotels(searchCriteria);
        return new ResponseEntity<>(foundHotels, HttpStatus.OK);
    }
}
