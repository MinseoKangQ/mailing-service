package com.blending.mailingservice.mail.service;

import com.blending.mailingservice.mail.dto.MailDto;
import com.blending.mailingservice.mail.entity.Mail;
import com.blending.mailingservice.mail.repository.MailRepository;
import com.blending.mailingservice.user.entity.User;
import com.blending.mailingservice.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {

    private final MailRepository mailRepository;
    private final UserRepository userRepository;

    // 메일 저장 (메일이 전송될 때 불려진다)
    public String sendMail(MailDto mailDto) {
        Mail mail = convertToEntity(mailDto);

        // 메일 저장 로직 -> mailRepository 의 save 이용
        mailRepository.save(mail);

        return "success";
    }

    // 한 유저의 메일함 전체보기
    public String readMailAll(String userId) {
        // 유저의 메일함 보는 로직 -> mailRepository 의 findAll 이용
        return null;
    }

    // 메일 하나 보기
    public String readMail(String userId, Long mailId) {
        // 메일 하나 보는 로직 -> mailRepository 의 find 이용
        // 유저가 있는지 검증
        // mailId 가 존재하는지 검증
        return null;
    }

    // receiver 가 메일 읽으면 업데이트
    public String updateMailToRead(String receiverId, Long mailId) {
        // mailId 가 존재하는지 검증
        // mailId로 메일 찾아서 업데이트
        // 업데이트 사항 : isRead, readAt 필드
        return null;
    }

    // 메일 삭제하기
    public String deleteMail(Long mailId){
        // mailId 가 존재하는지 검증
        // mailId 로 메일 삭제
        return null;
    }

    // MailDto 를 Mail 엔티티로 변환하는 메소드
    private Mail convertToEntity(MailDto mailDto) {

        // 발신인 검증
        User sender = userRepository.findById(mailDto.getSender())
                .orElseThrow(() -> new RuntimeException("발신인을 찾을 수 없습니다."));

        // 수신인 검증
        User receiver = userRepository.findById(mailDto.getReceiver())
                .orElseThrow(() -> new RuntimeException("수신인을 찾을 수 없습니다."));

        return Mail.builder()
                .sender(sender)
                .receiver(receiver)
                .title(mailDto.getTitle())
                .content(mailDto.getContent())
                .isImportant(mailDto.getIsImportant())
                .isSpam(mailDto.getIsSpam())
                .build();
    }

}
