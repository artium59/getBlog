package com.web.blog.model.posts;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class PostsListResponseDto {
    private Long pno;
    private Long uid;
    private String title;
    private String content;
    private Long heart;
    private LocalDateTime createDate;

    public PostsListResponseDto(Posts entity) {
        this.pno = entity.getPno();
        this.uid = entity.getUid();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.heart = entity.getHeart();
        this.createDate = entity.getCreateDate();
    }
}
