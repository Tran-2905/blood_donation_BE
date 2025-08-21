package com.royce.blood_donation.services;

import com.royce.blood_donation.models.ChatMessage;
import com.royce.blood_donation.repositories.IChatMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatService implements IChatService {
    private final IChatMessageRepository repo;
    private final SimpMessagingTemplate messagingTemplate;

    @Override
    public ChatMessage processAndBroadcast(ChatMessage msg) {
        if (msg.getRoom() == null || msg.getRoom().isBlank()) msg.setRoom("public");
        msg.setTimestamp(Instant.now());
        ChatMessage saved = repo.save(msg);
        String destination = "/topic/rooms/" + saved.getRoom();
        messagingTemplate.convertAndSend(destination, saved);


// Bot demo: nếu người dùng gõ "/bot ...", bot sẽ phản hồi đơn giản
        if (saved.getType().equals("CHAT") && saved.getContent() != null && saved.getContent().startsWith("/bot")) {
            ChatMessage bot = new ChatMessage();
            bot.setType("BOT");
            bot.setSender("TutorBot");
            bot.setRoom(saved.getRoom());
            bot.setTimestamp(Instant.now());
            bot.setContent("Bạn vừa gọi bot với: " + saved.getContent().substring(4).trim());
            ChatMessage savedBot = repo.save(bot);
            messagingTemplate.convertAndSend(destination, savedBot);
        }
        return saved;
    }

    @Override
    public List<ChatMessage> lastMessages(String room, int limit) {
        return repo.findByRoomOrderByTimestampDesc(room, PageRequest.of(0, limit));
    }
}
