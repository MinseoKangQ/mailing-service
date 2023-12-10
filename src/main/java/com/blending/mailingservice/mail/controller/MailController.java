package com.blending.mailingservice.mail.controller;

import com.blending.mailingservice.mail.dto.CreateMailDto;
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

    @GetMapping
    public ResponseEntity<?> readMailAll(@PathVariable("userId") String userId) {
        Collection result = mailServiceImpl.readMailAll(userId);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PutMapping("/{userId}/{mailId}")
    public ResponseEntity<?> updateMailToRead(@PathVariable("userId") String userId, @PathVariable("mailId") Long mailId) {
        String result = mailServiceImpl.updateMailToRead(userId, mailId);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping("{mailId}")
    public ResponseEntity<?> deleteMail(@PathVariable("mailId") Long mailId){
        return null;
    }

}