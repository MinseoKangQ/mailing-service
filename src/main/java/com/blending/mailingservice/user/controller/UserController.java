package com.blending.mailingservice.user.controller;

import com.blending.mailingservice.user.dto.UserSignUpDto;
import com.blending.mailingservice.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/mailing-service")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/signup")
    public String signUp() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signUpSuccess(@RequestBody UserSignUpDto user) {
        String result = userService.signUp(user);
        return result;
    }
}
