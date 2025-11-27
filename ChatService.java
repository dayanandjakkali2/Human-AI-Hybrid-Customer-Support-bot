package com.chatbot.supportbot.service;

import com.chatbot.supportbot.model.ChatHistory;
import com.chatbot.supportbot.model.Faq;
import com.chatbot.supportbot.repository.ChatHistoryRepository;
import com.chatbot.supportbot.repository.FaqRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ChatService {
    private final FaqRepository faqRepo;
    private final ChatHistoryRepository chatRepo;

    public ChatService(FaqRepository faqRepo, ChatHistoryRepository chatRepo) {
        this.faqRepo = faqRepo;
        this.chatRepo = chatRepo;
    }

    public String getResponse(String userMessage) {
        Optional<Faq> faq = faqRepo.findByQuestionIgnoreCase(userMessage);
        String reply = faq.map(Faq::getAnswer)
                .orElse("Sorry, I didn’t understand that. Please contact support.");
        ChatHistory history = new ChatHistory();
        history.setUserMessage(userMessage);
        history.setBotResponse(reply);
        chatRepo.save(history);
        return reply;
    }
}
