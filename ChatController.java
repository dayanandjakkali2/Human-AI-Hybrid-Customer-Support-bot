package com.chatbot.supportbot.controller;

import com.chatbot.supportbot.service.ChatService;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/chat")
    public Map<String, String> chat(@RequestBody Map<String, String> payload) {
        String userMsg = payload.get("message");
        String reply = chatService.getResponse(userMsg);
        return Map.of("reply", reply);
    }
}
