package com.truck.app.service;

import com.truck.app.domain.model.Truck;
import com.truck.app.domain.model.TruckStatus;
import com.truck.app.domain.repository.TruckRepository;
import com.truck.app.dto.TruckDto;
import com.truck.app.dto.TrucksDto;
import com.truck.app.dto.UpdateTruckDto;
import com.truck.app.exception.TruckNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Optional;

public class TruckServiceImplTest {

    @InjectMocks
    private TruckServiceImpl truckService;

    @Mock
    private TruckRepository truckRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldReturnTruckDtoPageWhenGetAllTrucksIsCalled() {
        // Arrange
        Page<Truck> sampleTruckPage = createSampleTruckPage();
        when(truckRepository.findAll(any(Pageable.class))).thenReturn(sampleTruckPage);

        // Act
        Pageable pageable = Pageable.unpaged();
        TrucksDto trucksDto = truckService.getAllTrucks(pageable,"all");

        // Assert
        assertEquals(sampleTruckPage.getTotalElements(), trucksDto.getTotalItems());
        assertEquals(sampleTruckPage.getTotalPages(), trucksDto.getTotalPages());
        assertEquals(sampleTruckPage.getNumber(), trucksDto.getCurrentPage());
        assertEquals(sampleTruckPage.getContent().size(), trucksDto.getItems().size());
    }

    @Test
    public void shouldUpdateTruckAndReturnDto() {
        // Arrange
        Truck sampleTruck = createSampleTruck();
        UpdateTruckDto updateTruckDto = createUpdateTruckDto();
        when(truckRepository.findById(1L)).thenReturn(Optional.of(sampleTruck));
        when(truckRepository.save(any(Truck.class))).thenReturn(sampleTruck);

        // Act
        TruckDto updatedTruckDto = truckService.updateTruck(1L, updateTruckDto);

        // Assert
        assertEquals(updateTruckDto.getLatitude(), updatedTruckDto.getLatitude());
        assertEquals(updateTruckDto.getLongitude(), updatedTruckDto.getLongitude());
        assertEquals(updateTruckDto.getStatus(), updatedTruckDto.getStatus());
    }

    @Test
    public void shouldThrowTruckNotFoundExceptionWhenTruckIsNotFound() {
        // Arrange
        when(truckRepository.findById(1L)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(TruckNotFoundException.class, () -> truckService.updateTruck(1L, createUpdateTruckDto()));
    }

    // Helper methods for creating sample data
    private Page<Truck> createSampleTruckPage() {
        return new PageImpl<>(Arrays.asList(createSampleTruck(), createSampleTruck()));
    }

    private Truck createSampleTruck() {
        Truck truck = new Truck();
        truck.setId(1L);
        truck.setLatitude(40.0);
        truck.setLongitude(50.0);
        truck.setTruckStatus(TruckStatus.HEALTHY);
        return truck;
    }

    private UpdateTruckDto createUpdateTruckDto() {
        UpdateTruckDto updateTruckDto = new UpdateTruckDto();
        updateTruckDto.setLatitude(50.0);
        updateTruckDto.setLongitude(60.0);
        updateTruckDto.setStatus("HEALTHY");
        return updateTruckDto;
    }
}

