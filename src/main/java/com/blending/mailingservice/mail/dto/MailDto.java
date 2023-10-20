package com.blending.mailingservice.mail.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MailDto {
    private String sender;
    private String receiver;
    private String title;
    private String content;
    private Boolean isImportant = false;
    private Boolean isSpam = false;
}
