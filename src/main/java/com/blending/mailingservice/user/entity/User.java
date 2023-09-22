package com.blending.mailingservice.user.entity;

import com.blending.mailingservice.mail.entity.Mail;
import com.blending.mailingservice.spam.entity.Spam;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USER")
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id @Column(name = "user_id")
    private String id; // 유저 아이디

    @Column(name = "user_name")
    private String name; // 유저 이름

    @Column(name = "user_pw")
    private String password; // 유저 비밀번호

    @CreatedDate
    @Column(name = "user_registered_at", nullable = false, updatable = false)
    private LocalDateTime registeredAt; // 유저 생성 시간

    @LastModifiedDate
    @Column(name="user_modified_at", nullable = false)
    private LocalDateTime modifiedAt; // 유저 정보 변경 시간

    @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL)
    private List<Mail> receivedMails = new ArrayList<>(); // 유저가 받은 메일들

    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL)
    private List<Mail> sentMails = new ArrayList<>(); // 유저가 보낸 메일들

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Spam> spamList = new ArrayList<>(); // 유저가 등록한 스팸 키워드

}