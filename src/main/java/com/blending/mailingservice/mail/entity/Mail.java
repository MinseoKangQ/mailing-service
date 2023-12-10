package com.blending.mailingservice.mail.entity;

import com.blending.mailingservice.media.entity.Media;
import com.blending.mailingservice.user.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MAIL")
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Mail {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "mail_id")
    private Long id; // 메일 아이디 (PK)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id")
    private User sender; // 발송인

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_id")
    private User receiver; // 수신인

    @JsonIgnore
    @OneToMany(mappedBy = "mail", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Media> mediaList = new ArrayList<>();

    private String title; // 메일 제목

    @Column(columnDefinition = "TEXT")
    private String content; // 메일 내용

    @CreatedDate
    @Column(name = "sent_at", nullable = false, updatable = false)
    private LocalDateTime sentAt; // 발송인이 메일 전송한 시간

    @Builder.Default
    @Column(name = "read_at")
    private LocalDateTime readAt = null; // 수신인이 메일 읽은 시간

    @Builder.Default
    @Column(name = "is_spam")
    private Boolean isSpam = false; // 스팸 여부

    @Builder.Default
    @Column(name = "is_read")
    private Boolean isRead = false; // 읽음 여부

    @Builder.Default
    @Column(name = "is_important")
    private Boolean isImportant = false; // 중요 메일 여부
}
