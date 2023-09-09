package com.blending.mailingservice.mail.entity;

import com.blending.mailingservice.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MAIL")
@EntityListeners(AuditingEntityListener.class)
public class Mail {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User sender;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "receiver_id")
//    private User receiver;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime created_at;

    private String title;

    private String content;

//    private File attached_file = null;

    private Boolean is_read = false;

    @Column(nullable = false, updatable = false)
    private LocalDateTime read_at;

    private Boolean is_star = false;
}
