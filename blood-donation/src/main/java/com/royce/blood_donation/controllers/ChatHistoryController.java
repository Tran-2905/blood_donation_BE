package com.royce.blood_donation.controllers;

import com.royce.blood_donation.models.ChatMessage;
import com.royce.blood_donation.services.ChatService;
import com.royce.blood_donation.services.IChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
@CrossOrigin(origins = {"http://localhost:4200"})
@RequiredArgsConstructor
public class ChatHistoryController {
    private final IChatService chatService;

    @GetMapping
    public List<ChatMessage> last(@RequestParam(defaultValue = "public") String room,
                                  @RequestParam(defaultValue = "50") int limit) {
        return chatService.lastMessages(room, Math.min(Math.max(limit, 1), 200));
    }
}
