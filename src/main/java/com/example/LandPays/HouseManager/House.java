package com.example.LandPays.HouseManager;

import com.example.LandPays.AppUser.AppUser;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter

@EqualsAndHashCode
public class House {
    @Id
    @SequenceGenerator( name = "house_sequence",
            sequenceName = "house_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "house_sequence"
    )
    private Long id;
    private Long house_number;
    private Long fee;
    private String tenant;
    private boolean status;

    public void setId(Long id) {
        this.id = id;
    }

    public void setHouse_number(Long house_number) {
        this.house_number = house_number;
    }

    public void setFee(Long fee) {
        this.fee = fee;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }



}
