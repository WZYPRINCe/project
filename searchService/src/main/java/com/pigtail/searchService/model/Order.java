package com.pigtail.searchService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "ORDERS")

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    @Id
    @SequenceGenerator(name = "ORDER_SEQ",sequenceName = "ORDER_SEQ")
    @GeneratedValue(generator = "ORDER_SEQ",strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "START_DATE")
    private Date startDate;
    @Column(name = "END_DATE")
    private Date endDate;
}
