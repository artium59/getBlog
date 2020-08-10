package com.web.blog.model.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.web.blog.model.user.User;

import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Posts {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pno;

    private Long uid;
    
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private Long heart;

    @Column(insertable = false, updatable = false)
    @CreatedDate
    private LocalDateTime createDate;

    //entity에 추가 안하고 할 수 있는 방법이 없을까
    @ManyToOne
    @JoinColumn(name="uid", insertable =false ,updatable = false)
    private User user;
    
    @Builder
    public Posts(Long pno, Long uid, String title, String content, Long heart, LocalDateTime createDate){
        this.pno = pno;
        this.uid = uid;
        this.title = title;
        this.content = content;
        this.heart = heart;
        this.createDate = createDate;
    }

    public void update(String title, String content, LocalDateTime createDate) {
        this.title = title;
        this.content = content;
        this.createDate = createDate;
    }
}
