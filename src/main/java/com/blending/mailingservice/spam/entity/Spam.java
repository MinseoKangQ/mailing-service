package com.blending.mailingservice.spam.entity;

import com.blending.mailingservice.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SPAM")
@EntityListeners(AuditingEntityListener.class)
public class Spam {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "spam_id")
    private Long id; // 스팸 등록 아이디 (PK)

    private String word; // 스팸 필터링 단어

    @CreatedDate
    @Column(name = "registered_at", nullable = false, updatable = false)
    private LocalDateTime registeredAt; // 스팸 등록 시간

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user; // 스팸을 등록한 유저

}
