package com.royce.blood_donation.models.appointment;

import com.royce.blood_donation.models.BaseEntity;
import com.royce.blood_donation.models.blood.BloodComponents;
import com.royce.blood_donation.models.blood.BloodType;
import com.royce.blood_donation.models.enums.Gender;
import com.royce.blood_donation.models.enums.Status;
import com.royce.blood_donation.models.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "Appointments")
public class Appointment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @ManyToOne
    @JoinColumn(name = "blood_component_id", referencedColumnName = "component_id")
    private BloodComponents BloodComponent;

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

    @Column(name = "notes")
    private String notes;

    @Column(name = "accept_general_term")
    private boolean acceptGeneralTerm;

    @Column(name = "accept_contact_term")
    private boolean acceptContactTerm;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

}
