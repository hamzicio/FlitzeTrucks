package com.truck.app.dto;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.Accessors;


@Accessors(chain = true)
@NoArgsConstructor
@ToString
@Data
public class UpdateTruckDto {

    @NotNull(message = "latitude is required field")
    private Double latitude;
    @NotNull(message = "longitude is required field")
    private Double longitude;

    @Pattern(regexp = "HEALTHY|UNHEALTHY", message = "Invalid status , accepted values : HEALTHY, UNHEALTHY")
    @NotNull(message = "status is required field")
    private String status;

}
