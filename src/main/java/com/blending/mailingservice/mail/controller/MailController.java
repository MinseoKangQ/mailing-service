package com.blending.mailingservice.mail.controller;

import com.blending.mailingservice.mail.dto.MailDto;
import com.blending.mailingservice.mail.entity.Mail;
import com.blending.mailingservice.mail.service.MailServiceImpl;
import java.util.Collection;
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
    public ResponseEntity<?> sendMail(@RequestBody MailDto mailDto) {
        Mail result = mailServiceImpl.sendMail(mailDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/{userId}/{mailId}")
    public ResponseEntity<?> readMail(@PathVariable("userId") String userId, @PathVariable("mailId") Long mailId) {
        Mail result = mailServiceImpl.readMail(userId, mailId);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping
    public ResponseEntity<?> readMailAll(@PathVariable("userId") String userId) {
        Collection result = mailServiceImpl.readMailAll(userId);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PutMapping("/{userId}/{mailId}")
    public String updateMailToRead(@PathVariable("userId") String userId, @PathVariable("mailId") Long mailId) {
        return null;
    }

    @DeleteMapping("{mailId}")
    public ResponseEntity<?> deleteMail(@PathVariable("mailId") Long mailId){
        return null;
    }

}