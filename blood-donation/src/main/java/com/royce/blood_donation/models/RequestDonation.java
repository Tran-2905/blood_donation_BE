package com.royce.blood_donation.models;

import com.royce.blood_donation.models.enums.Gender;
import com.royce.blood_donation.models.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.util.Date;

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "donation_registrations")
public class RequestDonation extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registration_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "blood_type_id")
    private BloodType bloodTypeId;

    private float weight;

    private float height;

    @Column(name = "last_donation")
    private Date lastDonation;

    @Column(name = "available_date")
    private Date availableDate;

    @Column(name = "available_time")
    private String availableTime;

    private String notes;

    @Column(name = "accept_general_term")
    private boolean acceptGeneralTerm;

    @Column(name = "accept_contact_term")
    private boolean acceptContactTerm;

    @Enumerated(EnumType.STRING)
    private Status status;


}
