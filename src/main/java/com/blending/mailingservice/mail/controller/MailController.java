package com.blending.mailingservice.mail.controller;

import com.blending.mailingservice.mail.dto.MailDto;
import com.blending.mailingservice.mail.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mail")
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;

    // 메일 저장 (메일이 전송될 때 불려진다)
    @PostMapping("send")
    public String sendMail(@RequestBody MailDto mailDto) {
        return null;
    }

    // 한 유저의 메일함 전체보기
    @GetMapping
    public String readMailAll(@PathVariable("userId") String userId) {
        return null;
    }

    // 메일 하나 보기
    @GetMapping("/{userId}/{mailId}")
    public String readMail(@PathVariable("userId") String userId, @PathVariable("mailId") Long mailId) {
        return null;
    }

    // receiver 가 메일 읽으면 업데이트
    @PutMapping("/{userId}/{mailId}")
    public String updateMailToRead(@PathVariable("userId") String userId, @PathVariable("mailId") Long mailId) {
        return null;
    }

    // 메일 삭제하기
    @DeleteMapping("{mailId}")
    public String deleteMail(@PathVariable("mailId") Long mailId){
        return null;
    }

}