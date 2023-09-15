package com.blending.mailingservice.user.entity;

import com.blending.mailingservice.mail.entity.Mail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USER")
public class User {

    @Id
    @Column(name = "user_id")
    private String id; // 유저 아이디 (PK)

    @Column(name = "user_pw")
    private String password; // 유저 비밀번호

    @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL)
    private List<Mail> receivedMails = new ArrayList<>(); // 유저가 받은 메일들

    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL)
    private List<Mail> sentMails = new ArrayList<>(); // 유저가 보낸 메일들

}
