package com.royce.blood_donation.models.donation;

import com.royce.blood_donation.models.BaseEntity;
import com.royce.blood_donation.models.blood.BloodComponents;
import com.royce.blood_donation.models.blood.BloodType;
import com.royce.blood_donation.models.enums.*;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "donations")
public class Donation extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blood_type_id")
    private int donationId;
    @Column(name = "donor_user_id")
    private String donorUserId;
    @Column(name = "receiver_user_id")
    private String recipientUserId;
    @Enumerated(EnumType.STRING)
    @Column(name = "request_type")
    private RequestType requestType;
    @Column(name = "request_id")
    private int requestId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "blood_type_id", insertable = false, updatable = false)
    private BloodType bloodTypeId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "request_id", insertable = false, updatable = false)
    private BloodComponents componentId;

    @Column(name = "units_donated")
    private Integer unitsDonated;

    @Temporal(TemporalType.DATE)
    @Column(name = "donation_date")
    private Date donationDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusDonation status; // Enum: SCHEDULED, COMPLETED, CANCELLED

    @Enumerated(EnumType.STRING)
    @Column(name = "progress")
    private Progress progress; // Enum: RECEIVED, PROCESSING, ACCEPTED

    @Column(name = "notes")
    private String notes;
}
