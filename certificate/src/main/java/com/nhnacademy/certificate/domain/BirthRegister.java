package com.nhnacademy.certificate.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BirthRegister {
    //TODO: 신고자 이름과 주민번호로 일련번호를 알아내야할것같다.
    @NotNull
    Integer residentSeralNo;

    @NotNull
    String reportType;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull
    LocalDate brithDate;

    @NotNull
    String qualificationCode;

    String email;

    String phone;
}
