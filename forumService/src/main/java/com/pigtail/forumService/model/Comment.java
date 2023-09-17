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
@Table
public class Comment {
    @Id
    @SequenceGenerator(
            name = "COMMENT_SEQ",
            sequenceName = "COMMENT_SEQ",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "COMMENT_SEQ"
    )
    private Long id;
    @Column(
            name = "COMMENT_CONTENT",
            columnDefinition = "TEXT"
    )
    @Lob
    private String content;
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(
            name = "DISCUSSION_ID",
            referencedColumnName = "ID"
    )
    private Discussion discussion;
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(
            name = "COMMENT_OWNER_ID",
            referencedColumnName = "ID"
    )
    private User owner;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(
            name = "CREATED_AT",
            updatable = false,
            nullable = false
    )
    private Date createdAt;
}
