// package com.web.blog.config;

// import java.util.Arrays;
// import java.util.List;

// import com.web.blog.dao.user.RoleDao;
// import com.web.blog.dao.user.UserDao;
// import com.web.blog.model.user.ERole;
// import com.web.blog.model.user.Role;
// import com.web.blog.model.user.User;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;

// import lombok.RequiredArgsConstructor;

// @RequiredArgsConstructor
// @Service
// // CommandLineRunner.run(): 실행 시 자동 실행
// public class DBInit implements CommandLineRunner {

//     @Autowired
//     private final UserDao userDao;

//     @Autowired
//     private final RoleDao roleDao;

//     @Autowired
//     private final PasswordEncoder passwordEncoder;

//     @Override
//     public void run(String... args) throws Exception {
//         roleDao.deleteAll();
//         userDao.deleteAll();

//         Role userRole = new Role(ERole.ROLE_USER);
//         Role modRole = new Role(ERole.ROLE_MODERATOR);
//         Role adminRole = new Role(ERole.ROLE_ADMIN);

//         List<Role> roles = Arrays.asList(userRole, modRole, adminRole);
//         this.roleDao.saveAll(roles);

//         User admin = new User("admin", "admin", passwordEncoder.encode("admin"));
//         User test = new User("test", "test@test.com", passwordEncoder.encode("test1234"));

//         List<User> users = Arrays.asList(admin, test);
//         this.userDao.saveAll(users);
//     }
// }
