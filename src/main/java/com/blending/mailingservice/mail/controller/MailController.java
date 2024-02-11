package com.blending.mailingservice.mail.controller;

import com.blending.mailingservice.mail.dto.CreateMailDto;
import com.blending.mailingservice.mail.dto.MailsDto;
import com.blending.mailingservice.mail.dto.ReadOneMailRes;
import com.blending.mailingservice.mail.service.MailServiceImpl;
import java.util.Collection;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("mailing-service/api/mail")
@RequiredArgsConstructor
public class MailController {

    private final MailServiceImpl mailServiceImpl;

    @PostMapping("send")
    public ResponseEntity<?> sendMail(@Valid @RequestBody CreateMailDto CreateMailDto) {
        String result = mailServiceImpl.sendMail(CreateMailDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/{userId}/{mailId}")
    public ResponseEntity<?> readMail(@PathVariable("userId") String userId, @PathVariable("mailId") Long mailId) {
        ReadOneMailRes result = mailServiceImpl.readMail(userId, mailId);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/readMyMail/{userId}}")
    public ResponseEntity<?> readMyMail(@PathVariable("userId") String userId) {
        Collection<MailsDto> result = mailServiceImpl.readMyMail(userId);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/received/{userId}")
    public ResponseEntity<?> readReceivedMail(@PathVariable("userId") String userId) {
        Collection<MailsDto> result = mailServiceImpl.readReceivedMail(userId);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/send/{userId}")
    public ResponseEntity<?> readSendMail(@PathVariable("userId") String userId) {
        Collection<MailsDto> result = mailServiceImpl.readSendMail(userId);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PutMapping("/{userId}/{mailId}")
    public ResponseEntity<?> updateMailToRead(@PathVariable("userId") String userId, @PathVariable("mailId") Long mailId) {
        String result = mailServiceImpl.updateMailToRead(userId, mailId);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping("{mailId}")
    public ResponseEntity<?> deleteMail(@PathVariable("mailId") Long mailId){
        Boolean result = mailServiceImpl.deleteMail(mailId);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}