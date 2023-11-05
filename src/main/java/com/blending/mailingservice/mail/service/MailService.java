package com.blending.mailingservice.mail.service;

import com.blending.mailingservice.mail.dto.MailDto;
import com.blending.mailingservice.mail.dto.MailsDto;
import com.blending.mailingservice.mail.dto.UpdateMailReqDto;
import com.blending.mailingservice.mail.entity.Mail;
import java.util.Collection;

public interface MailService {
    Mail sendMail(MailDto mailDto);
    Mail readMail(String userId, Long mailId);
    Collection<MailsDto> readMailAll(String userId);
    Boolean updateMailToRead(UpdateMailReqDto updateMailReqDto);
    Boolean deleteMail(Long mailId);
}
