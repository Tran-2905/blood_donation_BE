package com.royce.blood_donation.Model;

import com.royce.blood_donation.Model.enums.RhType;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "blood_types")
public class BloodType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blood_type_id")
    private int id;

    @Column(name = "type")
    private String type;

    @Enumerated(EnumType.STRING)
    @Column(name = "rh" )
    private RhType rh;

    @Column(name = "description")
    private String description;

}
