package com.bnta.chocolate.services;

import com.bnta.chocolate.ChocolateApplication;
import com.bnta.chocolate.dto.ChocolateRequest;
import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChocolateService {

    @Autowired
    ChocolateRepository chocolateRepository;

    @Autowired
    EstateService estateService;

    public Chocolate createNewChocolate(long id, ChocolateRequest chocolateRequest) {
        String newName = chocolateRequest.getName();
        int newCocoaPercentage = chocolateRequest.getCocoaPercentage();
        Estate estate = estateService.getEstateById(id).get();
        Chocolate chocolate = new Chocolate(newName, newCocoaPercentage, estate);
        chocolateRepository.save(chocolate);
        return chocolate;}


    public List<Chocolate> getAllChocolates(){
        return chocolateRepository.findAll();
    }




    public Chocolate getChocolateById(long id) {
        return chocolateRepository.findById(id).get();
    }

//    public Chocolate createNewChocolate(Chocolate chocolate) {
//        chocolateRepository.save(chocolate);
//        return chocolate;
//
//    }
}
