package com.web.blog.model.posts;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private Long pno;
    private Long uid;
    private String title;
    private String content;
    private Long heart;
    private String img;
    private LocalDateTime createDate;

    @Builder
    public PostsSaveRequestDto(Long pno, Long uid, String title, String content, Long heart, String img, LocalDateTime createDate){
        this.pno = pno;
        this.uid = uid;
        this.title = title;
        this.content = content;
        this.heart = heart;
        this.img = img;
        this.createDate = createDate;
    }

    public Posts toEntity(){
        return Posts.builder()
                .pno(pno)
                .uid(uid)
                .title(title)
                .content(content)
                .heart(heart)
                .img(img)
                .createDate(createDate)
                .build();
    }
}
