package com.royce.blood_donation.models;

import jakarta.persistence.*;
import lombok.*;

import java.awt.*;
import java.time.Instant;

@Builder
@Entity
@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "chat_messages")
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    @Column(length = 2048)
    private String content;

    private String sender;
    private String room;
    private Instant timestamp;
    private String recipient;
}
