package com.chatbot.supportbot.repository;

import com.chatbot.supportbot.model.ChatHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatHistoryRepository extends JpaRepository<ChatHistory, Long> {}
