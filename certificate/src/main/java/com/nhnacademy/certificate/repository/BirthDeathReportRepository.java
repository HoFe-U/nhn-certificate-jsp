package com.nhnacademy.certificate.repository;

import com.nhnacademy.certificate.dto.BirthInfoDTO;
import com.nhnacademy.certificate.dto.DeathInfoDTO;
import com.nhnacademy.certificate.dto.MotherFatherDTO;
import com.nhnacademy.certificate.entity.BirthDeathReport;
import com.nhnacademy.certificate.entity.pk.BirthDeathReportPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BirthDeathReportRepository extends JpaRepository<BirthDeathReport, BirthDeathReportPK> {

    boolean existsByBirthDeathReportPK_ResidentNoAndBirthDeathReportPK_BirthDeathCode(
        Integer residentNo, String birthDeathCode);

    void deleteBirthDeathReportByBirthDeathReportPK_ResidentNo(Integer residentNo);

    @Query("select b.resident.name as name," +
        "b.resident.registrationNo as registrationNo," +
        "b.birthDeathReportPK.birthDeathCode as code," +
        "b.birthDeathReportDate as reportDate," +
        "b.deathQualificationCode as deathCode," +
        "b.emailAddress as email," +
        "b.phoneNumber as phone," +
        "b.birthDeathReportPK.reportResidentNo as reportNo," +
        "r.deathDate as deathDate," +
        "r.deathPlaceAddress as placeAddress," +
        "r.deathPlaceCode as placeCode from BirthDeathReport as b inner join Resident  as r on b.birthDeathReportPK.residentNo = r.residentNo where b.birthDeathReportPK.birthDeathCode= ?1 and b.birthDeathReportPK.residentNo = ?2")
    DeathInfoDTO findDeathInfo(String code, Integer serialNo);

    @Query("select b.resident.name as name," +
        "b.resident.registrationNo as registrationNo," +
        "b.birthDeathReportPK.birthDeathCode as code," +
        "b.birthDeathReportDate as reportDate," +
        "b.birthQualificationCode as birthCode," +
        "b.emailAddress as email," +
        "b.phoneNumber as phone," +
        "b.birthDeathReportPK.reportResidentNo as reportNo," +
        "r.birthDate as birthDate," +
        "r.registrationAddress as registrationAddress," +
        "r.birthPlaceCode as birthPlace," +
        "b.resident.genderCode as gender " +
        "from BirthDeathReport as b inner join Resident  as r on b.birthDeathReportPK.residentNo = r.residentNo where b.birthDeathReportPK.birthDeathCode= ?1 and b.birthDeathReportPK.residentNo = ?2")
    BirthInfoDTO findBirtInfo(String code, Integer serialNo);

    @Query("select r.name as name," +
        "r.registrationNo as registrationNo" +
        " from FamilyRelationship as f inner join Resident as r on f.familyRelationShipPk.familyResidentNo = r.residentNo where f.familyRelationShipPk.baseResidentNo =?1 and f.familyRelationCode=?2")
    MotherFatherDTO findMotherOrFather(Integer serialNo ,String familyType);
}


