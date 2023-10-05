package com.pigtail.messageService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MESSAGE")

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Message {
    @Id
    @SequenceGenerator(name = "MESS_SEQ",sequenceName = "MESS_SEQ")
    @GeneratedValue(generator = "MESS_SEQ",strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    private Conversation conversation;
    @Column(name = "CONTENT")
    private String content;
}
