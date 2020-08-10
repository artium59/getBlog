package com.web.blog.model.reply;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Reply {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;

    private Long pno;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String replytext;

    private String replyer;

    @Column(insertable = false, updatable = false)
    @CreatedDate
    private LocalDateTime createDate;

    @Builder
    public Reply(Long rno, Long pno, String replytext, String replyer, Long heart, LocalDateTime createDate){
        this.rno = rno;
        this.pno = pno;
        this.replytext = replytext;
        this.replyer = replyer;
        this.createDate = createDate;
    }

    public void update(String replytext, String replyer, LocalDateTime createDate) {
        this.replytext = replytext;
        this.replyer = replyer;
        this.createDate = createDate;
    }
}
