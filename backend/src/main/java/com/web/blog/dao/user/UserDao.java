package com.web.blog.dao.user;

import java.util.Optional;

import com.web.blog.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    User getUserByEmail(String email);

    Boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email, String password);

    // @Query("DELETE FROM user WHERE user.email = :email")
    void deleteUserByEmail(String email);
}
