package com.nhnacademy.certificate.repository;

import com.nhnacademy.certificate.entity.Resident;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ResidentRepository extends JpaRepository<Resident, Integer> {

    @Query("select r from Resident r where r.name = ?1 and r.registrationNo =?2")
    Optional<Resident> checkResidentExist(String name , String registrationNo);

    @Query("update Resident as r set r.name =?1,r.registrationNo=?2,r.genderCode=?3,r.registrationAddress=?4 where r.registrationNo = ?5")
    void updateResident(String name, String registrationNo, String gender , String address, String registrationNocheck);
}
