package com.truck.app.domain.model;


import com.truck.app.dto.TruckDto;
import javax.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;


@Setter
@Accessors(chain = true)
@NoArgsConstructor
@Entity
@Table(name = "truck")
public class Truck extends BaseObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TruckStatus truckStatus;

    @Column(name= "latitude")
    private Double latitude;

    @Column(name= "longitude")
    private Double longitude;

    @Column(name= "truckName")
    private String truckName;

    @Column(name= "photoUrl")
    private String photoUrl;

    public TruckDto toTruckDto(Truck this) {
        TruckDto truckDto= new TruckDto();
        truckDto.setId(this.id);
        truckDto.setTruckName(this.truckName);
        truckDto.setLatitude(this.latitude);
        truckDto.setStatus(this.truckStatus.name());
        truckDto.setLongitude(this.longitude);
        truckDto.setPhotoUrl(this.photoUrl);

        return truckDto;
    }

}


