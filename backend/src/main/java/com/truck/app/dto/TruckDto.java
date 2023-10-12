package com.truck.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString
public class TruckDto {

    private Long id;
    private Double latitude;
    private Double longitude;
    private String photoUrl;
    private String truckName;
    private String status;

}
