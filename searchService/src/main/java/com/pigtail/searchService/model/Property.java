package com.pigtail.searchService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Table(name = "PROPERTY")

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Property {
    @Id
    @SequenceGenerator(name = "PROPERTY_SEQ",sequenceName = "PROPERTY_SEQ")
    @GeneratedValue(generator = "PROPERTY_SEQ",strategy = GenerationType.SEQUENCE)
    private Long id;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(
            name = "PROP_ID",
            referencedColumnName = "ID"
    )
    private List<Order> orders;
    @Column(name = "RATE")
    private Double rate;
    @OneToOne
    @JoinColumn(
            name = "PROFILE_ID",
            referencedColumnName = "ID"
    )
    private Profile profile;

}
