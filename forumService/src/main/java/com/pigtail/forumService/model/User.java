package com.pigtail.forumService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "MEMBER")
public class User {
    @Id
    @SequenceGenerator(
            name = "USER_SEQ",
            sequenceName = "USER_SEQ",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "USER_SEQ",
            strategy = GenerationType.SEQUENCE
    )
    private Long id;

    @Column(
            name = "NICK_NAME",
            nullable = false,
            unique = true
    )
    private String nickname;
    @Column(
            name = "AVATAR"
    )
    private String avatar;
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(
//            name = "CREATED_AT",
//            updatable = false,
//            nullable = false
//    )
//    private Date createdAt;
}
