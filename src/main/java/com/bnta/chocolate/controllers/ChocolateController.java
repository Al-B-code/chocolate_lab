package com.bnta.chocolate.controllers;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.services.ChocolateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value ="/chocolates")
public class ChocolateController {

    @Autowired
    ChocolateService chocolateService;



    @PostMapping

    public ResponseEntity<Chocolate> addNewChocolate(
            @RequestParam long id,
            @RequestBody String name,
            @RequestBody int cocoaPercentage
            ) {
     Chocolate chocolate = chocolateService.createNewChocolate(id, name, cocoaPercentage);
      return new ResponseEntity<>(chocolate, HttpStatus.CREATED);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Chocolate> getChocolateById(@PathVariable long id){
        Chocolate chocolate = chocolateService.getChocolateById(id);
        return new ResponseEntity<>(chocolate, HttpStatus.OK);
    }





}
