package com.ssg.w2.dto;

import lombok.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
    private String id;
    private String password;
    private String name;
    private String email;
    //    private Date regDate;
    private LocalDate regDate;

}