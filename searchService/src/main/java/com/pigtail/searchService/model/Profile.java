package com.pigtail.searchService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Table(name = "PROFILE")

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Profile {
    @Id
    @SequenceGenerator(name = "PROFILE_SEQ",sequenceName = "PROFILE_SEQ",allocationSize = 1)
    @GeneratedValue(generator = "PROFILE_SEQ",strategy = GenerationType.SEQUENCE)
    private Long id;
    private int maxPeople;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "LOCATION_ID",
            referencedColumnName = "ID"
    )
    private Location location;
    private Double price;
    private RoomType type;
    @OneToMany
    @JoinColumn(
            name = "PROFILE_ID",
            referencedColumnName = "ID"
    )
    private List<Image> images;

}
