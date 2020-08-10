package com.web.blog.dao.user;

import java.util.Optional;

import com.web.blog.model.user.ERole;
import com.web.blog.model.user.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RoleDao extends JpaRepository<Role, Long> {

    @Transactional(readOnly = true)
    Optional<Role> findByName(ERole name);
}
