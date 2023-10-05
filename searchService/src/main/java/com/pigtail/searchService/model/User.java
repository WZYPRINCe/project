package com.pigtail.searchService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "MEMBER")

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @SequenceGenerator(name = "USER_SEQ",sequenceName = "USER_SEQ",allocationSize = 1)
    @GeneratedValue(generator = "USER_SEQ",strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "AVATAR")
    private String avatar;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(
            name = "BUYER_ID",
            referencedColumnName = "ID"
    )
    private List<Order> BuyerOrder;
}
