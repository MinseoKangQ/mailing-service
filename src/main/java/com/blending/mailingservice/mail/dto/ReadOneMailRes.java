package com.blending.mailingservice.mail.dto;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ReadOneMailRes {
    private Long id;
    private String sender;
    private String receiver;
    private String title;
    private String content;
    private LocalDateTime sentAt;
    private LocalDateTime readAt;
    private Boolean isSpam;
    private Boolean isRead;
    private Boolean isImportant;
}
