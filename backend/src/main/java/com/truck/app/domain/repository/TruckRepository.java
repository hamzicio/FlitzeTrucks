package com.truck.app.domain.repository;

import com.truck.app.domain.model.Truck;
import com.truck.app.domain.model.TruckStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TruckRepository extends JpaRepository<Truck, Long> {
    Page<Truck> findAllByTruckStatus(Pageable pageable , TruckStatus status);

}
