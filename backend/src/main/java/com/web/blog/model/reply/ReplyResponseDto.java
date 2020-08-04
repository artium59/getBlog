package com.web.blog.model.reply;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class ReplyResponseDto {
    private Long rno;
    private Long pno;
    private String replytext;
    private String replyer;
    private LocalDateTime createDate;


    public ReplyResponseDto(Reply entity){
        this.rno = entity.getRno();
        this.pno = entity.getPno();
        this.replytext = entity.getReplytext();
        this.replyer = entity.getReplyer();
        this.createDate = entity.getCreateDate();
    }
}