package com.pigtail.searchService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "IMAGE")

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Image {
    @Id
    @SequenceGenerator(name = "IMG_SEQ",sequenceName = "IMG_SEQ",allocationSize = 1)
    @GeneratedValue(generator = "IMG_SEQ",strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "URL")
    private String url;
}
