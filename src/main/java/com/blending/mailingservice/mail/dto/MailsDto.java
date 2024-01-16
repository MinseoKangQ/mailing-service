package com.blending.mailingservice.mail.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class MailsDto {
    private String sender;
    private String receiver;
    private String title;
    private String content;
    private LocalDateTime sentAt;
    private Boolean isImportant;
    private Boolean isRead;
    private Boolean isSpam;
}
