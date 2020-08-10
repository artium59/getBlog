package com.web.blog.controller.account;

import java.util.Optional;

import javax.validation.Valid;

import com.web.blog.dao.user.UserDao;
import com.web.blog.model.BasicResponse;
import com.web.blog.payload.request.SignupRequest;
import com.web.blog.payload.request.UserRequest;
import com.web.blog.payload.response.UserResponse;
import com.web.blog.security.jwt.JwtUtils;
import com.web.blog.model.user.User;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.beans.factory.annotation.Autowired;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@ApiResponses(value = { @ApiResponse(code = 401, message = "Unauthorized", response = BasicResponse.class),
        @ApiResponse(code = 403, message = "Forbidden", response = BasicResponse.class),
        @ApiResponse(code = 404, message = "Not Found", response = BasicResponse.class),
        @ApiResponse(code = 500, message = "Failure", response = BasicResponse.class) })

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserDao userDao;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    PasswordEncoder encoder;

    /* @PostMapping("/signup")
    @ApiOperation(value = "가입하기")
    public Object signup(@Valid @RequestBody SignupRequest request) {
        // 이메일, 닉네임 중복처리 필수
        // 회원가입단을 생성해 보세요.
        User user = userDao.getUserByEmail(request.getEmail());
        
        final BasicResponse result = new BasicResponse();
        result.status = true;
        result.token = 1;

        if (user != null) {
            result.data = "fail";
            result.message = "Account for that email already exists.";

            return new ResponseEntity<>(result, HttpStatus.OK);
        }

        User user1 = User.builder()
                            .email(request.getEmail())
                            .password(request.getPassword())
                            .nickname(request.getNickname())
                            .build();

        // System.out.println(user1);
        userDao.save(user1);

        result.data = "success";

        return new ResponseEntity<>(result, HttpStatus.OK);
    } */

    @GetMapping("/userinfo")
    @ApiOperation(value = "유저 정보 얻기")
    public Object getUserInfo(@RequestParam(required = true) final String accessToken) {
        User user = userDao.getUserByUid(jwtUtils.getUidFromJwtToken(accessToken))
                            .orElseThrow(() -> new IllegalArgumentException("유저 정보 얻기 실패"));

        return new ResponseEntity<>(new UserResponse(user), HttpStatus.OK);
    }

    @PutMapping("/modify")
    @ApiOperation(value = "수정하기")
    public Object modify(@Valid @RequestBody UserRequest request) {
        final BasicResponse result = new BasicResponse();
        User user = userDao.getUserByUid(jwtUtils.getUidFromJwtToken(request.getAccessToken()))
                            .orElseThrow(() -> new IllegalArgumentException("유저 정보 얻기 실패"));

        try {
            user.setNickname(request.getNickname());
            user.setPassword(encoder.encode(request.getPassword()));
            user.setIntroduce(request.getIntroduce());
            user.setImageUrl(request.getImageUrl());

            userDao.save(user);

            result.status = true;
            result.data = "success";

            Authentication authentication = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(user.getEmail(), request.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);
            result.accessToken = jwtUtils.generateJwtToken(authentication);

        } catch (Exception e) {
            result.status = false;
            result.data = "fail";
            result.message = "회원 정보 수정 실패";

            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/withdrawal")
    @ApiOperation(value = "탈퇴하기")
    public Object withdrawal(@Valid @RequestBody String accessToken) {
        final BasicResponse result = new BasicResponse();

        try {
            userDao.deleteByUid(jwtUtils.getUidFromJwtToken(accessToken));

            result.status = true;
            result.data = "success";
        } catch (Exception e) {
            result.status = false;
            result.data = "fail";
            result.message = "회원 탈퇴 실패";

            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
