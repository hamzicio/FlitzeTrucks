package com.truck.app.api.v1.controller;

import com.truck.app.dto.TruckDto;
import com.truck.app.dto.UpdateTruckDto;
import com.truck.app.dto.TrucksDto;
import com.truck.app.exception.TruckException;
import com.truck.app.exception.TruckNotFoundException;
import com.truck.app.service.TruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@CrossOrigin("*")
@RestController
@RequestMapping("/v1/trucks")
public class TruckController {

    private TruckService truckService;

    @Autowired
    TruckController(TruckService truckService) {
        this.truckService= truckService;
    }

    @GetMapping(value = "")
    public ResponseEntity<TrucksDto> getTrucks(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size,@RequestParam(defaultValue = "all") String status) throws TruckException {
            return new ResponseEntity<>(truckService.getAllTrucks(PageRequest.of(page,size),status), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<TruckDto> updateTruck(@Valid @RequestBody UpdateTruckDto updateTruckDto, @PathVariable("id") Long id) throws TruckNotFoundException {
            return new ResponseEntity<>(truckService.updateTruck(id,updateTruckDto), HttpStatus.OK);
    }



}
