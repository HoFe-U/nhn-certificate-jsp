package com.nhnacademy.certificate.service;

import com.nhnacademy.certificate.domain.HouseholdCompositionDelete;
import com.nhnacademy.certificate.domain.HouseholdCompositionRequest;
import com.nhnacademy.certificate.entity.Household;
import com.nhnacademy.certificate.entity.HouseholdCompositionResident;
import javax.validation.Valid;

public interface HouseholdCompositionResidentService {
    HouseholdCompositionResident createCompositionResident(Household household,
                                                           HouseholdCompositionRequest request);
    void deleteCompositionResident(Household household,
                                   @Valid HouseholdCompositionDelete delete);
}
