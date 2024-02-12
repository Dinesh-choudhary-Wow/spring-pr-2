package com.springAndBoot2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springAndBoot2.entity.Delicacy;
import com.springAndBoot2.entity.DelicacyRequest;
import com.springAndBoot2.service.DelicacyService;

@RestController
@RequestMapping("/delicacies")
public class DelicacyController {
    
	@Autowired
    private DelicacyService delicacyService;
    
	@PostMapping("/add")
    public ResponseEntity<Delicacy> addDelicacy(@RequestBody DelicacyRequest delicacyRequest) {
        Delicacy addedDelicacy = delicacyService.addDelicacy(delicacyRequest);
        return new ResponseEntity<>(addedDelicacy, HttpStatus.CREATED);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<Delicacy> updateDelicacy(@PathVariable Long id, @RequestBody Delicacy delicacy) {
        Delicacy updatedDelicacy = delicacyService.updateDelicacy(id, delicacy);
        return new ResponseEntity<>(updatedDelicacy, HttpStatus.OK);
    }
    
}
