package com.nhnacademy.certificate.service.impl;

import com.nhnacademy.certificate.domain.HouseHoldMovementAddressRequest;
import com.nhnacademy.certificate.domain.ModifyMovementAddress;
import com.nhnacademy.certificate.entity.Household;
import com.nhnacademy.certificate.entity.HouseholdMovementAddress;
import com.nhnacademy.certificate.entity.pk.HouseHoldMovementAddressPk;
import com.nhnacademy.certificate.exception.NoMovementAddressException;
import com.nhnacademy.certificate.repository.HouseholdMovementAddressRepository;
import com.nhnacademy.certificate.service.HouseholdMovementAddressService;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public class HouseHoldMovementServiceImpl implements HouseholdMovementAddressService {
    private final HouseholdMovementAddressRepository movementAddressRepository;

    public HouseHoldMovementServiceImpl(
        HouseholdMovementAddressRepository movementAddressRepository) {
        this.movementAddressRepository = movementAddressRepository;
    }

    @Override
    public HouseholdMovementAddress createAddress(Household household,
                                                  HouseHoldMovementAddressRequest movementAddressRequest) {
        HouseholdMovementAddress address = new HouseholdMovementAddress();
        HouseHoldMovementAddressPk pk = new HouseHoldMovementAddressPk();

        pk.setHouseHoldNo(household.getHouseholdSerialNumber());
        pk.setHouseMovementReportDate(movementAddressRequest.getReportDate());

        movementAddressRepository.findByLastAddress("Y").setLastAddress("N");
        address.setLastAddress("Y");
        address.setHousehold(household);
        address.setHoldMovementAddress(pk);
        address.setHouseMovementAddress(movementAddressRequest.getMovementAddress());
        return movementAddressRepository.save(address);
    }

    @Override
    public HouseholdMovementAddress modifyHouseholdMovementAddress(Household household,
                                                                   LocalDateTime dateTime,
                                                                   ModifyMovementAddress modifyMovementAddress) {
        HouseHoldMovementAddressPk pk = new HouseHoldMovementAddressPk();
        pk.setHouseHoldNo(household.getHouseholdSerialNumber());
        pk.setHouseMovementReportDate(dateTime);

        HouseholdMovementAddress address =
            movementAddressRepository.findById(pk).orElseThrow(NoMovementAddressException::new);

        address.setHouseMovementAddress(modifyMovementAddress.getAddress());
        return movementAddressRepository.save(address);
    }

    @Override
    public void deleteMovementAddress(Household household,
                                                          LocalDateTime dateTime) {
        HouseHoldMovementAddressPk pk = new HouseHoldMovementAddressPk();
        pk.setHouseHoldNo(household.getHouseholdSerialNumber());
        pk.setHouseMovementReportDate(dateTime);
        HouseholdMovementAddress address =
            movementAddressRepository.findById(pk).orElseThrow(NoMovementAddressException::new);
        movementAddressRepository.delete(address);
    }
}
