package com.royce.blood_donation.services;

import com.royce.blood_donation.models.ChatMessage;

import java.util.List;

public interface IChatService {
    public ChatMessage processAndBroadcast(ChatMessage msg);
    public List<ChatMessage> lastMessages(String room, int limit);
}
