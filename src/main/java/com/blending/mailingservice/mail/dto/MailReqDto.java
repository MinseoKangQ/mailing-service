package com.blending.mailingservice.mail.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MailReqDto {
    private String userId;
    private Long mailId;
}
