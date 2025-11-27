package com.chatbot.supportbot.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ChatHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chatId;

    @Column(length = 1000)
    private String userMessage;
    @Column(length = 1000)
    private String botResponse;

    private LocalDateTime timestamp = LocalDateTime.now();

    public Long getChatId() { return chatId; }
    public void setChatId(Long chatId) { this.chatId = chatId; }
    public String getUserMessage() { return userMessage; }
    public void setUserMessage(String userMessage) { this.userMessage = userMessage; }
    public String getBotResponse() { return botResponse; }
    public void setBotResponse(String botResponse) { this.botResponse = botResponse; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}
