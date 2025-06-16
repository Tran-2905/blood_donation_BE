package com.royce.blood_donation.models;

import com.royce.blood_donation.converter.BloodComponentConverter;
import com.royce.blood_donation.models.enums.BloodComponent;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "blood_components")
public class BloodComponents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "component_id")
    private int id;

    @Convert(converter = BloodComponentConverter.class)
    @Column(name = "component_name")
    private BloodComponent componentName;


    private String description;
}
