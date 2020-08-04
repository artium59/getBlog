package com.web.blog.model.posts;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {
    private String title;
    private String content;
    private LocalDateTime createDate;
    
    @Builder
    public PostsUpdateRequestDto(String title, String content, LocalDateTime createDate) {
        this.title = title;
        this.content = content;
        this.createDate = createDate;
    }
}