package com.nhnacademy.certificate.entity.pk;

import java.io.Serializable;
import javax.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class HouseholdCompositionResidentPK implements Serializable {
    private Integer householdNo;

    private Integer residentNo;
}
