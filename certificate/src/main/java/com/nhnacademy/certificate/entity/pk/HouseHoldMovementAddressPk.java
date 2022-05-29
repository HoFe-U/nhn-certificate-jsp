package com.nhnacademy.certificate.entity.pk;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class HouseHoldMovementAddressPk implements Serializable {
    private Integer houseHoldNo;

    @Column(name = "house_movement_report_date")
    private LocalDateTime houseMovementReportDate;
}
