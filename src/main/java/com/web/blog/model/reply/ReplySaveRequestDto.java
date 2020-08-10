package com.web.blog.model.reply;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReplySaveRequestDto {
    private Long rno;
    private Long pno;
    private String replytext;
    private String replyer;
    private LocalDateTime createDate;


    @Builder
    public ReplySaveRequestDto(Long rno, Long pno, String replytext, String replyer, Long heart, LocalDateTime createDate){
        this.rno = rno;
        this.pno = pno;
        this.replytext = replytext;
        this.replyer = replyer;
        this.createDate = createDate;
    }

    public Reply toEntity(){
        return Reply.builder()
                .rno(rno)
                .pno(pno)
                .replytext(replytext)
                .replyer(replyer)
                .createDate(createDate)
                .build();
    }

    
}