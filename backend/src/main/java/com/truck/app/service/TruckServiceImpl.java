package com.truck.app.service;

import com.truck.app.domain.model.Truck;
import com.truck.app.domain.model.TruckStatus;
import com.truck.app.domain.repository.TruckRepository;
import com.truck.app.dto.TruckDto;
import com.truck.app.dto.TrucksDto;
import com.truck.app.dto.UpdateTruckDto;
import com.truck.app.exception.TruckException;
import com.truck.app.exception.TruckNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class TruckServiceImpl implements TruckService {

    private TruckRepository truckRepository;

    @Autowired
    TruckServiceImpl(TruckRepository truckRepository){
        this.truckRepository = truckRepository;
    }

    @Override
    public TrucksDto getAllTrucks(Pageable pageable, String status) {

        if (!Arrays.stream(TruckStatus.values()).anyMatch((t) -> t.name().equals(status)) && !status.equals("all")) {
            throw new TruckException("Invalid status value");
        }

        Page<Truck> truckPage = new PageImpl<>(Collections.emptyList());

        if(status.equals("all"))  {
            truckPage = truckRepository.findAll(pageable);
        }

        else {
            truckPage = truckRepository.findAllByTruckStatus(pageable, TruckStatus.valueOf(status));
        }

        List<TruckDto> trucksDtos= truckPage.getContent().stream().map(t-> t.toTruckDto()).collect(Collectors.toList());
        TrucksDto trucksDto= new TrucksDto(truckPage.getTotalElements(),trucksDtos,truckPage.getNumber(),truckPage.getTotalPages());
        return trucksDto;
    }

    @Override
    public TruckDto updateTruck(Long id, UpdateTruckDto updateTruckDto) throws TruckNotFoundException {
        Truck truck= truckRepository.findById(id).orElseThrow(()
                -> new TruckNotFoundException("Truck not found"));
        truck.setLatitude(updateTruckDto.getLatitude());
        truck.setLongitude(updateTruckDto.getLongitude());
        truck.setTruckStatus(TruckStatus.valueOf(updateTruckDto.getStatus()));
        Truck savedTruck = truckRepository.save(truck);
        return savedTruck.toTruckDto();
    }
}
