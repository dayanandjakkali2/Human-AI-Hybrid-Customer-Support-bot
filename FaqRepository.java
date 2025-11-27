package com.chatbot.supportbot.repository;

import com.chatbot.supportbot.model.Faq;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface FaqRepository extends JpaRepository<Faq, Long> {
    Optional<Faq> findByQuestionIgnoreCase(String question);
}
