package com.blending.mailingservice.mail.repository;

import com.blending.mailingservice.mail.entity.Mail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MailRepository extends JpaRepository<Mail, Long> {
    List<Mail> findByReceiverId(String receiverId);
    List<Mail> findBySenderId(String senderId);
    List<Mail> findByReceiverIdAndSenderId(String userId1, String userId2);
}
