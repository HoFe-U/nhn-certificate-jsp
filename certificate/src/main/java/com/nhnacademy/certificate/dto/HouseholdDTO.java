package com.nhnacademy.certificate.dto;

import com.nhnacademy.certificate.entity.Household;
import com.nhnacademy.certificate.entity.HouseholdMovementAddress;
import java.time.LocalDate;
import java.util.List;
import lombok.Data;

@Data
public class HouseholdDTO {
    private String name;
    private LocalDate familyCompositionDate;
    private String familyCompositionReason;
    private List<HouseMovementDTO> addressList;

    public HouseholdDTO(Household household,List<HouseMovementDTO> list) {
        this.name = household.getResident().getName();
        this.familyCompositionDate = household.getCompositionDate();
        this.familyCompositionReason = household.getCompositionCode();
        this.addressList = list;
    }
}
