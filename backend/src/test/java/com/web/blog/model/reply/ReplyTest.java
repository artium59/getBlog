package com.web.blog.model.reply;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ReplyTest {

    @Test
    void getRno() {
        final LocalDateTime localDateTime = LocalDateTime.of(2020, 8, 20, 11, 0);
        final Reply reply = Reply.builder().rno(1L).pno(2L).replytext("This is reply").replyer("reply_tester").createDate(localDateTime).build();
        final Long rno = reply.getRno();

        assertEquals(1L, rno);
    }

    @Test
    void getPno() {
        final LocalDateTime localDateTime = LocalDateTime.of(2020, 8, 20, 11, 0);
        final Reply reply = Reply.builder().rno(1L).pno(2L).replytext("This is reply").replyer("reply_tester").createDate(localDateTime).build();
        final Long pno = reply.getPno();

        assertEquals(2L, pno);
    }

    @Test
    void getReplytext() {
        final LocalDateTime localDateTime = LocalDateTime.of(2020, 8, 20, 11, 0);
        final Reply reply = Reply.builder().rno(1L).pno(2L).replytext("This is reply").replyer("reply_tester").createDate(localDateTime).build();
        final String replytext = reply.getReplytext();

        assertEquals("This is reply", replytext);
    }

    @Test
    void getReplyer() {
        final LocalDateTime localDateTime = LocalDateTime.of(2020, 8, 20, 11, 0);
        final Reply reply = Reply.builder().rno(1L).pno(2L).replytext("This is reply").replyer("reply_tester").createDate(localDateTime).build();
        final String replyer = reply.getReplyer();

        assertEquals("reply_tester", replyer);
    }

    @Test
    void getCreateDate() {
        final LocalDateTime localDateTime = LocalDateTime.of(2020, 8, 20, 11, 0);
        final Reply reply = Reply.builder().rno(1L).pno(2L).replytext("This is reply").replyer("reply_tester").createDate(localDateTime).build();
        final LocalDateTime createDate = reply.getCreateDate();

        assertEquals(localDateTime, createDate);
    }
}
