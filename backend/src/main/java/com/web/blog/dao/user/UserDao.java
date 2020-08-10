package com.web.blog.dao.user;

import java.util.Optional;

import com.web.blog.model.user.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    @Transactional(readOnly = true)
    Optional<User> getUserByEmail(String email);

    @Transactional(readOnly = true)
    Optional<User> getUserByUid(Long uid);

    Boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email, String password);

    // use executeQuery() -> executeUpdate()
    @Modifying
    // avoid javax.persistence.TransactionRequiredException
    @Transactional
    @Query(value = "DELETE user_roles, users FROM user_roles LEFT JOIN users ON user_roles.user_id = users.uid WHERE user_roles.user_id = :uid", nativeQuery = true)
    void deleteByUid(@Param("uid") Long uid);
}
