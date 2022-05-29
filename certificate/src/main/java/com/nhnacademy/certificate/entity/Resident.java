package com.nhnacademy.certificate.entity;

import java.time.LocalDateTime;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
@Table(name = "resident")
public class Resident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resident_serial_number")
    private Integer residentNo;

    private String name;

    @Column(name ="resident_registration_number" )
    private String registrationNo;

    private String genderCode;

    private LocalDateTime birthDate;

    private String birthPlaceCode;

    @Column(name = "registration_base_address")
    private String registrationAddress;

    private LocalDateTime deathDate;

    private String deathPlaceCode;

    private String deathPlaceAddress;
}