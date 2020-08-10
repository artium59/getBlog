package com.web.blog.controller.account;

import java.util.Optional;

import javax.validation.Valid;

import com.web.blog.dao.user.UserDao;
import com.web.blog.model.BasicResponse;
import com.web.blog.payload.request.SignupRequest;
import com.web.blog.model.user.User;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
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
    UserDao userDao;

    /* @GetMapping("/login")
    @ApiOperation(value = "로그인")
    public Object login(@RequestParam(required = true) final String email,
            @RequestParam(required = true) final String password) {

        Optional<User> userOpt = userDao.findUserByEmailAndPassword(email, password);

        ResponseEntity response = null;

        if (userOpt.isPresent()) {
            final BasicResponse result = new BasicResponse();
            result.status = true;
            result.data = "success";
            result.token = 1;
            response = new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            response = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return response;
    }

    @PostMapping("/signup")
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
        result.message = "Congratulations!";

        return new ResponseEntity<>(result, HttpStatus.OK);
    } */

    @GetMapping("/userinfo")
    @ApiOperation(value = "유저 정보 얻기")
    public Object getUserInfo(@RequestParam(required = true) final String accessToken) {
        
        final BasicResponse result = new BasicResponse();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /* @PostMapping("/modify")
    @ApiOperation(value = "수정하기")
    public Object modify(@Valid @RequestBody SignupRequest request) {
        User user = userDao.getUserByEmail(request.getEmail());
        final BasicResponse result = new BasicResponse();

        if (user == null) {
            result.status = false;
            result.data = "fail";

            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        else {
            userDao.save(User.builder()
                            .uid(user.getUid())
                            .password(request.getPassword())
                            .nickname(request.getNickname())
                            .build());

            result.status = true;
            result.data = "success";
            result.token = 1;

            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    @GetMapping("/withdrawal")
    @ApiOperation(value = "탈퇴하기")
    public Object withdrawal(@RequestParam(required = true) final String email) {
        User user = userDao.getUserByEmail(email);

        ResponseEntity response = null;

        if (user != null) {
            userDao.deleteUserByEmail(email);

            final BasicResponse result = new BasicResponse();
            result.status = true;
            result.data = "success";
            result.token = 0;
            response = new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            response = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return response;
    } */
}