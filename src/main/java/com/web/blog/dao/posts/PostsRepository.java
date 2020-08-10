package com.web.blog.dao.posts;

import com.web.blog.model.posts.Posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p FROM Posts p ORDER BY p.pno DESC")
    List<Posts> findAllDesc();

    //@Query("SELECT p.pno, p.uid, p.title, p.content, p.heart, p.createDate, u.nickname FROM Posts p, User u WHERE p.pno = :pno and p.uid = u.uid")
    Optional<Posts> findByPno(@Param("pno") Long pno);

    @Query("SELECT u.nickname FROM Posts p, User u WHERE p.pno = :pno and p.uid = u.uid")
    String getUserNickname(@Param("pno") Long pno);

    List<Posts> findByTitleContaining(@Param("title") String title);
}