package com.nhnacademy.certificate.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "certificate_issue")
public class CertificateIssue {
    @Id
    @Column(name = "certificate_confirmation_number")
    private Long certificationNo;

    @ManyToOne
    @JoinColumn(name = "resident_serial_number")
    public Resident resident;

    @Column(name = "certificate_type_code")
    private String certificateTypeCode;

    @Column(name = "certificate_issue_date")
    private LocalDateTime certificateIssueDate;

}
