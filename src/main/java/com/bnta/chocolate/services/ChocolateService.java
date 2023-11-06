package com.bnta.chocolate.services;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChocolateService {

    @Autowired
    ChocolateRepository chocolateRepository;

    @Autowired
    EstateService estateService;


    public Chocolate createNewChocolate(long id, String name, int cocoaPercentage){

        Estate estate= estateService.getEstateById(id).get();
        Chocolate chocolate = new Chocolate(name, cocoaPercentage, estate);
        chocolateRepository.save(chocolate);
        return chocolate;
    }


    public Chocolate getChocolateById(long id) {
        return chocolateRepository.findById(id);
    }
}
