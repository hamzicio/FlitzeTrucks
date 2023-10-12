package com.truck.app.service;

import com.truck.app.dto.TruckDto;
import com.truck.app.dto.UpdateTruckDto;
import com.truck.app.dto.TrucksDto;
import org.springframework.data.domain.Pageable;


public interface TruckService {

    TrucksDto getAllTrucks(Pageable pageable,String status);

    TruckDto updateTruck(Long id, UpdateTruckDto updateTruckDto);


}
