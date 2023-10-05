package com.pigtail.searchService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "LOCATION")

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Location {
    @Id
    @SequenceGenerator(name = "LOCATION_SEQ",sequenceName = "LOCATION_SEQ",allocationSize = 1)
    @GeneratedValue(generator = "LOCATION_SEQ",strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "ZIPCODE")
    private String zipcode;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "CITY")
    private String city;
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "STATE")
    private String state;
}
