package com.pigtail.forumService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "FORUM")
public class Forum {
    @Id
    @SequenceGenerator(
            name = "FORUM_SEQ",
            sequenceName = "FORUM_SEQ",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "FORUM_SEQ",
            strategy = GenerationType.SEQUENCE
    )
    private Long id;
    @Column(
            name = "FORUM_NAME",
            nullable = false,
            unique = true
    )
    private String name;
    @ManyToOne
    @JoinColumn(
            name = "FORUM_OWNER_ID",
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

    @ManyToMany
    @JoinTable(
            name = "FORUM_TAG",
            joinColumns = @JoinColumn(name = "FORUM_ID",referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "TAG_ID",referencedColumnName = "NAME")
    )
    private List<Tag> tags;

}
