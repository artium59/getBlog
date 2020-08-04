package com.web.blog.model.reply;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReplyUpdateRequstDto {
    private String replytext;
    private String replyer;
    private LocalDateTime createDate;

    @Builder
    public ReplyUpdateRequstDto(String replytext, String replyer, LocalDateTime createDate){
        this.replytext = replytext;
        this.replyer = replyer;
        this.createDate = createDate;
    }
}