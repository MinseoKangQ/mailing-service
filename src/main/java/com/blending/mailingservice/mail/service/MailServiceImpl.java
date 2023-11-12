package com.blending.mailingservice.mail.service;

import com.blending.mailingservice.mail.dto.MailDto;
import com.blending.mailingservice.mail.dto.MailReqDto;
import com.blending.mailingservice.mail.dto.MailsDto;
import com.blending.mailingservice.mail.dto.UpdateMailReqDto;
import com.blending.mailingservice.mail.entity.Mail;
import com.blending.mailingservice.mail.repository.MailRepository;
import com.blending.mailingservice.user.entity.User;
import com.blending.mailingservice.user.repository.UserRepository;
import com.blending.mailingservice.util.exception.CustomException;
import com.blending.mailingservice.util.exception.ErrorCode;
import java.util.Collection;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService{

    private final MailRepository mailRepository;
    private final UserRepository userRepository;

    @Override
    public Mail sendMail(MailDto mailDto) {

        // 발신인 검증
        User sender = userRepository.findById(mailDto.getSender())
                .orElseThrow(() -> new RuntimeException("발신인을 찾을 수 없습니다."));

        // 수신인 검증
        User receiver = userRepository.findById(mailDto.getReceiver())
                .orElseThrow(() -> new RuntimeException("수신인을 찾을 수 없습니다."));


        // 제목 검증

        // 내용 검증

        Mail mail = convertToEntity(mailDto, sender, receiver);
        mailRepository.save(mail);
        return mail;
    }

    @Override
    public Mail readMail(String userId, Long mailId) {
        // 메일 하나 보는 로직 -> mailRepository 의 find 이용

        Optional<User> existingUser = userRepository.findById(userId);
        if(!existingUser.isPresent()) {
            throw new CustomException(ErrorCode.USER_NOT_FOUND);
        }

        Optional<Mail> existingMail = mailRepository.findById(mailId);
        if(!existingMail.isPresent()) {
            throw new CustomException(ErrorCode.MAIL_NOT_FOUND);
        }

        return null;
    }

    @Override
    public Collection<MailsDto> readMailAll(String userId) {
        // 유저의 메일함 보는 로직 -> mailRepository 의 findAll 이용
        return null;
    }


    @Override
    public Boolean updateMailToRead(UpdateMailReqDto updateMailReqDto) {
        // mailId 가 존재하는지 검증
        // mailId로 메일 찾아서 업데이트
        // 업데이트 사항 : isRead, readAt 필드
        return null;
    }

    @Override
    public Boolean deleteMail(Long mailId){
        // mailId 가 존재하는지 검증
        // mailId 로 메일 삭제
        return null;
    }

    // MailDto 를 Mail 엔티티로 변환하는 메소드
    private Mail convertToEntity(MailDto mailDto, User sender, User receiver) {
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
