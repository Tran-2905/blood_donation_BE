package com.royce.blood_donation.repositories;

import com.royce.blood_donation.models.ChatMessage;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface IChatMessageRepository extends JpaRepository <ChatMessage, Long>{
    List<ChatMessage> findByRoomOrderByTimestampDesc(String room, PageRequest pageable);
}
