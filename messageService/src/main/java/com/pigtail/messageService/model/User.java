package com.pigtail.messageService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "MEMBER")

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    private Long id;
    @Column
    private String avatar;
    @ManyToMany
    @JoinTable(
            name = "CONTACT",
            joinColumns = @JoinColumn(name = "USER_ID",referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "CONVERSATION_ID",referencedColumnName = "ID")
    )
    private List<Conversation> conversations;
}
