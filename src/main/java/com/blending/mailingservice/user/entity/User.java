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
    private String id;

    private String password;

    @OneToMany(mappedBy = "sender")
    private List<Mail> sentMails = new ArrayList<>();

//    @OneToMany(mappedBy = "receiver")
//    private List<Mail> receivedMails = new ArrayList<>();

}
