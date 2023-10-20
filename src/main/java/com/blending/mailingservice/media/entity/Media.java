package com.blending.mailingservice.media.entity;

import com.blending.mailingservice.mail.entity.Mail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "MEDIA")
public class Media {

    @Id @Column(name = "media_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "origin_file_name", columnDefinition = "TEXT")
    private String originFileName;

    @Column(name = "file_name", columnDefinition = "TEXT")
    private String fileName;

    @Column(name = "file_path", columnDefinition = "TEXT")
    private String filePath;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mail_id")
    private Mail mail;

}
