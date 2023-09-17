package com.pigtail.forumService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "TAG")

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tag {
    @Id
    @SequenceGenerator(
            name = "TAG_SEQ",
            sequenceName = "TAG_SEQ",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "TAG_SEQ",
            strategy = GenerationType.SEQUENCE
    )
    private Long id;
    @Getter
    @Column(
            name = "TAG_NAME",
            nullable = false
    )
    private String name;
}
