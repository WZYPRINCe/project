package com.pigtail.forumService.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "TAG")

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tag {
    @Id
    private String name;
}
