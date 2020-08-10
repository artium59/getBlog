package com.web.blog.dao.reply;

import java.util.List;
import java.util.Optional;

import com.web.blog.model.reply.Reply;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
    List<Reply> findAll();

    //@Query("SELECT p.pno, p.uid, p.title, p.content, p.heart, p.createDate, u.nickname FROM Posts p, User u WHERE p.pno = :pno and p.uid = u.uid")
    Optional<Reply> findByRno(@Param("rno") Long rno);

    //@Query("SELECT u.nickname FROM Posts p, User u WHERE p.pno = :pno and p.uid = u.uid")

    @Query("SELECT r FROM Reply r WHERE r.pno = :pno")
    List<Reply> findByPno(@Param("pno") Long pno);
}
