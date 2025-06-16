package com.royce.blood_donation.models;

import com.royce.blood_donation.models.enums.RhType;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "blood_capacity")
public class BloodCapacity {
    @EmbeddedId
    private BloodCapacityId id;
    @ManyToOne
    @JoinColumn(name = "donor_blood_type_id", referencedColumnName = "blood_type_id", insertable = false, updatable = false)
    private BloodType donorBloodTypeId;

    @ManyToOne
    @JoinColumn(name = "recipient_blood_type_id", referencedColumnName = "blood_type_id", insertable = false, updatable = false)
    private BloodType recipientBloodTypeId;


    @Enumerated(EnumType.STRING)
    private RhType rh;

    @Column(name = "recipient_rh")
    @Enumerated(EnumType.STRING)
    private RhType recipientRh;

    @ManyToOne
    @JoinColumn(name = "component_id", referencedColumnName = "component_id", insertable = false, updatable = false)
    private BloodComponents componentId;

    @Column(name = "can_donate")
    private boolean canDonate;

    @Column(name = "can_receive")
    private boolean canReceive;

}
