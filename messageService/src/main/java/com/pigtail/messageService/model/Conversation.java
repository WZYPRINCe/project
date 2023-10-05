package com.pigtail.messageService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "CONVERSATION")

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Conversation {
    @Id
    @SequenceGenerator(name = "CONV_SEQ",sequenceName = "CONV_SEQ",allocationSize = 1)
    @GeneratedValue(generator = "CONV_SEQ",strategy = GenerationType.SEQUENCE)
    private Long id;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(
            name = "CONV_ID",
            referencedColumnName = "ID"
    )
    private List<Message> messages;
    @ManyToMany(mappedBy = "conversations")
    private List<User> users;
}
