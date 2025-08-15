package com.royce.blood_donation.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentResponse {
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private String status;
    private String time;
    private String type;
}
