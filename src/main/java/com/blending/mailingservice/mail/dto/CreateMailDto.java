package com.blending.mailingservice.mail.dto;

import javax.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateMailDto {
    @NotEmpty(message = "발송인은 비어있을 수 없습니다.")
    private String sender;
    @NotEmpty(message = "수신인은 비어있을 수 없습니다.")
    private String receiver;
    @NotEmpty(message = "메일 제목은 비어있을 수 없습니다.")
    private String title;
    @NotEmpty(message = "메일 내용은 비어있을 수 없습니다.")
    private String content;
    private Boolean isImportant;
    private Boolean isSpam;
}
