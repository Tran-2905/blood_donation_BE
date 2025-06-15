package com.royce.blood_donation.Model;

import com.royce.blood_donation.Converter.BloodComponentConverter;
import com.royce.blood_donation.Model.enums.BloodComponent;
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
