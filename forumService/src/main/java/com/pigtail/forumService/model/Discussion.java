package com.pigtail.forumService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Type;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table
public class Discussion {
    @Id
    @SequenceGenerator(
            name = "DIS_SEQ",
            sequenceName = "DIS_SEQ",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "DIS_SEQ",
            strategy = GenerationType.SEQUENCE
    )
    private Long id;
    @Column(
            name = "DISCUSSION_TITLE",
            nullable = false
    )
    private String title;
    @Lob
    @Column(
            name = "DISCUSSION_CONTENT",
            columnDefinition = "TEXT"
    )
    private String content;
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(
            name = "DISCUSSION_OWNER_ID",
            referencedColumnName = "ID",
            nullable = false
    )
    private User owner;
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(
            name = "FORUM_ID",
            referencedColumnName = "ID",
            nullable = false
    )
    private Forum forum;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(
            name = "CREATED_AT",
            updatable = false,
            nullable = false
    )
    private Date createdAt;
}
