package com.nhnacademy.certificate.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Data
@Table(name = "resident")
public class Resident {

    @Id
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