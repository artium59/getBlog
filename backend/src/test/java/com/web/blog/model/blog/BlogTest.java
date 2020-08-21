package com.web.blog.model.blog;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlogTest {

    @Test
    void getBid() {
        final Blog blog = Blog.builder().bid(1L).uid(2L).blogname("my blog").template_num(3L).visitors_num(456L).build();
        final Long bid = blog.getBid();

        assertEquals(1L, bid);
    }

    @Test
    void getUid() {
        final Blog blog = Blog.builder().bid(1L).uid(2L).blogname("my blog").template_num(3L).visitors_num(456L).build();
        final Long uid = blog.getUid();

        assertEquals(2L, uid);
    }

    @Test
    void getBlogname() {
        final Blog blog = Blog.builder().bid(1L).uid(2L).blogname("my blog").template_num(3L).visitors_num(456L).build();
        final String blogname = blog.getBlogname();

        assertEquals("my blog", blogname);
    }

    @Test
    void getTemplate_num() {
        final Blog blog = Blog.builder().bid(1L).uid(2L).blogname("my blog").template_num(3L).visitors_num(456L).build();
        final Long template_num = blog.getTemplate_num();

        assertEquals(3L, template_num);
    }

    @Test
    void getVisitors_num() {
        final Blog blog = Blog.builder().bid(1L).uid(2L).blogname("my blog").template_num(3L).visitors_num(456L).build();
        final Long visitors_num = blog.getVisitors_num();

        assertEquals(456L, visitors_num);
    }
}
