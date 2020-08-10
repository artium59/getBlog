package com.web.blog.dao.user;

import java.util.Optional;

import com.web.blog.model.user.ERole;
import com.web.blog.model.user.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
