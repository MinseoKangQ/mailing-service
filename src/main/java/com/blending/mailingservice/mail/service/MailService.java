package com.blending.mailingservice.mail.service;

import com.blending.mailingservice.mail.dto.CreateMailDto;
import com.blending.mailingservice.mail.dto.MailsDto;
import com.blending.mailingservice.mail.dto.ReadOneMailRes;
import java.util.Collection;

public interface MailService {
    String sendMail(CreateMailDto CreateMailDto);
    ReadOneMailRes readMail(String userId, Long mailId);
    Collection<MailsDto> readReceivedMail(String userId);
    Collection<MailsDto> readSendMail(String userId);
    Collection<MailsDto> readMyMail(String userId);
    String updateMailToRead(String userId, Long mailId);
    Boolean deleteMail(Long mailId);
}
