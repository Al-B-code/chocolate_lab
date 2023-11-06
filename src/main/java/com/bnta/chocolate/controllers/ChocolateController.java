package com.bnta.chocolate.controllers;

import com.bnta.chocolate.dto.ChocolateRequest;
import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.services.ChocolateService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value ="/chocolates")
public class ChocolateController {

    @Autowired
    ChocolateService chocolateService;



    @PostMapping(value = "/{id}")
    public ResponseEntity<Chocolate> addNewChocolate(
            @PathVariable Long id,
            @RequestBody ChocolateRequest request)
            throws JsonProcessingException {
        Chocolate chocolate = chocolateService.createNewChocolate(id, request);
        return new ResponseEntity<>(chocolate, HttpStatus.CREATED);
    }




    @GetMapping(value = "/{id}")
    public ResponseEntity<Chocolate> getChocolateById(@PathVariable Long id){
        Chocolate chocolate = chocolateService.getChocolateById(id);
        return new ResponseEntity<>(chocolate, HttpStatus.OK);
    }





}
