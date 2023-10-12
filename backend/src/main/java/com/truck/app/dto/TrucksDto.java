package com.truck.app.dto;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TrucksDto {

    private Long totalItems;
    private List<TruckDto> items;
    private Integer currentPage;
    private Integer totalPages;
}
