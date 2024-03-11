package com.ssg.w2.domain;


import lombok.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {
    private String id;
    private String password;
    private String name;
    private String email;
    //    private Date regDate;
    private LocalDate regDate;

}
