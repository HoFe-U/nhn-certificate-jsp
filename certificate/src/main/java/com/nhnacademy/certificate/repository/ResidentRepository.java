package com.nhnacademy.certificate.repository;

import com.nhnacademy.certificate.dto.ResidentDTO;
import com.nhnacademy.certificate.entity.Resident;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ResidentRepository extends JpaRepository<Resident, Integer> {

    @Query("select r from Resident r where r.name = ?1 and r.registrationNo =?2")
    Optional<Resident> checkResidentExist(String name , String registrationNo);
//    Page<Resident> getAllBy(Pageable pageable);

}
