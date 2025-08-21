package com.royce.blood_donation.controllers;

import com.royce.blood_donation.models.ChatMessage;
import com.royce.blood_donation.services.ChatService;
import com.royce.blood_donation.services.IChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequiredArgsConstructor
public class ChatController {
    private final IChatService chatService;

    @MessageMapping("/chat.send")
    public void onSend(@Payload ChatMessage msg) {
        chatService.processAndBroadcast(msg);
    }
}
