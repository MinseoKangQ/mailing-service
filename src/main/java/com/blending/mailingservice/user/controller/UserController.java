package com.blending.mailingservice.user.controller;

import com.blending.mailingservice.user.dto.UserLoginReq;
import com.blending.mailingservice.user.dto.UserLoginRes;
import com.blending.mailingservice.user.dto.UserSignUpDto;
import com.blending.mailingservice.user.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("mailing-service/api")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userServiceImpl;

    // 회원가입
    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody UserSignUpDto userSignUpDto) {
        UserSignUpDto result = userServiceImpl.signup(userSignUpDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginReq userLoginReq) {
        UserLoginRes result = userServiceImpl.login(userLoginReq);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
