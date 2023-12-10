package com.blending.mailingservice.mail.service;

import com.blending.mailingservice.mail.dto.CreateMailDto;
import com.blending.mailingservice.mail.dto.MailsDto;
import com.blending.mailingservice.mail.dto.ReadOneMailRes;
import com.blending.mailingservice.mail.entity.Mail;
import com.blending.mailingservice.mail.repository.MailRepository;
import com.blending.mailingservice.user.entity.User;
import com.blending.mailingservice.user.repository.UserRepository;
import com.blending.mailingservice.util.exception.CustomException;
import com.blending.mailingservice.util.exception.ErrorCode;
import java.time.LocalDateTime;
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
    public String sendMail(CreateMailDto CreateMailDto) {

        // 발신인 검증
        User sender = userRepository.findById(CreateMailDto.getSender())
                .orElseThrow(() -> new RuntimeException("발신인을 찾을 수 없습니다."));

        // 수신인 검증
        User receiver = userRepository.findById(CreateMailDto.getReceiver())
                .orElseThrow(() -> new RuntimeException("수신인을 찾을 수 없습니다."));

        // 제목, 내용 검증은 Entity 에서 @NotNull 로 수행함

        Mail mail = convertToEntity(CreateMailDto, sender, receiver);
        mailRepository.save(mail);
        return "메일이 정상적으로 발송되었습니다.";
    }

    @Override
    public ReadOneMailRes readMail(String userId, Long mailId) {

        // 메일 하나 읽기
        Optional<User> existingUser = userRepository.findById(userId);
        if(!existingUser.isPresent()) {
            throw new CustomException(ErrorCode.USER_NOT_FOUND);
        }

        Optional<Mail> existingMail = mailRepository.findById(mailId);
        if(!existingMail.isPresent()) {
            throw new CustomException(ErrorCode.MAIL_NOT_FOUND);
        }

        Mail gotMail = existingMail.get();
        ReadOneMailRes result = ReadOneMailRes.builder()
                .id(mailId)
                .sender(gotMail.getSender().getId())
                .receiver(gotMail.getReceiver().getId())
                .title(gotMail.getTitle())
                .content(gotMail.getContent())
                .sentAt(gotMail.getSentAt())
                .readAt(gotMail.getReadAt())
                .isSpam(gotMail.getIsSpam())
                .isRead(gotMail.getIsRead())
                .isImportant(gotMail.getIsImportant())
                .build();

        return result;
    }

    @Override
    public Collection<MailsDto> readMailAll(String userId) {
        // 유저의 메일함 보는 로직 -> mailRepository 의 findAll 이용
        return null;
    }


    @Override
    public String updateMailToRead(String userId, Long mailId) {
        // mailId 가 존재하는지 검증
        Optional<Mail> existingMail = mailRepository.findById(mailId);
        if(existingMail.isEmpty()) {
            throw new CustomException(ErrorCode.MAIL_NOT_FOUND);
        }
        Mail gotMail = existingMail.get();

        // 메일의 수신인이 userId 인지 검증
        if (!gotMail.getReceiver().getId().equals(userId)) {
            throw new CustomException(ErrorCode.USER_MAIL_MISMATCH);
        }

        String resultMessage;
        // mailId로 메일 찾아서 업데이트
        // 업데이트 사항 : isRead, readAt 필드

        if(gotMail.getIsRead() == false) { // 읽지 않은 상태에서만 업데이트
            gotMail.setIsRead(true);
            gotMail.setReadAt(LocalDateTime.now());
            mailRepository.save(gotMail);
            resultMessage = "메일을 읽었습니다.";
        }
        else {
            resultMessage = "이미 메일을 읽은 상태입니다.";
        }

        return resultMessage;
    }

    @Override
    public Boolean deleteMail(Long mailId){
        // mailId 가 존재하는지 검증
        // mailId 로 메일 삭제
        return null;
    }

    // MailDto 를 Mail 엔티티로 변환하는 메소드
    private Mail convertToEntity(CreateMailDto CreateMailDto, User sender, User receiver) {
        return Mail.builder()
                .sender(sender)
                .receiver(receiver)
                .title(CreateMailDto.getTitle())
                .content(CreateMailDto.getContent())
                .isImportant(CreateMailDto.getIsImportant())
                .isSpam(CreateMailDto.getIsSpam())
                .build();
    }

}
